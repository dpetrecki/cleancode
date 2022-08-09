package com.grapeup.dape.dev.cleancode.core.products;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

@SuperBuilder(toBuilder = true)
@Getter
public final class Product extends Filterable {
    private final String field1;
    private final Object field2;
    private final Integer field3;
    private final Double field4;
    private final Object field5;
    private final String field6;
    private final Collection<Service> services;

    public boolean hasServices() {
        return isNotEmpty(services);
    }

    @Override
    public boolean isAvailable(Collection<BusinessRule> businessRules, String userId, String deviceId) {
        var filteredServices = services.parallelStream().filter(service -> service.isAvailable(businessRules, userId, deviceId)).collect(Collectors.toSet());
        services.removeIf(service -> !filteredServices.contains(service));
        return super.isAvailable(businessRules, userId, deviceId);
    }

    @SuperBuilder(toBuilder = true)
    @Getter
    public static final class Service extends Filterable {
    }
}
