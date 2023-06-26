package com.alaeldin.erpschoolSystem.supplier.service;


import com.alaeldin.erpschoolSystem.supplier.dto.KindSupplierDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
