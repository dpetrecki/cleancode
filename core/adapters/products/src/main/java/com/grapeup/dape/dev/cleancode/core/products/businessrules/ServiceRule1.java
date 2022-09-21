package com.grapeup.dape.dev.cleancode.core.products.businessrules;

import com.grapeup.dape.dev.cleancode.core.products.Product;
import com.grapeup.dape.dev.cleancode.core.products.model.FilterableProduct;

class ServiceRule1 implements BusinessRule {
    @Override
    public boolean isAvailable(FilterableProduct.FilterableService service, String userId, String deviceId) {
        return deviceId.length() >= userId.length();
    }
}
