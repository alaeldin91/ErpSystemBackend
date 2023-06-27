package com.alaeldin.erpschoolSystem.supplier.mapper;

import com.alaeldin.erpschoolSystem.supplier.dto.SupplierDto;
import com.alaeldin.erpschoolSystem.supplier.entity.Supplier;

public class MapperSupplier {
    public static SupplierDto toMapSupplierDto(Supplier supplier){
        SupplierDto supplierDto = new SupplierDto(
                supplier.getId(),
                supplier.getNameSupplier(),
                supplier.getKindSupplier()
        );
        return  supplierDto;
    }

    public static Supplier toMapSupplier(SupplierDto supplierDto){
        Supplier supplier = new Supplier(
                supplierDto.getId(),
                supplierDto.getNameSupplier(),
                supplierDto.getKindSupplier()
        );
        return supplier;
    }

}
