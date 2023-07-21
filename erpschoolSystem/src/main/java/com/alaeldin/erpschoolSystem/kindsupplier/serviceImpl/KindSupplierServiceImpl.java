package com.alaeldin.erpschoolSystem.kindsupplier.serviceImpl;

import com.alaeldin.erpschoolSystem.exception.existdata.EmailAlreadyExistsException;
import com.alaeldin.erpschoolSystem.exception.resourcenotfound.ResourceNotFoundException;
import com.alaeldin.erpschoolSystem.kindsupplier.dto.KindSupplierDto;
import com.alaeldin.erpschoolSystem.kindsupplier.entity.KindSupplier;
import com.alaeldin.erpschoolSystem.kindsupplier.mapper.KindSupplierMapper;
import com.alaeldin.erpschoolSystem.kindsupplier.repository.KindSupplierRepository;
import com.alaeldin.erpschoolSystem.kindsupplier.service.KindSupplierService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KindSupplierServiceImpl implements KindSupplierService {
    private KindSupplierRepository kindSupplierRepository;

    @Override
    public KindSupplierDto saveKindSupplier(KindSupplierDto kindSupplierDto) {
        Optional<KindSupplier>kindSupplierOptional = kindSupplierRepository.findByKindName(kindSupplierDto.getKindName());
        if (kindSupplierOptional.isPresent()){
           new EmailAlreadyExistsException("your kind Supplier is Already Exist");
        }
        KindSupplier kindSupplier = KindSupplierMapper.toKindSupplier(kindSupplierDto);
            kindSupplierRepository.save(kindSupplier);
            KindSupplierDto kindSupplierSaveDto =
                    KindSupplierMapper.tokindSupplierDto(kindSupplier);
        return kindSupplierSaveDto;
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
    public Page<KindSupplierDto> getSupplierKinds(int pageNumber,int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<KindSupplier> listKindSuppliers = kindSupplierRepository.findAll(pageable);
        Page<KindSupplierDto> kindSupplierDtoList = listKindSuppliers.map(kindSupplier ->
                KindSupplierMapper.tokindSupplierDto(kindSupplier));
        return kindSupplierDtoList;
    }

    @Override
    public List<KindSupplierDto> getSupplierList() {
        List<KindSupplier> supplierList = kindSupplierRepository.findAll();
        List<KindSupplierDto>kindSupplierDtoList = supplierList.stream().map(supplier->
                KindSupplierMapper.tokindSupplierDto(supplier)).toList();
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
        KindSupplier kindSupplier = kindSupplierRepository.findByKindName(supplierKindName).orElseThrow();
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
