import { Component, OnInit } from '@angular/core';
import { Product } from '../models/product';
import { ProductService } from '../services/product.service';
@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {

  product!: Product;
  constructor(private productServ: ProductService) { }

  ngOnInit(): void {
    this.product = new Product();
  }

  createProduct() {
    console.log(this.product);
    this.productServ.createProduct(this.product).subscribe(
      resp => {
        this.product = resp;
      });
  }
}
