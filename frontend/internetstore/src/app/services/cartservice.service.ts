import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/product';
const Cart_API = 'http://localhost:8080/api/cart/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class CartserviceService {

  body: any;

  constructor(private http: HttpClient) { }
  remove(product: any): Observable<any> {
    return this.http.post(Cart_API + 'remove', {
      product

    }, httpOptions);
  }
  addToCart(product: Product) {
    this.body = { name: product.name, price: product.price, category: { id: product.category?.id, description: product.category?.description, name: product.category?.name }, code: product.code, prodDate: product.prodDate }
    console.log(product.name);
    return this.http.post(Cart_API, this.body, { headers: this.headers }).pipe(
      map(resp => resp as Product)
    );
  }
}





