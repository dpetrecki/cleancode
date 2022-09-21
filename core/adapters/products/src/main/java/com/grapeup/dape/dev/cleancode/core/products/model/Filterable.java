package com.grapeup.dape.dev.cleancode.core.products.model;

import com.grapeup.dape.dev.cleancode.core.products.businessrules.BusinessRule;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

@SuperBuilder(toBuilder = true)
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public abstract sealed class Filterable permits FilterableProduct, FilterableProduct.FilterableService {

    private String name;

    public boolean isAvailable(Collection<BusinessRule> businessRules, String userId, String deviceId) {
        return businessRules.stream().allMatch(rule -> rule.isAvailable(this, userId, deviceId));
    }
}
