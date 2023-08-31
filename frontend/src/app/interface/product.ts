import { Discount } from "./discount";
import { ProductCategory } from "./product-category";
import { ProductInventory } from "./product-inventory";

export interface Product {
    id: number;
    createdAt: Date;
    updatedAt: Date;
    deleted: boolean;
    name: string;
    price: number;
    photoUrl: string;
    description: string;
    sku: string;
    productCategory: ProductCategory;
    productInventory: ProductInventory;
    discount: Discount;
}
