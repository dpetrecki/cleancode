package com.grapeup.dape.dev.cleancode.ingress.product.rest.client;

import com.grapeup.dape.dev.cleancode.core.products.GetProducts;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@RequestMapping(value = "/products")
@RequiredArgsConstructor
class ProductsController {

    private final ProductRestMapper productRestMapper;
    private final GetProducts getProducts;

    @GetMapping
    HashSet<ProductRestModel> getProducts(@RequestParam String clientId, @RequestParam String deviceId) {
        return productRestMapper.map(getProducts.calculateAvailableProduct(clientId, deviceId));
    }


}
