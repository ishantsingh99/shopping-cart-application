package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.model.orderHistory;
import com.caseStudy.eCart.repo.orderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/order")
public class orderHistoryController {
    @Autowired
    orderHistoryRepository orderHistory;
    @GetMapping("/orders")
    public List<orderHistory> getAllDetails()
    {
        return orderHistory.findAll();
    }
}
