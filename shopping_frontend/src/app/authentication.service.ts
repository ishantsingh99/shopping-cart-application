import { Injectable } from '@angular/core';
import {HttpClient , HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient, private route: Router) {
  }

  authenticate(username, password) {
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ':' + password)});
    return this.httpClient.get('http://localhost:2019/products/api', {headers}).pipe(
      map(
        userData => {
          sessionStorage.setItem('token', btoa(username + ':' + password));
          return userData;
        }
      ));
  }
  sendnewuser(d) {
    return this.httpClient.post('http://localhost:2019/api1/adduser', d).subscribe((data) => {
      this.route.navigate(['/home-page']);
    });
  }
  getAll() {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({ Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/api1/Getuser', { headers});
  }
}

// isUserLoggedIn() {
//     const user = sessionStorage.getItem('username');
//     console.log(!(user === null));
//     return !(user === null);
//   }

// logout()
// {
//   sessionStorage.removeItem('username');
//   }
