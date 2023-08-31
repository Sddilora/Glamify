export interface Discount {
    id: number;
    createdAt: Date;
    updatedAt: Date;
    deleted: boolean;
    name: string;
    description: string;
    discountPercent: number;
    isActive: boolean;
}
