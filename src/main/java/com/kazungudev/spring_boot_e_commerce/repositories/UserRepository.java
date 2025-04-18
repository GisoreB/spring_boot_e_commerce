package com.kazungudev.spring_boot_e_commerce.repositories;



import com.kazungudev.spring_boot_e_commerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);

    public User findByName(String name);

    public User findById(int id);

    public boolean existsByEmail(String email);

    public List<User> findByRole(String role);

    @Query("SELECT COUNT(u) FROM User u")
    public long countUsers();
}
