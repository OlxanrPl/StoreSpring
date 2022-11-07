package com.example.storespring.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer depId;
    private String depName;
    @OneToMany(mappedBy = "departments", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Products> productsSet;

    @Override
    public String toString() {
        return "Departments{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
               '}';
    }
}
