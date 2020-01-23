package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.model.cart;
import com.caseStudy.eCart.model.orderHistory;
import com.caseStudy.eCart.repo.cartRepository;
import com.caseStudy.eCart.services.cartService;
import com.caseStudy.eCart.services.currentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@Controller
@RequestMapping("/cart")
public class cartController {
    @Autowired
    private cartService cartService;
    @Autowired
    private currentUserService currentUserService;
    @Autowired
    private cartRepository cartRepository;

    @Autowired
    public cartController(cartService cartService1, currentUserService currentUserService1) {
        this.cartService = cartService1;
        this.currentUserService = currentUserService1;
    }
    @RequestMapping(value = "/removeproduct/recieve/{productid}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<cart> removeproduct(@PathVariable Long productid, Principal principal) {
        return cartService.removeproduct(currentUserService.getuserid(principal), productid);
    }
    @RequestMapping(value = "/addtocart/recieve/{productid}", method = RequestMethod.GET)
    @ResponseBody
    public cart addProduct(@PathVariable Long productid, Principal principal) {
        return cartService.addProduct(currentUserService.getuserid(principal), productid);
    }
    @RequestMapping(value = "/removefromcart/recieve/{productid}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<cart> removefromcart(@PathVariable Long productid, Principal principal) {
        return cartService.removefromcart(currentUserService.getuserid(principal), productid);
    }
    @RequestMapping(value = "/showcart/recieve", method = RequestMethod.GET)
    @ResponseBody
    public List<cart> showcart(Principal principal) {
        return cartService.showcart(currentUserService.getuserid(principal), principal);
    }
    @RequestMapping(value = "/clearcart/recieve", method = RequestMethod.GET)
    @ResponseBody
    public List<cart> clearcart(Principal principal) {
        return cartService.clearcart(currentUserService.getuserid(principal),principal);
    }
    @GetMapping(value = "/checkout")
    @ResponseBody
    public double checkout(Principal principal) {
        return cartService.checkout(currentUserService.getuserid(principal),principal);
    }
    @GetMapping(value = "/showOrderHistory")
    @ResponseBody
    public List<orderHistory> showorderhistory(Principal principal ) {
        return cartService.showorderhistory(currentUserService.getuserid(principal),principal);
    }
    @GetMapping(value = "/quantity")
    @ResponseBody
    public int calquantity(Principal principal ) {
        return cartService.calquantity(currentUserService.getuserid(principal),principal);
    }
    @GetMapping(value = "/price")
    @ResponseBody
    public double calprice(Principal principal ) {
        return cartService.calprice(currentUserService.getuserid(principal),principal);
    }
}
