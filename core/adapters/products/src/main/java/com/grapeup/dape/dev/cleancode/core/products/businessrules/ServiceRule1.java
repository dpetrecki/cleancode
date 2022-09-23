package com.grapeup.dape.dev.cleancode.core.products.businessrules;

import com.grapeup.dape.dev.cleancode.core.products.model.FilterableService;

class ServiceRule1 implements BusinessRule {
    @Override
    public boolean isAvailable(FilterableService service, String userId, String deviceId) {
        return deviceId.length() >= userId.length();
    }
}
