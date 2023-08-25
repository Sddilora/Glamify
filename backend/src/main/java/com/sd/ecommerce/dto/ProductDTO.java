package com.sd.ecommerce.dto;

import com.sd.ecommerce.model.Discount;
import com.sd.ecommerce.model.ProductCategory;
import com.sd.ecommerce.model.ProductInventory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;
    private Double price;
    private String photoUrl;
    private String description;
    private String sku;
    private ProductCategory categoryId;
    private ProductInventory inventoryId;
    private Discount discountId;

}
