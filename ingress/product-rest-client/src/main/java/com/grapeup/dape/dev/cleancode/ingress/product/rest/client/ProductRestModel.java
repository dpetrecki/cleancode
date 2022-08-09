package com.grapeup.dape.dev.cleancode.ingress.product.rest.client;

import java.util.Collection;

record ProductRestModel(String name,
                        String field1,
                        Object field2,
                        Integer field3,
                        Double field4,
                        Object field5,
                        String field6,
                        Collection<Service> services) {

    record Service(String name) {
    }
}
