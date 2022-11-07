package com.example.storespring.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "buyer")
public class Buyers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "buyers")
    @JsonManagedReference
    private Set<Products> productsSet;

    @Override
    public String toString() {
        return "Buyers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productsSet=" + productsSet +
                '}';
    }
}
