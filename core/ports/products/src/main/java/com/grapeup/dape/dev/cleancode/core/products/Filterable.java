package com.grapeup.dape.dev.cleancode.core.products;

sealed interface Filterable permits Product, Product.Service {
}
