package com.grapeup.dape.dev.cleancode.core.products;

import java.util.Collection;

public abstract sealed class Filterable permits Product, Product.Service {

    public boolean isAvailable(Collection<BusinessRule> businessRules, String userId, String deviceId) {
        return businessRules.stream().allMatch(rule -> rule.isAvailable(this, userId, deviceId));
    }
}
