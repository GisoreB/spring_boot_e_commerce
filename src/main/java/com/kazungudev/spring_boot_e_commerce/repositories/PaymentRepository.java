package com.kazungudev.spring_boot_e_commerce.repositories;



import com.kazungudev.spring_boot_e_commerce.models.Payment;
import com.kazungudev.spring_boot_e_commerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    public List<Payment> findByUser(User user);
    public Payment findById(int id);

    @Query("SELECT SUM(p.amount) FROM Payment p")
    Double getTotalAmount();
}
