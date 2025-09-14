package com.hospital_management_system.demo.service;

import com.hospital_management_system.demo.entity.Bill;
import com.hospital_management_system.demo.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Bill generateBill(Bill bill) {
        // Add billing validation logic if needed
        bill.setPaymentStatus(Bill.PaymentStatus.UNPAID);
        return billRepository.save(bill);
    }

    public Optional<Bill> getBillDetails(int id) {
        return billRepository.findById(id);
    }

    public void processPayment(int id) {
        Bill bill = billRepository.findById(id).orElse(null);
        if (bill != null) {
            bill.setPaymentStatus(Bill.PaymentStatus.PAID);
            billRepository.save(bill);
        }
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }
}
