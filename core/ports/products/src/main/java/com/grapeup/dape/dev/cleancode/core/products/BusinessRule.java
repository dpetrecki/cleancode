package com.grapeup.dape.dev.cleancode.core.products;

import com.grapeup.dape.dev.cleancode.core.products.Filterable;
import com.grapeup.dape.dev.cleancode.core.products.Product;

public interface BusinessRule {

    default boolean isAvailable(Filterable filterable, String userId, String deviceId) {
        return switch (filterable) {
            case Product element -> isAvailable(element, userId, deviceId);
            case Product.Service element -> isAvailable(element, userId, deviceId);
        };
    }

    default boolean isAvailable(Product element, String userId, String deviceId) {
        return true;
    }

    default boolean isAvailable(Product.Service element, String userId, String deviceId) {
        return true;
    }
}
