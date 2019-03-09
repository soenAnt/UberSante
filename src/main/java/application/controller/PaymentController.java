package application.controller;

import application.model.Payment;
import application.service.ProxyPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {

    @Autowired
    ProxyPayment paymentProxy;

    @GetMapping("/payment")
    public String paymentPage(Model model) {
        model.addAttribute("payment", new Payment());
        return "payment";
    }

    @PostMapping("/payment")
    public String payment(@ModelAttribute Payment paymentForm, Model model){
        Payment payment = paymentProxy.processPayment(paymentForm.getNumber(), paymentForm.getMonth(), paymentForm.getYear(), paymentForm.getCvc());

        model.addAttribute("payment", payment);
        return "/checkout";
    }
}
