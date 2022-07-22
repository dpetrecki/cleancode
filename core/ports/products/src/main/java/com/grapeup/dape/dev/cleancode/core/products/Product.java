package com.grapeup.dape.dev.cleancode.core.products;

import java.util.Collection;

public record Product(String name, Collection<Service> services) implements Filterable {
    public record Service(String name) implements Filterable {
    }
}
