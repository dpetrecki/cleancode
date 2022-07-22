package com.grapeup.dape.dev.cleancode.ingress.product.rest.client;

import com.grapeup.dape.dev.cleancode.core.products.Product;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.HashSet;

@Mapper
interface ProductRestMapper {

    HashSet<ProductRestModel> map(Collection<Product> source);
}
