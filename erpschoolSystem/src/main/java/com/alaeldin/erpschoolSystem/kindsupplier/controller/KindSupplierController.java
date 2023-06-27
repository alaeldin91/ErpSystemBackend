package com.alaeldin.erpschoolSystem.kindsupplier.controller;

import com.alaeldin.erpschoolSystem.kindsupplier.dto.KindSupplierDto;
import com.alaeldin.erpschoolSystem.kindsupplier.serviceImpl.KindSupplierServiceImpl;
import com.alaeldin.erpschoolSystem.supplier.dto.SupplierDto;
import com.alaeldin.erpschoolSystem.supplier.entity.Supplier;
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

    @PostMapping("update/kindsupplier/{id}")
    public ResponseEntity<KindSupplierDto> updateSupplier(@PathVariable("id") long id,
                                                          @RequestBody KindSupplierDto kindSupplierDto){
        kindSupplierDto.setId(id);
        KindSupplierDto updateKindSupplierDto = kindSupplierService.updateKindSupplier(kindSupplierDto);
      return new ResponseEntity<>(updateKindSupplierDto,HttpStatus.OK);

    }
    @GetMapping("delete/kindsupplier/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable long id){
        kindSupplierService.deleteSupplierKind(id);
        return new ResponseEntity<>("Supplier kind is successfully Delete",HttpStatus.OK);
    }
}
