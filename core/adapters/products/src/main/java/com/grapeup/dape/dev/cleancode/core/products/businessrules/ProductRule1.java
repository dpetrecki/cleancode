package com.grapeup.dape.dev.cleancode.core.products.businessrules;

import com.grapeup.dape.dev.cleancode.core.products.BusinessRule;
import com.grapeup.dape.dev.cleancode.core.products.Product;

class ProductRule1 implements BusinessRule {
    @Override
    public boolean isAvailable(Product product, String userId, String deviceId) {
        return product.getName() != null && product.getName().length() > 2;
    }
}
