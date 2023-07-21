package com.alaeldin.erpschoolSystem.supplier.servicelmpl;

import com.alaeldin.erpschoolSystem.exception.existdata.EmailAlreadyExistsException;
import com.alaeldin.erpschoolSystem.exception.resourcenotfound.ResourceNotFoundException;
import com.alaeldin.erpschoolSystem.supplier.dto.SupplierDto;
import com.alaeldin.erpschoolSystem.supplier.entity.Supplier;
import com.alaeldin.erpschoolSystem.supplier.mapper.MapperSupplier;
import com.alaeldin.erpschoolSystem.supplier.repository.SupplierRepository;
import com.alaeldin.erpschoolSystem.supplier.service.SupplierService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepository supplierRepository;
    @Override
    public SupplierDto saveSupplier(SupplierDto supplierDto) {
        Optional<Supplier> presentSupplier = supplierRepository.findByNameSupplier(supplierDto.getNameSupplier());
        if (presentSupplier.isPresent()) {
            throw new EmailAlreadyExistsException("Your Supplier Name is Already Exist");
        }
            Supplier supplier = MapperSupplier.toMapSupplier(supplierDto);
            Supplier saveSupplier = supplierRepository.save(supplier);
            SupplierDto supplierSaveDto = MapperSupplier.toMapSupplierDto(saveSupplier);
            return supplierSaveDto;


    }
    @Override
    public Page<SupplierDto> getAllSupplier(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Supplier> supplierList = supplierRepository.findAll(pageable);
        Page<SupplierDto> supplierDtoList = supplierList.map(supplier ->
                MapperSupplier.toMapSupplierDto(supplier));
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
