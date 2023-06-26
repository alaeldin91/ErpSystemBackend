package com.alaeldin.erpschoolSystem.supplier.serviceImpl;

import com.alaeldin.erpschoolSystem.exception.resourcenotfound.ResourceNotFoundException;
import com.alaeldin.erpschoolSystem.supplier.dto.KindSupplierDto;
import com.alaeldin.erpschoolSystem.supplier.entity.KindSupplier;
import com.alaeldin.erpschoolSystem.supplier.mapper.KindSupplierMapper;
import com.alaeldin.erpschoolSystem.supplier.repository.KindSupplierRepository;
import com.alaeldin.erpschoolSystem.supplier.service.KindSupplierService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KindSupplierServiceImpl implements KindSupplierService {
    private KindSupplierRepository kindSupplierRepository;

    @Override
    public KindSupplierDto saveKindSupplier(KindSupplierDto kindSupplierDto) {
        KindSupplier kindSupplier = KindSupplierMapper.toKindSupplier(kindSupplierDto);
            kindSupplierRepository.save(kindSupplier);
            KindSupplierDto kindSupplierSaveDto =
                    KindSupplierMapper.tokindSupplierDto(kindSupplier);
        return kindSupplierDto;
    }

    @Override
    public KindSupplierDto updateKindSupplier(KindSupplierDto kindSupplierDto) {
        KindSupplier kindSupplierExist =  kindSupplierRepository.findById(kindSupplierDto.getId())
                .orElseThrow(()->new ResourceNotFoundException("kind Supplier","id"
                        ,(int)kindSupplierDto.getId()));

             kindSupplierExist.setId(kindSupplierDto.getId());
             kindSupplierExist.setKindName(kindSupplierDto.getKindName());
           KindSupplier saveKindSupplier = kindSupplierRepository.save(kindSupplierExist);
                KindSupplierDto kindSaveSupplierDto = KindSupplierMapper.tokindSupplierDto(saveKindSupplier);
        return kindSaveSupplierDto;
    }

    @Override
    public List<KindSupplierDto> getSupplierKinds() {
        List<KindSupplier> listKindSuppliers = kindSupplierRepository.findAll();
        List<KindSupplierDto> kindSupplierDtoList = listKindSuppliers.stream().map(kindSupplier ->
                KindSupplierMapper.tokindSupplierDto(kindSupplier)).toList();
        return kindSupplierDtoList;
    }

    @Override
    public void deleteSupplierKind(long id) {
   KindSupplier existKindSupplier = kindSupplierRepository.findById(id).orElseThrow(()
           ->new ResourceNotFoundException("kind Supplier","id",(int)id));
        kindSupplierRepository.delete(existKindSupplier);
    }

    @Override
    public KindSupplierDto getSupplierKindByName(String supplierKindName) {
        KindSupplier kindSupplier = kindSupplierRepository.findByKindName(supplierKindName);
        KindSupplierDto kindSupplierDto = KindSupplierMapper.tokindSupplierDto(kindSupplier);
        return kindSupplierDto;
    }

    @Override
    public KindSupplierDto getSupplierKindById(long id) {
           KindSupplier kindSupplier = kindSupplierRepository.findById(id).orElseThrow(()
                   ->new ResourceNotFoundException("kind Supplier","id",(int)id));
           KindSupplierDto kindSupplierDto = KindSupplierMapper.tokindSupplierDto(kindSupplier);
        return kindSupplierDto;
    }
}
