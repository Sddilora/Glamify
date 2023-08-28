package com.sd.ecommerce.dto.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sd.ecommerce.dto.PaymentDetailsDTO;
import com.sd.ecommerce.model.PaymentDetails;

@Component
public class PaymentDetailsMapper {
    
    public PaymentDetails convertToEntity(PaymentDetailsDTO paymentDetailsDTO) {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setId(paymentDetailsDTO.getId()); // TODO - is this needed?
        paymentDetails.setOrderDetails(paymentDetailsDTO.getOrderDetails());
        paymentDetails.setProvider(paymentDetailsDTO.getProvider());
        paymentDetails.setStatus(paymentDetailsDTO.getStatus());
        paymentDetails.setAmount(paymentDetailsDTO.getAmount());
        return paymentDetails;
    }

    public PaymentDetailsDTO convertToDTO(PaymentDetails paymentDetails) {
        return new PaymentDetailsDTO(paymentDetails.getId(), paymentDetails.getCreatedAt(), paymentDetails.getUpdatedAt(), paymentDetails.getOrderDetails(), paymentDetails.getProvider(), paymentDetails.getStatus(), paymentDetails.getAmount());
    }

    public List<PaymentDetailsDTO> convertToDTO(List<PaymentDetails> paymentDetails) {
        return paymentDetails.stream().map(this::convertToDTO).collect(java.util.stream.Collectors.toList());
    }
}
