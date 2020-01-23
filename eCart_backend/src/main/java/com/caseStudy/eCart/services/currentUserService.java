package com.caseStudy.eCart.services;

import com.caseStudy.eCart.model.userDetails;
import com.caseStudy.eCart.repo.userDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;
@Service
public class currentUserService {

    @Autowired
    userDetailsRepository userDetailsRepository;
    public Optional<userDetails> CurrentUser(Principal principal){
        String user = principal.getName();
        return userDetailsRepository.findByUsername(user);
    }
    public Long getuserid(Principal principal){
        String user = principal.getName();
        Long id = userDetailsRepository.findByUsername(user).get().getUid();
        return id;
    }
    public String getuserrole(Principal principal){
        return userDetailsRepository.findByUsername(principal.getName()).get().getRole();
    }
    public userDetails getuserprofile(Long uid,Principal principal){
        return (userDetails) userDetailsRepository.findByUid(uid);
    }
}
