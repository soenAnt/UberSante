package application.controller;

import application.interfaces.IPayment;
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
    ProxyPayment payment;

    @GetMapping("/payment")
    public String paymentPage(Model model) {
        model.addAttribute("payment", new Payment());
        return "payment";
    }

    @PostMapping("/payment")
    public void payment(@ModelAttribute Payment paymentForm){
        boolean result = payment.processPayment(paymentForm.getNumber(), paymentForm.getMonth(), paymentForm.getYear(), paymentForm.getCvc());
        System.out.println(result);
    }
}
