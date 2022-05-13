import { Component, Input, OnInit } from '@angular/core';
import { CategoryService } from '../category.service';
import { Product } from '../models/product';
import { ProductService } from '../services/product.service';
import { Category } from '../category';
@Component({
  selector: 'app-createproduct',
  templateUrl: './createproduct.component.html',
  styleUrls: ['./createproduct.component.css']
})
export class CreateproductComponent implements OnInit {
  product!: Product;
  categories!: Category[];
  selected: any;
  category!: Category;

  constructor(private productServ: ProductService, private categoryServ: CategoryService) {
  }

  ngOnInit(): void {
    this.product = new Product();
    this.category = new Category();
    this.getCategories();
  }

  createProduct() {
    //this.category.id = this.selected.id;
    this.product.category = this.category;
    console.log(this.product);
    console.log(this.category.id);
    this.productServ.createProduct(this.product).subscribe(
      resp => {
        this.product = resp;
      });
  }

  getCategories() {
    // when we subscribe to the Observable, it sends the request
    // and we can set up what we want to do with the response
    // in a callback function
    this.categoryServ.getCategories().subscribe(
      resp => {
        this.categories = resp;
        console.log(this.categories);
      });
  }



}
