package com.grapeup.dape.dev.cleancode.core.products;

import com.grapeup.dape.dev.cleancode.core.products.businessrules.BusinessRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

import static java.util.stream.Collectors.toCollection;

@Component
@RequiredArgsConstructor
class RulesExecutor {
    private final Collection<BusinessRule> businessRules;

    Product processProduct(Product product, String userId, String deviceId) {
        var services = filterServices(product.services(), userId, deviceId);
        var productWithFilteredServices = new Product(product.name(), services);
        return filter(productWithFilteredServices, userId, deviceId) ? productWithFilteredServices : null;
    }

    private boolean filter(Filterable filterable, String userId, String vehicleId) {
        return businessRules.stream().allMatch(rule -> rule.isAvailable(filterable, userId, vehicleId));
    }

    private HashSet<Product.Service> filterServices(Collection<Product.Service> services, String userId, String deviceId) {
        return services.stream().filter(service -> filter(service, userId, deviceId)).collect(toCollection(HashSet::new));
    }
}
