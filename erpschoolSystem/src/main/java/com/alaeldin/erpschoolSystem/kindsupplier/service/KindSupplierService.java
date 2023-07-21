package com.alaeldin.erpschoolSystem.kindsupplier.service;


import com.alaeldin.erpschoolSystem.kindsupplier.dto.KindSupplierDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KindSupplierService {
    /**  Method Save Kind Supplier   **/
    KindSupplierDto saveKindSupplier(KindSupplierDto kindSupplierDto);
    /** method Update Kind Supplier **/
    KindSupplierDto updateKindSupplier(KindSupplierDto kindSupplierDto);

    /** get All Kind Supplier  **/
    Page<KindSupplierDto> getSupplierKinds(int  pageNumber, int pageSize);
    /**     Kind Supplier List  **/

    List<KindSupplierDto> getSupplierList();
    /**  delete Supplier Kind**/
    void deleteSupplierKind(long id);
    /** get Supplier Kind By Name **/
    KindSupplierDto getSupplierKindByName(String supplierKindName);
    /** get Supplier By Id **/
    KindSupplierDto getSupplierKindById(long id);
}
