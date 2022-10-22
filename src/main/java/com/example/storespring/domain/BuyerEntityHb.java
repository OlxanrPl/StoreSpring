package com.example.storespring.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Entity
@Data

public class BuyerEntityHb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "adress_id")
    private Adress adress;
    private Set<ProductEntityHb> productEntityHbSet;
}
