package com.grapeup.dape.dev.cleancode.core.products.model;

import com.grapeup.dape.dev.cleancode.core.products.businessrules.BusinessRule;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

@SuperBuilder(toBuilder = true)
@Getter
@EqualsAndHashCode(callSuper = true)
public final class FilterableProduct extends Product<FilterableService> implements Filterable {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static FilterableProductBuilder<?, ?> toBuilder(Product p) {
        return new FilterableProductBuilderImpl().fillValuesFromParent(p);
    }

    public boolean hasServices() {
        return isNotEmpty(services);
    }

    @Override
    public boolean isAvailable(Collection<BusinessRule> businessRules, String userId, String deviceId) {
        var filteredServices = services.parallelStream().filter(service -> service.isAvailable(businessRules, userId, deviceId)).collect(Collectors.toSet());
        services.removeIf(service -> !filteredServices.contains(service));
        return DefaultFilter.isAvailable(this, businessRules, userId, deviceId);
    }
}
