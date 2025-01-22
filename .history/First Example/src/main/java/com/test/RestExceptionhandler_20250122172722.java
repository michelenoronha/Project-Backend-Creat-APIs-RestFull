package com.test.primeiro;

import com.test.primeiroexemplo.model.Product; // Assuming this is where the Product class is
import com.test.primeiroexemplo.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository productRepository;

    /**
     * Method to get all products.
     * 
     * @return a list of all products.
     */
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    /**
     * Method to get a product by ID.
     * 
     * @param id the ID of the product.
     * @return an Optional containing the product if found.
     */
    public Optional<Product> getById(Integer id) {
        return Optional.ofNullable(productRepository.getById(id));
    }

    /**
     * Method to delete a product by ID.
     * 
     * @param id the ID of the product to be deleted.
     */
    public void delete(Integer id) {
        productRepository.delete(id);
    }

    /**
     * Method to add a product.
     * 
     * @param product the product to be added.
     * @return the added product.
     */
    public Product Product

    add(Product product) {
        return ProductRepository.add(product);
    }

    /**
     * Method to update a product by ID.
     * 
     * @param id      the ID of the product to be updated.
     * @param product the updated product data.
     * @return the updated product.
     */
    public Product update (Integer id, product) {
        product.setId(id); // Ensure the product ID is set correctly
        return productRepository.update(product);
    }
}
