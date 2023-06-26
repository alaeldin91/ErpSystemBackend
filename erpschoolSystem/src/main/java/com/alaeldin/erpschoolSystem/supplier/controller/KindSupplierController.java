package com.alaeldin.erpschoolSystem.supplier.controller;

import com.alaeldin.erpschoolSystem.supplier.dto.KindSupplierDto;
import com.alaeldin.erpschoolSystem.supplier.serviceImpl.KindSupplierServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/auth/admin/kindsupplier")
@RequiredArgsConstructor
public class KindSupplierController {
    private final KindSupplierServiceImpl kindSupplierService;

    @PostMapping
    public ResponseEntity<KindSupplierDto> saveKindSupplier(@RequestBody KindSupplierDto kindSupplierDto){
        KindSupplierDto kindSaveSupplierDto = kindSupplierService.saveKindSupplier(kindSupplierDto);
        return new ResponseEntity<>(kindSaveSupplierDto, HttpStatus.OK);
    }
@GetMapping("/getallkinds")
    public ResponseEntity<List<KindSupplierDto>> getAllSuppliers(){
       List<KindSupplierDto> kindSupplierDtoList= kindSupplierService.getSupplierKinds();
       return new ResponseEntity<>(kindSupplierDtoList,HttpStatus.OK);
}

@GetMapping("{id}")
      public ResponseEntity<KindSupplierDto> getKindSupplierById(@PathVariable("id") long id){
            KindSupplierDto kindSupplierDto = kindSupplierService.getSupplierKindById(id);
            return new ResponseEntity<>(kindSupplierDto,HttpStatus.OK);
      }

       @GetMapping("getbyname/{name}")
    public ResponseEntity<KindSupplierDto> getKindSupplierByName(@PathVariable("name") String name){
        KindSupplierDto kindSupplierDto = kindSupplierService.getSupplierKindByName(name);
        return new ResponseEntity<>(kindSupplierDto,HttpStatus.OK);
    }
}
