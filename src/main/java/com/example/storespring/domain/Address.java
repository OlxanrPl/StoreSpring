package com.example.storespring.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "adress")
public class Address {
    @Id
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Buyers buyers;

    private String description;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", buyers=" + buyers +
                ", description='" + description + '\'' +
                '}';
    }
}
