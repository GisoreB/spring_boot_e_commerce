package com.kazungudev.spring_boot_e_commerce.services;



import com.kazungudev.spring_boot_e_commerce.models.Order;
import com.kazungudev.spring_boot_e_commerce.models.Payment;
import com.kazungudev.spring_boot_e_commerce.models.Product;
import com.kazungudev.spring_boot_e_commerce.models.User;
import com.kazungudev.spring_boot_e_commerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    public List<Order> getOrder(int id){
        return orderRepository.findByUser(userService.findById(id));
    }

    public List<Order> findByUserAndPayment(User user, Payment payment){
        return orderRepository.findByUserAndPayment(user, payment);
    }

    @Transactional
    public void addToOrder(Product product, int quantity, User user, Payment payment) {
        Order order = new Order();
        order.setProduct(product);
        order.setUser(user);
        order.setQuantity(quantity);
        order.setPayment(payment);
        orderRepository.save(order);
    }
    public long getOrdersCount() {
        return orderRepository.count();
    }

    public Double getTotalSalesAmount(User seller) {
        return orderRepository.calculateTotalSalesAmount(seller);
    }

    public Long getTotalProductsSold(User seller) {
        return orderRepository.calculateTotalProductsSold(seller);
    }
}
