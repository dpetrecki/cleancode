package com.grapeup.dape.dev.cleancode.core.products;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@RequiredArgsConstructor
public class Service implements Element {
    private final String name;

    @SuppressWarnings("unused")
    public abstract static class ServiceBuilder<C extends Service, B extends ServiceBuilder<C, B>> {
        public B fillValuesFromParent(Service instance) {
            $fillValuesFromInstanceIntoBuilder(instance, this);
            return self();
        }
    }
}
