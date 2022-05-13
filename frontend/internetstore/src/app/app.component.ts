import { Component, OnInit } from '@angular/core';
import { UserService } from './services/user.service';
import { User } from './models/user';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  preserveWhitespaces: true
})

export class AppComponent implements OnInit {
  loggedInUser: any;
  constructor(private userServ: UserService, private router: Router) {

  }
  title = 'Market';

  ngOnInit(): void {
    this.getLoggedInUser();
  }

  async getLoggedInUser() {
    this.loggedInUser = await this.userServ.checkLogin();
    console.log(this.loggedInUser);
  }


  navigateToMain(): void {
    this.getLoggedInUser();

  }
}

