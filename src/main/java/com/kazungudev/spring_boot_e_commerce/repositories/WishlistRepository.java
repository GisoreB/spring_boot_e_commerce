package com.kazungudev.spring_boot_e_commerce.repositories;



import com.kazungudev.spring_boot_e_commerce.models.Product;
import com.kazungudev.spring_boot_e_commerce.models.User;
import com.kazungudev.spring_boot_e_commerce.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

    List<Wishlist> findByUser(User user);

    @Query("SELECT COUNT(w) > 0 FROM Wishlist w WHERE w.product = :product AND w.user = :user")
    boolean existsByProductAndUser(@Param("product") Product product, @Param("user") User user);

    Wishlist findByProductAndUser(Product product, User user);
}
