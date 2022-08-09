package com.grapeup.dape.dev.cleancode.core.products;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

@SuperBuilder(toBuilder = true)
@Getter
public abstract sealed class Filterable permits Product, Product.Service {

    private final String name;

    public boolean isAvailable(Collection<BusinessRule> businessRules, String userId, String deviceId) {
        return businessRules.stream().allMatch(rule -> rule.isAvailable(this, userId, deviceId));
    }
}
