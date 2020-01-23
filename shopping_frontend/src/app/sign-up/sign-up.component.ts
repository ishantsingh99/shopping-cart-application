import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../authentication.service';
import {Router} from '@angular/router';
import {ItemserviceService} from '../itemservice.Service';
import {AppService} from '../app.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
   username;
   password;
  constructor( private authService: AuthenticationService, private router: Router,
               private httpclientService: ItemserviceService, private appService: AppService) { }

  ngOnInit() {
  }

    signupfunction() {
    const data = {
      username: this.username,
      password: this.password
    };
    this.authService.sendnewuser(data);
  }
}
