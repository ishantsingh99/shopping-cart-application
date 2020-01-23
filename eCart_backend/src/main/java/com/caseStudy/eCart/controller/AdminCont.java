//package com.caseStudy.eCart.controller;
//
//import com.caseStudy.eCart.model.Product;
//import com.caseStudy.eCart.model.cart;
//import com.caseStudy.eCart.services.cartService;
//import com.caseStudy.eCart.services.currentUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin()
//@RestController
//@RequestMapping(path = "/admin")
//public class AdminCont {
//    @Autowired
//    private cartService cartService;
//    @Autowired
//    private currentUserService currentUserService;
//
//    @Autowired
//    public AdminCont(cartService cartService1, currentUserService currentUserService1) {
//        this.cartService = cartService1;
//        this.currentUserService = currentUserService1;
//    }
//    @PostMapping("/add-item")
//    public cart addProduct(@RequestBody Product product) {
//        return cartService.addProduct(product);
//    }
//
//}
