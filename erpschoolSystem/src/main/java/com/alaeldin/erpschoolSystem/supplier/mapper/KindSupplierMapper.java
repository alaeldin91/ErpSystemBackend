package com.alaeldin.erpschoolSystem.supplier.mapper;

import com.alaeldin.erpschoolSystem.supplier.dto.KindSupplierDto;
import com.alaeldin.erpschoolSystem.supplier.entity.KindSupplier;

public class KindSupplierMapper {

    public static KindSupplierDto tokindSupplierDto(KindSupplier kindSupplier){
        KindSupplierDto kindSupplierDto =new KindSupplierDto(kindSupplier.getId()
                ,kindSupplier.getKindName());
        return kindSupplierDto;
    }

    public static KindSupplier toKindSupplier(KindSupplierDto kindSupplierDto){
         KindSupplier kindSupplier =new KindSupplier(
                 kindSupplierDto.getId()
                 ,kindSupplierDto.getKindName()
         );
         return kindSupplier;

    }
}
