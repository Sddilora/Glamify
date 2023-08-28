package com.sd.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.dto.PaymentDetailsDTO;
import com.sd.ecommerce.dto.Mapper.PaymentDetailsMapper;
import com.sd.ecommerce.model.PaymentDetails;
import com.sd.ecommerce.repository.PaymentDetailsRepository;
import com.sd.ecommerce.util.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// import org.springframework.security.crypto.bcrypt.BCrypt;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class PaymentDetailsService {

    private final PaymentDetailsRepository paymentDetailsRepository;
    private final PaymentDetailsMapper paymentDetailsMapper;

    public PaymentDetailsDTO save(PaymentDetailsDTO paymentDetailsDTO) {
        log.info("Saving new PaymentDetails {} to the database", paymentDetailsDTO.getId());
        return paymentDetailsMapper.convertToDTO(paymentDetailsRepository.save(paymentDetailsMapper.convertToEntity(paymentDetailsDTO)));
    }

    public PaymentDetailsDTO get(Long id) {
        log.info("Fetching PaymentDetails {}", id);
        return paymentDetailsMapper.convertToDTO(paymentDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PaymentDetails with provided ID not found")));
    }

    public List<PaymentDetailsDTO> list() {
        log.info("Fetching all PaymentDetailss");
        return paymentDetailsMapper.convertToDTO((List<PaymentDetails>) paymentDetailsRepository.findAll());
    }

    public PaymentDetailsDTO update(Long id, PaymentDetailsDTO paymentDetailsDTO) {
        log.info("Updating PaymentDetails {}", id);
        PaymentDetails existingPaymentDetails = paymentDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PaymentDetails with provided ID not found"));
        existingPaymentDetails.setOrderDetails(paymentDetailsDTO.getOrderDetails());
        existingPaymentDetails.setProvider(paymentDetailsDTO.getProvider());
        existingPaymentDetails.setStatus(paymentDetailsDTO.getStatus());
        existingPaymentDetails.setAmount(paymentDetailsDTO.getAmount());
        return paymentDetailsMapper.convertToDTO(paymentDetailsRepository.save(existingPaymentDetails));
    }

    public PaymentDetailsDTO delete(Long id) {
        log.info("Deleting PaymentDetails {}", id);
        PaymentDetails existingPaymentDetails = paymentDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PaymentDetails with provided ID not found"));
        paymentDetailsRepository.deleteById(id);
        return paymentDetailsMapper.convertToDTO(existingPaymentDetails);
    }
    
}
