import { Injectable } from '@angular/core';
import { Category } from './category';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  url: string = 'http://localhost:8080/api/v1/category';
  headers = { 'Content-type': 'application/json' };
  body: any;
  constructor(private http: HttpClient) { }


  createCategory(category: Category) {
    this.body = { name: category.name, description: category.description }
    console.log(category.name);
    return this.http.post(this.url, this.body, { headers: this.headers }).pipe(
      map(resp => resp as Category)
    );
  }

  getCategories(): Observable<Category[]> {
    return this.http.get(this.url).pipe(
      // format/map the response body as an array of pets
      map(resp => resp as Category[])
    );
  }




}
