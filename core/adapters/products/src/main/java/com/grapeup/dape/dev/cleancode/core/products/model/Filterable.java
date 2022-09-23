package com.grapeup.dape.dev.cleancode.core.products.model;

import com.grapeup.dape.dev.cleancode.core.products.businessrules.BusinessRule;

import java.util.Collection;

public sealed interface Filterable permits FilterableProduct, FilterableService {

    default boolean isAvailable(Collection<BusinessRule> businessRules, String userId, String deviceId) {
        return DefaultFilter.isAvailable(this, businessRules, userId, deviceId);
    }
}
