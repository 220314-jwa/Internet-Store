import { Product } from "./product";
import { User } from "./user";
export class Cart {
    constructor(
        public cartId: number,
        public quantity: number,
        public totalCost: number,
        public user: User,
        public product: Product,
    ) { }
}