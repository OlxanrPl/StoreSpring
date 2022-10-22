package com.example.storespring.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "buyer_entity_hb_id")
    private BuyerEntityHb buyerEntityHb;

    private String description;
}
