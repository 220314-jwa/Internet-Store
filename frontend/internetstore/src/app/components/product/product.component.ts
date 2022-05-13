import { Component, Input, OnInit } from '@angular/core';
import { Product } from '../../models/product';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  @Input() product!: Product;
  constructor(private productServ: ProductService) { }

  ngOnInit(): void {
    this.product = new Product();
    //this.getProducts();
  }

  //getProducts() {
  // when we subscribe to the Observable, it sends the request
  // and we can set up what we want to do with the response
  // in a callback function
  // this.productServ.getProducts().subscribe(
  // resp => {
  //   this.products = resp;
  //   });
  //// }
}
