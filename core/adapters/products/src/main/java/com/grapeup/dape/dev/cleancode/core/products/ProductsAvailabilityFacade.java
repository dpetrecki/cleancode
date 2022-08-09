package com.grapeup.dape.dev.cleancode.core.products;

import com.grapeup.dape.dev.cleancode.egress.prodcuts.persistence.FindProducts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import static java.util.stream.Collectors.toCollection;

@Component
@RequiredArgsConstructor
class ProductsAvailabilityFacade implements GetProducts {

    private final FindProducts findProducts;
    private final Collection<BusinessRule> businessRules;

    @Override
    public HashSet<Product> calculateAvailableProduct(String userId, String deviceId) {
        return findProducts.findAll()
                .parallelStream()
                .filter(product -> product.isAvailable(businessRules, userId, deviceId))
                .collect(toCollection(HashSet::new));
    }

}
