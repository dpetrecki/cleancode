package com.grapeup.dape.dev.cleancode.core.products;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

@RequiredArgsConstructor
@Getter
public final class Product extends Filterable {
    private final String name;
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

    @RequiredArgsConstructor
    @Getter
    public static final class Service extends Filterable {
        private final String name;
    }
}
