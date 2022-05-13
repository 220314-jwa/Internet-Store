import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { Router } from "@angular/router"
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],

})
export class LoginComponent implements OnInit {
  @Output() loginOrLogout: EventEmitter<any> = new EventEmitter();
  hide = true;
  credentials = {
    username: '',
    password: ''
  };

  loggedInUser!: any;
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.getLoggedInUser();
  }

  async getLoggedInUser() {
    this.loggedInUser = await this.userService.checkLogin();
  }

  async logIn(): Promise<void> {
    this.loggedInUser = await this.userService.logIn(this.credentials);
    if (this.loggedInUser) {
      this.loginOrLogout.emit();
      this.router.navigate(['']);
      //this.reloadPage();

    }
  }

  reloadPage(): void {
    window.location.reload();
  }
  logOut(): void {
    sessionStorage.removeItem('Auth-Token');
    this.loggedInUser = null;
    // firing the custom event
    this.loginOrLogout.emit();
  }





}
