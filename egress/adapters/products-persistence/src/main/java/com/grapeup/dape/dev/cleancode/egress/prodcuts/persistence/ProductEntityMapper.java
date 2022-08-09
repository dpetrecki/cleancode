package com.grapeup.dape.dev.cleancode.egress.prodcuts.persistence;

import com.grapeup.dape.dev.cleancode.core.products.Product;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.HashSet;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@Mapper(builder = @Builder(disableBuilder = true))
public interface ProductEntityMapper {
    
    HashSet<Product> map(Collection<ProductEntity> source);

    Product map(ProductEntity source);

    @Mapping(target = "product", ignore = true)
    Product.Service map(ServiceEntity source);

    @AfterMapping
    default void addProductToServices(@MappingTarget Product target, ProductEntity source){
        if (isNotEmpty(target.getServices())){
            target.getServices().forEach(service -> service.setProduct(target));
        }
    }


}
