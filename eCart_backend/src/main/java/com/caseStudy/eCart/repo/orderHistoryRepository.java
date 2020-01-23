package com.caseStudy.eCart.repo;

import com.caseStudy.eCart.model.orderHistory;
import com.caseStudy.eCart.model.userDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface orderHistoryRepository extends JpaRepository<orderHistory,Long> {
    List<orderHistory> findAllByUser(userDetails users);
}
