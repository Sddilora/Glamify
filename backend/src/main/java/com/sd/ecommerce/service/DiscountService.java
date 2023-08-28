package com.sd.ecommerce.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.dto.DiscountDTO;
import com.sd.ecommerce.dto.Mapper.DiscountMapper;
import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.Discount;
import com.sd.ecommerce.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class DiscountService{
    
    private final DiscountRepository discountRepository;
    private final DiscountMapper discountMapper;

    public DiscountDTO save(DiscountDTO discountDTO) {
        log.info("Saving new Discount {} to the database", discountDTO.getId());
        return discountMapper.convertToDTO(discountRepository.save(discountMapper.convertToEntity(discountDTO)));
    }

    public DiscountDTO get(Long id) {
        log.info("Fetching Discount {}", id);
        return discountMapper.convertToDTO(discountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Discount with provided ID not found")));
    }

    public List<DiscountDTO> list() {
        log.info("Fetching all Discounts");
        return discountMapper.convertToDTO((List<Discount>) discountRepository.findAll());
    }

    public DiscountDTO update(Long id, DiscountDTO discountDTO) {
        log.info("Updating Discount {}", id);
        Discount existingDiscount = discountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Discount with provided ID not found"));
        existingDiscount.setName(discountDTO.getName());
        existingDiscount.setDescription(discountDTO.getDescription());
        existingDiscount.setDiscount_percent(discountDTO.getDiscount_percent());
        existingDiscount.setActive(discountDTO.isActive());
        return discountMapper.convertToDTO(discountRepository.save(existingDiscount));

    }

    public DiscountDTO delete(Long id) {
        log.info("Deleting Discount {}", id);
        Discount existingDiscount = discountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Discount with provided ID not found"));
        discountRepository.deleteById(id);
        return discountMapper.convertToDTO(existingDiscount);
    }
}