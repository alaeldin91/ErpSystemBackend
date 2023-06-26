package com.alaeldin.erpschoolSystem.supplier.repository;


import com.alaeldin.erpschoolSystem.supplier.dto.KindSupplierDto;
import com.alaeldin.erpschoolSystem.supplier.entity.KindSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface KindSupplierRepository  extends JpaRepository<KindSupplier,Long> {
    KindSupplier findByKindName(String supplierName);
}
