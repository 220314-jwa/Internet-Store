import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Input } from '@angular/core';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  @Input() loggedInUser!: any
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getLoggedInUser();
  }
  // creating a custom event on this component
  @Output() loginOrLogout: EventEmitter<any> = new EventEmitter();

  async getLoggedInUser() {
    this.loggedInUser = await this.userService.checkLogin();
  }

  logOut(): void {
    sessionStorage.removeItem('Auth-Token');
    this.loggedInUser = null;
    // firing the custom event
    this.loginOrLogout.emit();
    window.location.reload();
  }


}
