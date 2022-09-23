package com.grapeup.dape.dev.cleancode.core.products;

import com.grapeup.dape.dev.cleancode.egress.prodcuts.persistence.FindProducts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;

import static java.util.stream.Collectors.toCollection;

@Component
@RequiredArgsConstructor
class ProductsAvailabilityFacade implements GetProducts {

    private final FindProducts findProducts;
    private final RulesExecutor rulesExecutor;
    private final FilterableProductFactory filterableProductFactory;

    @Override
    public HashSet<Product<? extends Service>> calculateAvailableProduct(String userId, String deviceId) {
        return findProducts.findAll()
                .parallelStream()
                .map(filterableProductFactory::build)
                .map(product -> rulesExecutor.processProduct(product, userId, deviceId))
                .filter(Objects::nonNull)
                .collect(toCollection(HashSet::new));
    }

}
