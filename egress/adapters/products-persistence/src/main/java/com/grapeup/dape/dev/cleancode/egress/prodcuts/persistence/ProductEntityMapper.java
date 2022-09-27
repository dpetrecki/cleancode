package com.grapeup.dape.dev.cleancode.egress.prodcuts.persistence;

import com.grapeup.dape.dev.cleancode.core.products.model.Product;
import com.grapeup.dape.dev.cleancode.core.products.model.Service;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.HashSet;

@Mapper(builder = @Builder(disableBuilder = true))
public interface ProductEntityMapper {

    HashSet<Product<Service>> map(Collection<ProductEntity> source);

    Product<Service> map(ProductEntity source);

    HashSet<Service> mapServices(Collection<ServiceEntity> source);


}
