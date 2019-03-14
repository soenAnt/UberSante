package application.controller;

import application.model.Booking;
import application.model.Patient;
import application.model.Payment;
import application.service.ProxyPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.*;

@Controller

@SessionAttributes(value={"user", "booking"})
public class PaymentController {
    @Autowired
    ProxyPayment paymentProxy;

    @GetMapping("/payment")
    public String paymentPage(Model model) {

        Booking booking = (Booking) ((BindingAwareModelMap) model).get("booking");
        model.addAttribute("payment", new Payment());
        model.addAttribute("booking", booking);
        return "payment";
    }

    @PostMapping("/payment")
    public String payment(@ModelAttribute Payment paymentForm, Model model){
        Payment payment = paymentProxy.processPayment(paymentForm.getNumber(), paymentForm.getMonth(), paymentForm.getYear(), paymentForm.getCvc());
        System.out.println(payment.getCvc() + " | " + payment.getNumber());
        Patient patient = (Patient) ((BindingAwareModelMap) model).get("user");
        Booking booking = (Booking) ((BindingAwareModelMap) model).get("booking");
        model.addAttribute("payment", payment);
        model.addAttribute("user", patient);
        model.addAttribute("booking", booking);
        return "checkout";
    }
}