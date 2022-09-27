package com.grapeup.dape.dev.cleancode.core.products;

import com.grapeup.dape.dev.cleancode.core.products.model.FilterableProduct;
import com.grapeup.dape.dev.cleancode.core.products.model.FilterableService;
import com.grapeup.dape.dev.cleancode.core.products.model.Product;
import com.grapeup.dape.dev.cleancode.core.products.model.Service;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
class FilterableProductFactory {

    FilterableProduct build(Product<Service> product) {
        var filterableProduct = FilterableProduct
                .toBuilder(product)
                .services(build(product.getServices()))
                .build();
        if (filterableProduct.hasServices()){
            filterableProduct.getServices().forEach(service -> service.setProduct(filterableProduct));
        }
        return filterableProduct;
    }

    private Set<FilterableService> build(Collection<Service> services) {
        if (services == null) {
            return null;
        }
        return services.stream().map(this::build).collect(Collectors.toSet());
    }

    private FilterableService build(Service source) {
        return FilterableService
                .toBuilder(source)
                .build();
    }
}
