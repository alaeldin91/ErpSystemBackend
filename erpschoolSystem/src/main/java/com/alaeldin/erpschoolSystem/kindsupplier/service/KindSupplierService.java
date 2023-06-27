package com.alaeldin.erpschoolSystem.kindsupplier.service;


import com.alaeldin.erpschoolSystem.kindsupplier.dto.KindSupplierDto;

import java.util.List;

public interface KindSupplierService {
    /**  Method Save Kind Supplier   **/
    KindSupplierDto saveKindSupplier(KindSupplierDto kindSupplierDto);
    /** method Update Kind Supplier **/
    KindSupplierDto updateKindSupplier(KindSupplierDto kindSupplierDto);

    /** get All Kind Supplier  **/
    List<KindSupplierDto> getSupplierKinds();
    /**  delete Supplier Kind**/
    void deleteSupplierKind(long id);
    /** get Supplier Kind By Name **/
    KindSupplierDto getSupplierKindByName(String supplierKindName);
    /** get Supplier By Id **/
    KindSupplierDto getSupplierKindById(long id);
}
