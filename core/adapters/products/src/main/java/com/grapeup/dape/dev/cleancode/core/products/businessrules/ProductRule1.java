package com.grapeup.dape.dev.cleancode.core.products.businessrules;

import com.grapeup.dape.dev.cleancode.core.products.Product;
import com.grapeup.dape.dev.cleancode.core.products.model.FilterableProduct;

class ProductRule1 implements BusinessRule {
    @Override
    public boolean isAvailable(FilterableProduct product, String userId, String deviceId) {
        return product.getName() != null && product.getName().length() > 2;
    }
}
