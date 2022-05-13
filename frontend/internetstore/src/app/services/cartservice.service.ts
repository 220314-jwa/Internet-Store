import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
const Cart_API = 'http://localhost:8080/api/cartId/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class CartserviceService {

  
  
    constructor(private http: HttpClient) { }
    remove(product: any): Observable<any> {
      return this.http.post(Cart_API + 'remove', {
        product
        
      }, httpOptions);
    }
    buy(product:any): Observable<any> {
      return this.http.post(Cart_API + 'buy', {
        product
      
        
      }, httpOptions);
    }
  }





