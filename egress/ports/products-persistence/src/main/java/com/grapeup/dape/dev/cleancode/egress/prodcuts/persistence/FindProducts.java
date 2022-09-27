package com.grapeup.dape.dev.cleancode.egress.prodcuts.persistence;

import com.grapeup.dape.dev.cleancode.core.products.model.Product;
import com.grapeup.dape.dev.cleancode.core.products.model.Service;

import java.util.HashSet;

public interface FindProducts {

    HashSet<Product<Service>> findAll();
}
