package com.caseStudy.eCart.services;

import com.caseStudy.eCart.model.Product;
import com.caseStudy.eCart.model.cart;
import com.caseStudy.eCart.model.orderHistory;
import com.caseStudy.eCart.model.userDetails;
import com.caseStudy.eCart.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.caseStudy.eCart.repo.cartRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class cartService {
    @Autowired
    private productRepository productRepository;
    @Autowired
    private cartRepository cartRepository;
    @Autowired
    private userDetailsRepository userDetailsRepository;
    @Autowired
    private orderHistoryRepository orderHistoryRepository;

    public cart addProduct(Long uid, Long pid) {
        Product product = productRepository.findByPid(pid);
        userDetails user = userDetailsRepository.findByUid(uid);

        if (cartRepository.findByUserAndProduct(user, product).isPresent()) {
            cart car = cartRepository.findByUserAndProduct(user, product).get();
            car.setQuantity(car.getQuantity() + 1);
            car.setTotalprice(car.getQuantity()*product.getPrice());
            cartRepository.save(car);
        } else {
            cart c = new cart(product, user, 1,product.getPrice());
            cartRepository.save(c);
        }
        return cartRepository.findByUserAndProduct(user, product).get();
    }

    public Optional<cart> removeproduct(Long uid, Long pid) {
        Product product1 = productRepository.findByPid(pid);
        userDetails user1 = userDetailsRepository.findByUid(uid);
            cart car1 = cartRepository.findByUserAndProduct(user1, product1).get();
        cartRepository.delete(car1);
        return cartRepository.findByUserAndProduct(user1, product1);
    }
    public double checkout(Long user_id, Principal principal) {
        userDetails users = userDetailsRepository.findByUid(user_id);
        List<cart> cartList = cartRepository.findAllByUser(users);
        int q = 0;
        int price=0;
        for (cart cart: cartList) {
            orderHistory orderHistory = new orderHistory();
            orderHistory.setUser(users);
            orderHistory.setProduct(cart.getProduct());
            price = price+cart.getTotalprice();
            q = q + cart.getQuantity();
            orderHistory.setDate();
            orderHistory.setTotalquantity(q);
            orderHistory.setTotalprice(price);
            orderHistoryRepository.save(orderHistory);
        }
        clearcart(user_id,principal);
        return 0;
    }
    public int calquantity(Long user_id,Principal principal) {
        userDetails users = userDetailsRepository.findByUid(user_id);
        List<cart> cartList = cartRepository.findAllByUser(users);
        int q = 0;
        for (cart cart: cartList) {
            q = q + cart.getQuantity();
        }
        return q;
    }
    public int calprice(Long user_id,Principal principal) {
        userDetails users = userDetailsRepository.findByUid(user_id);
        List<cart> cartList = cartRepository.findAllByUser(users);
        int q = 0;
        for (cart cart: cartList) {
            q = q + cart.getQuantity() * cart.getProduct().getPrice();
        }
        return q;
    }
    public List<cart> showcart(Long uid, Principal principal) {
        userDetails user = userDetailsRepository.findByUid((uid));

        return cartRepository.findByUserAndProduct_Active(user, 1);
    }

    public List<cart> clearcart(Long uid,  Principal principal) {
        userDetails user = userDetailsRepository.findByUid((uid));
        List<cart> cartitems = cartRepository.findByUserAndProduct_Active(user, 1);
        for (cart cart : cartitems) {
            cartRepository.deleteById(cart.getId());
        }
        return cartRepository.findAllByUser(user);
    }

    public Optional<cart> removefromcart(Long uid, Long pid) {
        Product product1 = productRepository.findByPid(pid);
        userDetails user1 = userDetailsRepository.findByUid(uid);
        if (cartRepository.findByUserAndProduct(user1, product1).get().getQuantity() <= 1) {
            cart car1 = cartRepository.findByUserAndProduct(user1, product1).get();
            cartRepository.delete(car1);
        } else {
            cart car1 = cartRepository.findByUserAndProduct(user1, product1).get();
            car1.setQuantity(car1.getQuantity() - 1);
            car1.setTotalprice(car1.getTotalprice()-product1.getPrice());
            cartRepository.save(car1);
        }
        return cartRepository.findByUserAndProduct(user1,product1);
    }
    public List<orderHistory> showorderhistory(Long user_id,Principal principal){
        userDetails users = userDetailsRepository.findByUid(user_id);
        return orderHistoryRepository.findAllByUser(users);
    }

}

