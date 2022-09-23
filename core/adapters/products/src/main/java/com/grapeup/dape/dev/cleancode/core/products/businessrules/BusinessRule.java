package com.grapeup.dape.dev.cleancode.core.products.businessrules;

import com.grapeup.dape.dev.cleancode.core.products.model.Filterable;
import com.grapeup.dape.dev.cleancode.core.products.model.FilterableProduct;
import com.grapeup.dape.dev.cleancode.core.products.model.FilterableService;

public interface BusinessRule {

    default boolean isAvailable(Filterable filterable, String userId, String deviceId) {
        return switch (filterable) {
            case FilterableProduct element -> isAvailable(element, userId, deviceId);
            case FilterableService element -> isAvailable(element, userId, deviceId);
        };
    }

    default boolean isAvailable(FilterableProduct element, String userId, String deviceId) {
        return true;
    }

    default boolean isAvailable(FilterableService element, String userId, String deviceId) {
        return true;
    }
}
