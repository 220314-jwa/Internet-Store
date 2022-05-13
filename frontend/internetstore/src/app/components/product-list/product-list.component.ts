import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductComponent } from '../product/product.component';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { ProductService } from 'src/app/services/product.service';
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products!: Product[];
  loggedInUser!: User;
  loading = true;
  productSearchText: string = '';

  constructor(private userServ: UserService, private productServ: ProductService) { }

  ngOnInit(): void {
    this.getProducts();
    this.getLoggedInUser();
  }

  async getLoggedInUser() {
    this.loggedInUser = await this.userServ.checkLogin();
  }


  getProducts() {
    // when we subscribe to the Observable, it sends the request
    // and we can set up what we want to do with the response
    // in a callback function
    this.productServ.getProducts().subscribe(
      resp => {
        this.products = resp;
      });
    this.loading = false;
  }

}
