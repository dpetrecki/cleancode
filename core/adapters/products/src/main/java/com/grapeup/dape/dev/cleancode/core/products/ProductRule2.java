package com.grapeup.dape.dev.cleancode.core.products;

class ProductRule2 implements BusinessRule {
    @Override
    public boolean isAvailable(Product product, String userId, String deviceId) {
        return deviceId.contains("test");
    }
}
