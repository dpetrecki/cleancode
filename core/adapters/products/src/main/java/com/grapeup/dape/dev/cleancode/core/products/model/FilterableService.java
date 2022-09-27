package com.grapeup.dape.dev.cleancode.core.products.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Getter
@EqualsAndHashCode(callSuper = true)
public final class FilterableService extends Service implements Filterable {
    @Setter
    @EqualsAndHashCode.Exclude
    private FilterableProduct product;


    public static FilterableServiceBuilder<?, ?> toBuilder(Service p) {
        return new FilterableServiceBuilderImpl().fillValuesFromParent(p);
    }
}
