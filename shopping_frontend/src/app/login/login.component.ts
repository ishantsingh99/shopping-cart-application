import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {AppService} from '../app.service';
import {ItemserviceService} from '../itemservice.Service';
import {AuthenticationService} from '../authentication.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username ;
  password ;
  invalidLogin = false;

  constructor(private router: Router, private appService: AppService,
              private authService: AuthenticationService,   private httpclientService: ItemserviceService) { }

  ngOnInit() {
    if (this.appService.checkLogin()) {
      this.router.navigate(['home-page']);
    }
  }
    login() {
      this.authService.authenticate(this.username, this.password).subscribe(
        data => {
          if (this.username === 'ishant' && this.password === '12345') {
            this.appService.myfun(true);
            alert('You are Admin');
          } else {
            this.appService.myfun(false);
            alert('You are Customer');
          }
          this.appService.isLoggedin(true);
          this.router.navigate(['home-page']);
        }
      );
    }
  logout() {
    this.appService.isLoggedin(false);
  }
}



