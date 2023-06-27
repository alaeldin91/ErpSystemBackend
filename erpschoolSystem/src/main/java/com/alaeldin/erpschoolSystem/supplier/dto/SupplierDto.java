package com.alaeldin.erpschoolSystem.supplier.dto;

import com.alaeldin.erpschoolSystem.kindsupplier.entity.KindSupplier;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SupplierDto {
    private long id;
    @NotEmpty(message = "please Enter Supplier Name")
    private String nameSupplier;
    @NotEmpty(message = "please Enter Supplier Kind")
    private KindSupplier kindSupplier;
}
