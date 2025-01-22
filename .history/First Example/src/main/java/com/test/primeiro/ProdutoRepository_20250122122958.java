package com.test.primeiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.InputMismatchException;

import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {

    private List<Product> products = new ArrayList<>();
    private Integer ultimoID = 0;

    /**
     * Method to return a list of products.
     * 
     * @return list of products.
     */
    public List<Product> getAll() {
        return products;
    }

    /**
     * Method to return a product found by ID.
     * 
     * @param id The ID of the product to find.
     * @return The product if found, otherwise null.
     */
    public Product getById(Integer id) {
        return products
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Method to add a product to the list.
     * 
     * @param product The product to add.
     * @return The added product with an updated ID.
     */
    public Product add(Product product) {
        ultimoID++;
        product.setId(ultimoID);
        products.add(product);
        return product;
    }

    /**
     * Method to delete a product by ID.
     * 
     * @param id The ID of the product to delete.
     */
    public void delete(Integer id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    /**
     * Method to update a product in the list.
     * 
     * @param product The product to update.
     * @return The updated product.
     * @throws InputMismatchException if the product is not found.
     */
    public Product update(Product product) {
        // Find the product in the list.
        Optional<Product> existingProduct = products
                .stream()
                .filter(p -> p.getId().equals(product.getId()))
                .findFirst();

        if (existingProduct.isEmpty()) {
            throw new InputMismatchException("Product not found");
        }

        // Remove the old product from the list.
        delete(product.getId());

        // Add the updated product to the list.
        products.add(product);
        return product;
    }
}
