package com.alaeldin.erpschoolSystem.kindsupplier.mapper;

import com.alaeldin.erpschoolSystem.kindsupplier.dto.KindSupplierDto;
import com.alaeldin.erpschoolSystem.kindsupplier.entity.KindSupplier;

public class KindSupplierMapper {

    public static KindSupplierDto tokindSupplierDto(KindSupplier kindSupplier){
        KindSupplierDto kindSupplierDto =new KindSupplierDto(kindSupplier.getId()
                ,kindSupplier.getKindName()
        ,kindSupplier.getSuppliers());
        return kindSupplierDto;
    }

    public static KindSupplier toKindSupplier(KindSupplierDto kindSupplierDto){
         KindSupplier kindSupplier =new KindSupplier(
                 kindSupplierDto.getId()
                 ,kindSupplierDto.getKindName(),
                 kindSupplierDto.getSuppliers()
         );
         return kindSupplier;

    }
}
