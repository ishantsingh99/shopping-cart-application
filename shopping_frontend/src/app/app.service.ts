import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Route, Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private httpClient: HttpClient, private router: Router) { }
  isLoggedin(bool: boolean) {
    sessionStorage.setItem('auth', String(bool));
    return bool;
  }
  myfun(bool: boolean) {
    sessionStorage.setItem('admin', String(bool));
    return bool;
  }
   isAdmin() {
     const ad = sessionStorage.getItem('admin');
     return JSON.parse(ad);
   }
  checkLogin() {
    const auth = sessionStorage.getItem('auth');
    return JSON.parse(auth);
  }
  addUser(user) {
    return this.httpClient.post('http://localhost:2019/api1/adduser' , user).subscribe(res =>
      this.router.navigate(['/home-page']));
  }
  checkEdit() {
    const ad = sessionStorage.getItem('edit');
    return JSON.parse(ad);
  }
  edit(bool: boolean) {
    localStorage.setItem('edit', String(bool));
    return bool;
  }
}
