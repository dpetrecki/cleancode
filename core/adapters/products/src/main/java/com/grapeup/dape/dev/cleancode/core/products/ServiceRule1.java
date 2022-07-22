package com.grapeup.dape.dev.cleancode.core.products;

class ServiceRule1 implements BusinessRule {
    @Override
    public boolean isAvailable(Product.Service service, String userId, String deviceId) {
        return deviceId.length() >= userId.length();
    }
}
