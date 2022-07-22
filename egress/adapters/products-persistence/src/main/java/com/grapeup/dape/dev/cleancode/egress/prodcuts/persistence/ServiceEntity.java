package com.grapeup.dape.dev.cleancode.egress.prodcuts.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service")
@Data
class ServiceEntity {
    @Id
    private Long id;
    private String name;
}
