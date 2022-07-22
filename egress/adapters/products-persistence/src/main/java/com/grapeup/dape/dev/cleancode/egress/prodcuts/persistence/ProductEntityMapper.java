package com.grapeup.dape.dev.cleancode.egress.prodcuts.persistence;

import com.grapeup.dape.dev.cleancode.core.products.Product;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.HashSet;

@Mapper
public interface ProductEntityMapper {
    
    HashSet<Product> map(Collection<ProductEntity> source);

}
