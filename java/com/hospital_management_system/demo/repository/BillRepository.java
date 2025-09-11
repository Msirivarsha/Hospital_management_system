package com.hospital_management_system.demo.repository;

import com.hospital_management_system.demo.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
