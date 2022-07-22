package com.grapeup.dape.dev.cleancode.egress.prodcuts.persistence;

import com.grapeup.dape.dev.cleancode.core.products.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@RequiredArgsConstructor
class ProductsPersistenceFacade implements FindProducts{

    private final ProductsRepository productsRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public HashSet<Product> findAll() {
        return productEntityMapper.map(productsRepository.findAll());
    }
}
