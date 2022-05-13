import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/models/product';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  products!: Product[];
  constructor(private productServ: ProductService) { }
  loading = true;
  ngOnInit(): void {
    this.getProducts();
  }

  getProducts() {
    // when we subscribe to the Observable, it sends the request
    // and we can set up what we want to do with the response
    // in a callback function
    this.productServ.getProducts().subscribe(
      resp => {
        this.products = resp;
        console.log(this.products);
      });
    this.loading = false;
  }

}
