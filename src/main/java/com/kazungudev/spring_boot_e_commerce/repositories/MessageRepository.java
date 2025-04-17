package com.kazungudev.spring_boot_e_commerce.repositories;



import com.kazungudev.spring_boot_e_commerce.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
}
