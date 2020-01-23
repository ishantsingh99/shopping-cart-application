package com.caseStudy.eCart.repo;

import com.caseStudy.eCart.model.userDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface userDetailsRepository extends JpaRepository<userDetails, Long> {
    Optional<userDetails> findByUsername(String username);

    userDetails findByUid(Long uid);

}

