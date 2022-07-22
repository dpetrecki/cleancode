package com.grapeup.dape.dev.cleancode.core.products;

import java.util.HashSet;

public interface GetProducts {

    HashSet<Product> calculateAvailableProduct(String userId, String deviceId);
}
