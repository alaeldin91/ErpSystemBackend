package com.alaeldin.erpschoolSystem.kindsupplier.repository;


import com.alaeldin.erpschoolSystem.kindsupplier.entity.KindSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface KindSupplierRepository  extends JpaRepository<KindSupplier,Long> {
    KindSupplier findByKindName(String supplierName);
}
