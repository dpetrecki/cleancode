package com.grapeup.dape.dev.cleancode.ingress.product.rest.client;

import com.grapeup.dape.dev.cleancode.core.products.model.Product;
import com.grapeup.dape.dev.cleancode.core.products.model.Service;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.HashSet;

@Mapper
interface ProductRestMapper {

    HashSet<ProductRestModel> map(Collection<Product<? extends Service>> source);

}
