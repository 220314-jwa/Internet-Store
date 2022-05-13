import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user!: User;
  constructor(private userServ: UserService) { }

  ngOnInit(): void {
    this.user = new User();
  }

  createUser() {
    console.log(this.user);
    this.userServ.createUser(this.user).subscribe(
      resp => {
        this.user = resp;
      });
  }
}
