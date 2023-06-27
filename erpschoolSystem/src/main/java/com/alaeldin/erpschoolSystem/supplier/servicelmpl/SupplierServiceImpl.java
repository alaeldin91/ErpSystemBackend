package com.alaeldin.erpschoolSystem.supplier.servicelmpl;

import com.alaeldin.erpschoolSystem.exception.resourcenotfound.ResourceNotFoundException;
import com.alaeldin.erpschoolSystem.supplier.dto.SupplierDto;
import com.alaeldin.erpschoolSystem.supplier.entity.Supplier;
import com.alaeldin.erpschoolSystem.supplier.mapper.MapperSupplier;
import com.alaeldin.erpschoolSystem.supplier.repository.SupplierRepository;
import com.alaeldin.erpschoolSystem.supplier.service.SupplierService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepository supplierRepository;
    @Override
    public SupplierDto saveSupplier(SupplierDto supplierDto) {
        Supplier supplier = MapperSupplier.toMapSupplier(supplierDto);
        Supplier saveSupplier = supplierRepository.save(supplier);
        SupplierDto supplierSaveDto = MapperSupplier.toMapSupplierDto(saveSupplier);
        return supplierSaveDto;
    }

    @Override
    public List<SupplierDto> getAllSupplier() {
        List<Supplier> supplierList = supplierRepository.findAll();
        List<SupplierDto> supplierDtoList = supplierList.stream().map(supplier ->
                MapperSupplier.toMapSupplierDto(supplier)).toList();
        return supplierDtoList;
    }

    @Override
    public SupplierDto getSupplierById(long supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId).orElseThrow(()
                ->new ResourceNotFoundException("supplier","id",(int)supplierId));
        SupplierDto supplierDto = MapperSupplier.toMapSupplierDto(supplier);
        return supplierDto;
    }

    @Override
    public SupplierDto getSupplierByName(String supplierName) {
        Supplier supplier = supplierRepository.findByNameSupplier(supplierName).orElseThrow();
        SupplierDto supplierDto =MapperSupplier.toMapSupplierDto(supplier);
        return supplierDto;
    }

    @Override
    public SupplierDto updateSupplier(SupplierDto supplierDto) {
        Supplier existSupplier = supplierRepository.findById(supplierDto.getId()).orElseThrow(()
                ->new ResourceNotFoundException("supplier","id",(int)supplierDto.getId()));
        existSupplier.setId(supplierDto.getId());
        existSupplier.setNameSupplier(supplierDto.getNameSupplier());
        existSupplier.setKindSupplier(supplierDto.getKindSupplier());
        Supplier saveSupplier = supplierRepository.save(existSupplier);
        SupplierDto saveSupplierDto = MapperSupplier.toMapSupplierDto(saveSupplier);
        return saveSupplierDto;
    }

    @Override
    public void deleteSupplier(long id) {
        Supplier existSupplier = supplierRepository.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("supplier","id",(int)id));
        supplierRepository.delete(existSupplier);

    }
}
