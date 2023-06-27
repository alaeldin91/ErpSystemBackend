package com.alaeldin.erpschoolSystem.kindsupplier.dto;


import com.alaeldin.erpschoolSystem.supplier.entity.Supplier;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KindSupplierDto {

    private long id;
    @NotEmpty(message = "please enter kind Name")
    private String kindName;
    @NotEmpty(message = "please enter kind Suppliers")
    private Set<Supplier> suppliers;
}
