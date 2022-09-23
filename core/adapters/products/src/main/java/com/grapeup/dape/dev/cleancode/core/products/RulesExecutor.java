package com.grapeup.dape.dev.cleancode.core.products;

import com.grapeup.dape.dev.cleancode.core.products.businessrules.BusinessRule;
import com.grapeup.dape.dev.cleancode.core.products.model.FilterableProduct;
import com.grapeup.dape.dev.cleancode.core.products.model.FilterableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

import static java.util.stream.Collectors.toCollection;

@Component
@RequiredArgsConstructor
class RulesExecutor {
    private final Collection<BusinessRule> businessRules;

    FilterableProduct processProduct(FilterableProduct product, String userId, String deviceId) {
        var services = getFilteredServices(product, userId, deviceId);
        var productWithFilteredServices = product.toBuilder().services(services).build();
        return productWithFilteredServices.isAvailable(businessRules, userId, deviceId)
                ? productWithFilteredServices
                : null;
    }

    private HashSet<FilterableService> getFilteredServices(FilterableProduct product, String userId, String deviceId) {
        return product.hasServices()
                ? product.getServices().parallelStream().filter(service -> service.isAvailable(businessRules, userId, deviceId)).collect(toCollection(HashSet::new))
                : new HashSet<>();
    }

}
