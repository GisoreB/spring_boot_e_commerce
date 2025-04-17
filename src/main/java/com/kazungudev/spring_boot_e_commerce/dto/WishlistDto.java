package com.kazungudev.spring_boot_e_commerce.dto;


import com.kazungudev.spring_boot_e_commerce.models.Product;
import com.kazungudev.spring_boot_e_commerce.models.User;
import jakarta.validation.constraints.NotNull;

public class WishlistDto {
    @NotNull
    private Product product;

    @NotNull
    private User user;

    public WishlistDto(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
