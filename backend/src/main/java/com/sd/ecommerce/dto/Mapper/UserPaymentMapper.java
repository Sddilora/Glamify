package com.sd.ecommerce.dto.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sd.ecommerce.dto.UserPaymentDTO;
import com.sd.ecommerce.model.UserPayment;

@Component
public class UserPaymentMapper {

    public UserPayment convertToEntity(UserPaymentDTO userPaymentDTO) {
        UserPayment userPayment = new UserPayment();
        userPayment.setId(userPaymentDTO.getId());
        userPayment.setUser(userPaymentDTO.getUser());
        userPayment.setPaymentType(userPaymentDTO.getPaymentType());
        userPayment.setProvider(userPaymentDTO.getProvider());
        userPayment.setAccount_no(userPaymentDTO.getAccount_no());
        userPayment.setExpiry_date(userPaymentDTO.getExpiry_date());
        return userPayment;
    }

    public UserPaymentDTO convertToDTO(UserPayment userPayment) {
        return new UserPaymentDTO(userPayment.getId(), userPayment.getUser(), userPayment.getPaymentType(), userPayment.getProvider(), userPayment.getAccount_no(), userPayment.getExpiry_date());
    }

    public List<UserPaymentDTO> convertToDTO(List<UserPayment> userPayments) {
        return userPayments.stream().map(this::convertToDTO).collect(java.util.stream.Collectors.toList());
    }
    
}
