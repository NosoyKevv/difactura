package com.kevin.springboot.factura.springboot_difactura;

import com.kevin.springboot.factura.springboot_difactura.models.Item;
import com.kevin.springboot.factura.springboot_difactura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {

    @Bean
    List<Item> itemsInvoice() {
        Product p1 = new Product("Camara sony", 900);
        Product p2 = new Product("Xiaomi redmi", 1200);
        return Arrays.asList(new Item(p1, 2), new Item(p2, 4));
    }

    @Bean
    @Primary
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("Vivobook 7520u", 1900);
        Product p2 = new Product("Epson 512", 500);
        Product p3 = new Product("Mouse logitech", 820);
        Product p4 = new Product("Escritorio red", 300);
        return Arrays.asList(new Item(p1, 2), new Item(p2, 4), new Item(p3, 6), new Item(p4, 1));
    }
}
