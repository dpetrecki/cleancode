package com.grapeup.dape.dev.cleancode.core.products;

import com.grapeup.dape.dev.cleancode.core.products.model.FilterableProduct;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(builder = @Builder(disableBuilder = true))
interface DomainModelMapper {

    FilterableProduct map(Product source);

    @AfterMapping
    default void addCyclicDependency(@MappingTarget FilterableProduct target) {
        if (target.hasServices()) {
            target.getServices().forEach(service -> service.setProduct(target));
        }
    }

    Product map(FilterableProduct source);

    @AfterMapping
    default void addCyclicDependency(@MappingTarget Product target) {
        if (target.getServices() != null) {
            target.getServices().forEach(service -> service.setProduct(target));
        }
    }

    @Mapping(target = "product", ignore = true)
    FilterableProduct.FilterableService map(Product.Service source);

    @Mapping(target = "product", ignore = true)
    Product.Service map(FilterableProduct.FilterableService source);

}
