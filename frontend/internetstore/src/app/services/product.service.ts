import { Injectable } from '@angular/core';
import { Product } from '../models/product';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Category } from '../category';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  url: string = 'http://localhost:8080/api/v1/product';
  headers = { 'Content-type': 'application/json' };
  body: any;
  category!: Category;

  constructor(private http: HttpClient) { }
  getProducts(): Observable<Product[]> {
    return this.http.get(this.url).pipe(
      // format/map the response body as an array of pets
      map(resp => resp as Product[])
    );
  }



  createProduct(product: Product) {
    this.body = { name: product.name, price: product.price, category: { id: product.category?.id, description: product.category?.description, name: product.category?.name}, code: product.code, prodDate: product.prodDate }
    console.log(product.name);
    return this.http.post(this.url, this.body, { headers: this.headers }).pipe(
      map(resp => resp as Product)
    );
  }


}

