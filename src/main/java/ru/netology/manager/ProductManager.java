package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository = new ProductRepository();

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductManager() {
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        int i = 0;
        Product[] tmp = new Product[repository.findAll().length];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                tmp[i] = product;
                i++;
            }
        }
        if (i != 0) {
            result = new Product[i];
            System.arraycopy(tmp, 0, result, 0, i);
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}
