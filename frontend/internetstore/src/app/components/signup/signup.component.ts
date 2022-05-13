import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user!: User;
  constructor(private userServ: UserService, private router: Router) { }

  ngOnInit(): void {
    this.user = new User();
  }

  createUser() {
    console.log(this.user);
    this.userServ.createUser(this.user).subscribe(
      resp => {
        this.user = resp;
        console.log(resp.id);

        if (resp.id) {
          this.router.navigate(['/login']);
        }
        window.alert("You succesfully created user!");


      });
  }
}
