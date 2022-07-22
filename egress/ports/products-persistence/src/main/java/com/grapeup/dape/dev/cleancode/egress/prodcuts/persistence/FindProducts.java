package com.grapeup.dape.dev.cleancode.egress.prodcuts.persistence;

import com.grapeup.dape.dev.cleancode.core.products.Product;

import java.util.HashSet;

public interface FindProducts {

    HashSet<Product> findAll();
}
