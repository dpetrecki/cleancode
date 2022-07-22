package com.grapeup.dape.dev.cleancode.core.products;

class ProductRule1 implements BusinessRule {
    @Override
    public boolean isAvailable(Product product, String userId, String deviceId) {
        return product.name() != null && product.name().length() > 2;
    }
}
