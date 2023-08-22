package com.sd.ecommerce.service.implementation;


import java.util.Collection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.Discount;
import com.sd.ecommerce.repository.DiscountRepository;
import com.sd.ecommerce.service.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class DiscountServiceImpl implements BaseService<Discount>{
    
    private final DiscountRepository discountRepository;

    @Override
    public Discount save(Discount discount) {
        log.info("Saving new Discount {} to the database", discount.getName());
        return discountRepository.save(discount);
    }

    @Override
    public Discount get(Long id) {
        log.info("Fetching Discount {}", id);
        return discountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Discount not found"));
    }

    @Override
    public Discount update(Long id, Discount discount) {
        log.info("Updating Discount {} with {}", id, discount.toString());
        Discount existingDiscount = discountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Discount not found"));
        existingDiscount.setName(discount.getName());
        existingDiscount.setDescription(discount.getDescription());
        existingDiscount.setDiscount_percent(discount.getDiscount_percent());
        existingDiscount.set_active(discount.get_active());
        return discountRepository.save(existingDiscount);
    }

    @Override
    public Discount delete(Long id) {
        log.info("Deleting Discount {}", id);
        Discount existingDiscount = discountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Discount not found"));
        discountRepository.deleteById(id);
        return existingDiscount;
    }

    @Override
    public Collection<Discount> list() {
        log.info("Fetching all Discounts");
        return (Collection<Discount>) discountRepository.findAll();
    }
}