import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url: string = 'http://localhost:8080/api/v1/';
  headers = { 'Content-type': 'application/json' };
  constructor(private http: HttpClient) { }
  body: any;
  async checkLogin(): Promise<User> {
    let userId = sessionStorage.getItem('Auth-Token');
    let httpResp = await fetch(this.url + "customer/" + userId, { headers: this.headers });
    if (httpResp && httpResp.status === 200) {
      return await httpResp.json();
    } else {
      return null as any;
    }
  }

  async logIn(credentials: any): Promise<User> {
    let credentialJSON = JSON.stringify(credentials);
    let httpResp = await fetch(this.url + 'auth/login',
      { method: 'POST', body: credentialJSON, headers: this.headers });
    if (httpResp && httpResp.status === 200) {
      let user = await httpResp.json();
      sessionStorage.setItem('Auth-Token', user.id.toString());
      console.log(user);
      return user;
    }
    return null as any;
  }

  createUser(user: User):Observable<User>{
  this.body = { firstName: user.firstName, lastName: user.lastName, email: user.email, address: user.address, password: user.password, phoneNumber: user.phoneNumber, username: user.username, admin: user.admin }
  console.log(user.firstName);
  return this.http.post(this.url + "customer", this.body, { headers: this.headers }).pipe(
    map(resp => resp as User)
  );
}
}