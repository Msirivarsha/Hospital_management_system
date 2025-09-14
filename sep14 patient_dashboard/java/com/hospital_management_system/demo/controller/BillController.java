package com.hospital_management_system.demo.controller;


import com.hospital_management_system.demo.entity.Bill;
import com.hospital_management_system.demo.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping
    public String listBills(Model model) {
        model.addAttribute("bills", billService.getAllBills());
        return "bills";
    }

    @GetMapping("/generate")
    public String showGenerateForm(Model model) {
        model.addAttribute("bill", new Bill());
        return "generate-bill";
    }

    @PostMapping("/generate")
    public String generateBill(@ModelAttribute Bill bill) {
        billService.generateBill(bill);
        return "redirect:/bills";
    }

    @GetMapping("/details/{id}")
    public String getBillDetails(@PathVariable("id") int id, Model model) {
        model.addAttribute("bill", billService.getBillDetails(id).orElse(null));
        return "bill-details";
    }

    @PostMapping("/pay/{id}")
    public String processPayment(@PathVariable("id") int id) {
        billService.processPayment(id);
        return "redirect:/bills";
    }
}

