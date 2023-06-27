package com.alaeldin.erpschoolSystem.kindsupplier.entity;


import com.alaeldin.erpschoolSystem.supplier.entity.Supplier;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kindSupplier")
public class KindSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100)
    @Nullable
    private String kindName;
    @OneToMany()
    private Set<Supplier> suppliers = new HashSet<>();

    public void add(Supplier supplier){
        if (supplier == null){
            suppliers = new HashSet<>();
        }
        suppliers.add(supplier);
    }
}
