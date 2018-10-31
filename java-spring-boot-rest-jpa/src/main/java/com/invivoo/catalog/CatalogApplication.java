package com.invivoo.catalog;

import com.invivoo.catalog.domain.product.Product;
import com.invivoo.catalog.domain.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class CatalogApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CatalogApplication.class, args);
    }

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) {
        Product bike = new Product("Vélo électrique", "Un très beau vélo électrique", 99999L, 1, BigDecimal.valueOf(700L), "http://www.les-cyclistes-branches.com/wp-content/uploads/2017/03/velo-electrique-riese-et-muller-delite-gx-rohloff-hs.jpg");
        Product ghettoBlaster = new Product("Ghetto blaster", "Un super Ghetto blaster avec un son de dingue ", 99999L, 1, BigDecimal.valueOf(200L), "http://www.nicestuff.co.uk/acatalog/Brooklyn-new-1.jpg");
        Product printer = new Product("Imprimante", "Je vends une super imprimante (elle ne gère pas la 3D)", 10879L, 1, BigDecimal.valueOf(75L), "https://image.darty.com/informatique/imprimante-imprimante/imprimante/epson_xp-540_s1609294265017A_171521523.jpg");
        productRepository.saveAll(Arrays.asList(bike, ghettoBlaster, printer));
    }
}
