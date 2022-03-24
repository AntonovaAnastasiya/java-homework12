package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Book firstBook = new Book(1, "Trees", 200, "Ivanov Ivan");
    Book secondBook = new Book(2, "Flowers", 250, "Petrov Petr");
    Book thirdBook = new Book(3, "Peoples", 320, "Karpov Ilya");
    Book fourthBook = new Book(4, "Animal", 270, "Drozdov Sergei");
    Smartphone firstSmartphone = new Smartphone();
    Smartphone secondSmartphone = new Smartphone();
    Smartphone thirdSmartphone = new Smartphone();

    @Test
    void shouldAddOneBook() {
        repository.save(firstBook);

        Product[] expected = new Product[]{firstBook};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddOneSmartphone() {
        repository.save(firstSmartphone);

        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    void findAllProduct() {
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(thirdBook);
        repository.save(fourthBook);
        repository.save(firstSmartphone);
        repository.save(secondSmartphone);
        repository.save(thirdSmartphone);


        Product[] expected = new Product[] { firstBook, secondBook, thirdBook, fourthBook, firstSmartphone, secondSmartphone,thirdSmartphone };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        int id = 4;
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(thirdBook);
        repository.save(fourthBook);

        repository.removeById(id);

        Product[] expected = new Product[] { firstBook, secondBook, thirdBook };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}