import {Component, Injectable, OnInit} from '@angular/core';
import {AuthenticationService} from '../authentication.service';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {AppService} from '../app.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {

  constructor( private appService: AppService,
               private authService: AuthenticationService, private route: Router) {
  }

  ngOnInit() {
  }

  logout() {

    this.appService.isLoggedin(false);
    this.route.navigate(['login']);
  }
  showcart() {
    this.route.navigate(['/user-cart']);
  }
}

@Injectable({
    providedIn: 'root'
  })
  export class HttpClientService {

  constructor(
    private httpClient: HttpClient, private app: AppService, private router: Router,
  ) {}

  getProducts() {
    return this.httpClient.get('http://localhost:2019/products/api');
  }
  addPro() {
    this.app.edit(false);
    this.router.navigate(['add-product']);
          }
}
