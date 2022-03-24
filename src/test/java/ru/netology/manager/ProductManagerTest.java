package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager productManager = new ProductManager(repository);
    Book firstBook = new Book(1, "Trees", 200, "Ivanov Ivan");
    Book secondBook = new Book(2, "Flowers", 250, "Petrov Petr");
    Book thirdBook = new Book(3, "Peoples", 320, "Karpov Ilya");
    Book fourthBook = new Book(4, "Animal", 270, "Drozdov Sergei");
    Smartphone firstSmartphone = new Smartphone(5, "Samsung", 5000, "Japan");
    Smartphone secondSmartphone = new Smartphone(6, "Nokia", 2000, "Korea");
    Smartphone thirdSmartphone = new Smartphone(7, "Xiami", 7000, "China");



    @Test
    void searchByNameBook() {
        productManager.add(firstBook);
        productManager.add(secondBook);
        productManager.add(thirdBook);
        productManager.add(fourthBook);
        productManager.add(firstSmartphone);
        productManager.add(secondSmartphone);
        productManager.add(thirdSmartphone);

        Product[] actual = productManager.searchBy("Animal");
        Product[] expected = new Product[] {fourthBook};
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchByDifferentClasses() {
        productManager.add(firstBook);
        productManager.add(secondBook);
        productManager.add(thirdBook);
        productManager.add(fourthBook);
        productManager.add(firstSmartphone);
        productManager.add(secondSmartphone);
        productManager.add(thirdSmartphone);

        Product[] actual = productManager.searchBy("Water");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }
}