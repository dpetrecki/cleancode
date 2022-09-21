package com.grapeup.dape.dev.cleancode.core.products;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@RequiredArgsConstructor
public final class Product {

    private final String name;
    private final String field1;
    private final Object field2;
    private final Integer field3;
    private final Double field4;
    private final Object field5;
    private final String field6;
    private final Collection<Service> services;

    @Getter
    @RequiredArgsConstructor
    public static final class Service {
        private final String name;
        @Setter
        @EqualsAndHashCode.Exclude
        private Product product;
    }
}
