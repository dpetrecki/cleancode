package com.grapeup.dape.dev.cleancode.egress.prodcuts.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductEntity, Long> {
}
