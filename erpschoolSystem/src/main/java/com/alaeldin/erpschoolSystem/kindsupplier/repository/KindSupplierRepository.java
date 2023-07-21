package com.alaeldin.erpschoolSystem.kindsupplier.repository;


import com.alaeldin.erpschoolSystem.kindsupplier.entity.KindSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface KindSupplierRepository  extends JpaRepository<KindSupplier,Long> {
   Optional<KindSupplier> findByKindName(String supplierName);
}
