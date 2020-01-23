package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.model.Product;
import com.caseStudy.eCart.repo.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@CrossOrigin()
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private productRepository productRepository;

    public ProductController(productRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path="/api")
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }
    @GetMapping("/getbyid/{id}")
    public Product getProductById(@PathVariable(value = "id") Long noteId) throws Exception
    {
        return productRepository.findById(noteId)
                .orElseThrow(() -> new Exception("cannot find item"));
    }
//    @GetMapping("/get/{category}")
//    public List<Product> getProductByCategory(@PathVariable(value="category")String category)
//    {
//        return productRepository.findAllByCategory(category);
//    }
    @GetMapping("/get/{price}")
    public List<Product> getProductByPrice(@PathVariable(value="price")int price)
    {
        return productRepository.findAllByPrice(price);
    }
//    @GetMapping("/get/{category}/{price1}/{price2}")
//    public List<Product> getProductByPrice(@PathVariable(value="category")String c,@PathVariable(value="price1")int p,@PathVariable(value="price2")int p2)
//    {
//        return productRepository.findByCategoryAndPriceBetween(c,p,p2);
//    }
    @GetMapping("/get/{price1}/between/{price2}")
    public List<Product> getProductByPriceBtw(@PathVariable(value="price1")int p,@PathVariable(value="price2")int p2)
    {
        return productRepository.findAllByPriceBetween(p,p2);
    }
    @GetMapping("/cat/{category}")
    public List<Product> getByCategory(@PathVariable(value="category")String cat)
    {
        return productRepository.findByCategory(cat);
    }
    @GetMapping("/category/{category}/price/{price1}/between/{price2}")
    public List<Product> getByCategoryAndPriceBetween(@PathVariable(value="category")String cat,
                                                      @PathVariable(value="price1") Integer p1,
                                                      @PathVariable(value="price2") Integer p2)
    {
        return productRepository.findByCategoryAndPriceBetween(cat,p1,p2);
    }
    @PostMapping("/post")
    public Product createProduct(@Valid @RequestBody Product prod)
    {
        return productRepository.save(prod);
    }

    @PutMapping("/put/{id}")
    public Product updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Product noteDetails) throws Exception {

        Product note = productRepository.findById(noteId)
                .orElseThrow(() -> new Exception("product not found"));

        note.setName(noteDetails.getName());
        note.setPrice(noteDetails.getPrice());

        Product updatedNote = productRepository.save(note);
        return updatedNote;
    }
    @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) throws Exception
        {
        Product product = productRepository.findById(noteId)
                .orElseThrow(() -> new Exception("product not found"));

            productRepository.delete(product);

        return ResponseEntity.ok().build();
    }
    @GetMapping("/search/{name}")
    public List<Product> getSearch(@PathVariable(value = "name")String name){
        return productRepository.findByName(name);
    }
}
