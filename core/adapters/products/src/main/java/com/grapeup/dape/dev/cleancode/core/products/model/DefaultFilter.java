package com.grapeup.dape.dev.cleancode.core.products.model;

import com.grapeup.dape.dev.cleancode.core.products.businessrules.BusinessRule;

import java.util.Collection;

class DefaultFilter {

    static boolean isAvailable(Filterable filterable, Collection<BusinessRule> businessRules, String userId, String deviceId) {
        return businessRules.stream().allMatch(rule -> rule.isAvailable(filterable, userId, deviceId));
    }
}
