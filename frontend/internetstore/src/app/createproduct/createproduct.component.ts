import { Component, OnInit } from '@angular/core';
import { Product } from '../models/product';
import { ProductService } from '../services/product.service';
@Component({
  selector: 'app-createproduct',
  templateUrl: './createproduct.component.html',
  styleUrls: ['./createproduct.component.css']
})
export class CreateproductComponent implements OnInit {
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
