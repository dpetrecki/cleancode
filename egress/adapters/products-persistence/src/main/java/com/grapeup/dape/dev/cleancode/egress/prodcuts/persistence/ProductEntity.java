package com.grapeup.dape.dev.cleancode.egress.prodcuts.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "product")
@Data
class ProductEntity {
    @Id
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "product_service",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "service_id", referencedColumnName = "id")
    )
    private Collection<ServiceEntity> services;

}
