package com.grapeup.dape.dev.cleancode.core.products.businessrules;

import com.grapeup.dape.dev.cleancode.core.products.BusinessRule;
import com.grapeup.dape.dev.cleancode.core.products.Product;

class ServiceRule1 implements BusinessRule {
    @Override
    public boolean isAvailable(Product.Service service, String userId, String deviceId) {
        return deviceId.length() >= userId.length();
    }
}
