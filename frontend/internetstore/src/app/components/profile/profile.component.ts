import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { UserService } from '../../services/user.service';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  @Input() loggedInUser!: any
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getLoggedInUser();
  }

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
