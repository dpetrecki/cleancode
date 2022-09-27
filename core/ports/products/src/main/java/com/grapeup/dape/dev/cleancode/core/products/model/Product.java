package com.grapeup.dape.dev.cleancode.core.products.model;

import com.grapeup.dape.dev.cleancode.core.products.Element;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@RequiredArgsConstructor
public class Product<S extends Service> implements Element {

    protected final Collection<S> services;
    private final String name;
    private final String field1;
    private final Object field2;
    private final Integer field3;
    private final Double field4;
    private final Object field5;
    private final String field6;

    @SuppressWarnings("unused")
    abstract static class ProductBuilder<S extends Service, C extends Product<S>, B extends ProductBuilder<S, C, B>> {
        public B fillValuesFromParent(Product<S> instance) {
            $fillValuesFromInstanceIntoBuilder(instance, this);
            return self();
        }
    }
}
