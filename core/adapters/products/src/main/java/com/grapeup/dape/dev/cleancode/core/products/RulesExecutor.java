package com.grapeup.dape.dev.cleancode.core.products;

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
        var services = getFilteredServices(product, userId, deviceId);
        var productWithFilteredServices = new Product(product.getName(),
                product.getField1(),
                product.getField2(),
                product.getField3(),
                product.getField4(),
                product.getField5(),
                product.getField6(),
                services);
        return productWithFilteredServices.isAvailable(businessRules, userId, deviceId)
                ? productWithFilteredServices
                : null;
    }

    private HashSet<Product.Service> getFilteredServices(Product product, String userId, String deviceId) {
        return product.hasServices()
                ? product.getServices().parallelStream().filter(service -> service.isAvailable(businessRules, userId, deviceId)).collect(toCollection(HashSet::new))
                : new HashSet<>();
    }

}
