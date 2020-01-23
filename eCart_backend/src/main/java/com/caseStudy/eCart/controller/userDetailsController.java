package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.exception.ResourceNotFound;
import com.caseStudy.eCart.model.userDetails;
import com.caseStudy.eCart.repo.userDetailsRepository;
import com.caseStudy.eCart.services.currentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin()
@RestController
@RequestMapping("/api1")
public class userDetailsController {
    @Autowired
   currentUserService currentUserService;
    @Autowired
    userDetailsRepository userDetailsRepository;
    @Autowired
    public userDetailsController(currentUserService currentUserService) {
        this.currentUserService = currentUserService;

    }
    @GetMapping("/usergetall")
    public List<userDetails> getAllUsers(){
        return userDetailsRepository.findAll();
    }

    @GetMapping("/Getuser")
    @ResponseBody
    public userDetails getuser(Principal principal) {
        return currentUserService.getuserprofile(currentUserService.getuserid(principal),principal);
    }
    @PostMapping("/adduser")
    public userDetails createuser(@Valid @RequestBody userDetails user) {

        user.setActive(1);
        user.setRole("user");
        return userDetailsRepository.save(user);
    }
    @PutMapping("/updateuser")
    public userDetails updateuser(@Valid @RequestBody userDetails userdetails, Principal principal) {

        userDetails users = currentUserService.getuserprofile(currentUserService.getuserid(principal),principal);
        users.setUsername(userdetails.getUsername());
        users.setActive(userdetails.getActive());
        users.setRole(userdetails.getRole());
        users.setPassword(userdetails.getPassword());
        userDetails updatedUser = userDetailsRepository.save(users);
        return updatedUser;
    }
    @GetMapping("username/{username}")
    public Optional<userDetails> getUsername(@PathVariable(value = "username")String u){
        return userDetailsRepository.findByUsername(u);
    }
}


