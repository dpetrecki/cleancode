package com.grapeup.dape.dev.cleancode.core.products;

import java.util.HashSet;

public interface GetProducts {

    HashSet<Product<? extends Service>> calculateAvailableProduct(String userId, String deviceId);
}
