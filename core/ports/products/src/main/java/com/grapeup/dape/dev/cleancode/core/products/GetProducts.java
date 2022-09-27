package com.grapeup.dape.dev.cleancode.core.products;

import com.grapeup.dape.dev.cleancode.core.products.model.Product;
import com.grapeup.dape.dev.cleancode.core.products.model.Service;

import java.util.HashSet;

public interface GetProducts {

    HashSet<Product<? extends Service>> calculateAvailableProduct(String userId, String deviceId);
}
