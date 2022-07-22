package com.grapeup.dape.dev.cleancode.ingress.product.rest.client;

import java.util.Collection;

record ProductRestModel(String name, Collection<Service> services) {

    record Service(String name) {
    }
}
