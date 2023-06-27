package com.alaeldin.erpschoolSystem.supplier.entity;


import com.alaeldin.erpschoolSystem.kindsupplier.entity.KindSupplier;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Nullable
    private String nameSupplier;
    @ManyToOne()
    @JoinColumn(name = "kind_supplier_id")
    @Nullable
    private KindSupplier kindSupplier;

}
