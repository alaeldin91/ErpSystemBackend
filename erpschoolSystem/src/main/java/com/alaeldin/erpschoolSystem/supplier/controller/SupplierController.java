package com.alaeldin.erpschoolSystem.supplier.controller;

import com.alaeldin.erpschoolSystem.supplier.dto.SupplierDto;
import com.alaeldin.erpschoolSystem.supplier.entity.Supplier;
import com.alaeldin.erpschoolSystem.supplier.servicelmpl.SupplierServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/auth/admin/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierServiceImpl supplierService;
    @PostMapping
    public ResponseEntity<SupplierDto> saveSupplier( @RequestBody SupplierDto supplierDto){
        SupplierDto saveSupplier = supplierService.saveSupplier(supplierDto);
        return new ResponseEntity<>(saveSupplier, HttpStatus.OK);
    }

    @GetMapping("getAllsupplier")
    public ResponseEntity<List<SupplierDto>> getAllSupplier(){
        List<SupplierDto> supplier = supplierService.getAllSupplier();
        return new ResponseEntity<>(supplier,HttpStatus.OK);
    }

 @GetMapping("{id}")
    public ResponseEntity<SupplierDto> getSupplierById(@PathVariable long id){
        SupplierDto supplierDto =supplierService.getSupplierById(id);
        return new ResponseEntity<>(supplierDto,HttpStatus.OK);
 }

 @GetMapping("byname/{supplierName}")
    public ResponseEntity<SupplierDto> getSupplierByName(@PathVariable String supplierName){
        SupplierDto supplierDto =supplierService.getSupplierByName(supplierName);
        return new ResponseEntity<>(supplierDto,HttpStatus.OK);
 }
  @PostMapping("update/{id}")
    public ResponseEntity<SupplierDto> updateSupplier(@PathVariable long id, @RequestBody SupplierDto supplierDto){
        supplierDto.setId(id);
        SupplierDto updateSupplierDto = supplierService.updateSupplier(supplierDto);
        return new ResponseEntity<>(updateSupplierDto,HttpStatus.OK);
  }

  @GetMapping("delete/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable long id){
          supplierService.deleteSupplier(id);
          return new ResponseEntity<>("Delete Successfully",HttpStatus.OK);
  }

}
