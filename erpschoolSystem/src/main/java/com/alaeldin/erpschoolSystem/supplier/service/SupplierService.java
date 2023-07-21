package com.alaeldin.erpschoolSystem.supplier.service;

import com.alaeldin.erpschoolSystem.supplier.dto.SupplierDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SupplierService {
    /** Save Supplier  **/
    SupplierDto saveSupplier(SupplierDto supplierDto);
    /** get All Supplier **/
    Page<SupplierDto> getAllSupplier(int pageNumber,int pageSize);

    /** get Supplier By Id **/
    SupplierDto getSupplierById(long supplierId);
    /** get Supplier By Name **/
    SupplierDto getSupplierByName(String supplierName);
    /**update Supplier **/
    SupplierDto updateSupplier(SupplierDto supplierDto);
    /** delete Supplier  **/
    void deleteSupplier(long id);
}
