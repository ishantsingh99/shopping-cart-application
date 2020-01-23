package com.caseStudy.eCart.repo;
import com.caseStudy.eCart.model.Product;
import com.caseStudy.eCart.model.cart;
import com.caseStudy.eCart.model.userDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface cartRepository extends JpaRepository<cart, Long> {
List<cart> findAllByUser(userDetails user);
    Optional<cart> findByUserAndProduct(userDetails user, Product product);

    List<cart> findByUserAndProduct_Active(userDetails user, int i);

    // cart findByproductid(Long id);

//    cart findByUserid(Long id1);

}
