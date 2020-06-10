package ru.leovalter.shop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.leovalter.shop.model.Product;
import ru.leovalter.shop.repository.ProductRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;
import static ru.leovalter.shop.ProductTestData.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock()
    ProductRepository repository;

    @InjectMocks
    ProductService service;

    @Test
    void shouldCreateProduct() {
        given(repository.save(PRODUCT_1)).willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
        final Product created = service.create(PRODUCT_1);
//        assertNotNull(created);
        verify(repository).save(any(Product.class));
    }

    @Test
    void shouldUpdateProduct() {
        given(repository.save(PRODUCT_1)).willReturn(PRODUCT_1);
        final Product updated = service.update(PRODUCT_1);
//        assertNotNull(updated);
        verify(repository).save(any(Product.class));
    }

    @Test
    void shouldThrowNotFoundExceptionWhenUpdateNotFoundProduct() {
    }

    @Test
    void shouldBeDeleteProductById() {
        given(repository.delete(PRODUCT_1.getId())).willReturn(true);
        service.delete(PRODUCT_1.getId());
        service.delete(PRODUCT_1.getId());
        verify(repository, times(2)).delete(PRODUCT_1.getId());
    }

    @Test
    void shouldThroeExceptionWhenDeleteNotFound() {
    }

    @Test
    void shouldGivenProductById() {
        given(repository.get(PRODUCT_5.getId())).willReturn(PRODUCT_5);
        final Product actual = service.get(PRODUCT_5.getId());
        assertEquals(PRODUCT_5, actual);
    }

    @Test
    void shouldThrowNotFoundExceptionWhenProductNotFound() {
    }

    @Test
    void shouldGivenAllProduct() {
        given(repository.getAll()).willReturn(PRODUCTS);
        final List<Product> actual = service.getAll();
        assertEquals(PRODUCTS, actual);
    }
}