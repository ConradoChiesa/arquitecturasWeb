package com.grupo10.despensa;

import com.grupo10.despensa.config.ApiConfigTest;
import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.service.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApiConfigTest.class })
public class DespensaTest {

    @Autowired
    private ProductServiceImpl service;

    @Test
    public void test() {

        Iterable<Product> products = service.getAll();
        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            it.next().toString();
        }
    }
}
