import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  constructor(private http: HttpClient) {}
  getUsers() {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({ Authorization: 'Basic ' + token });
    return this.http.get('http://localhost:2019/api1/Getuser', {headers});
  }
  editMyUser(user) {
  const token = sessionStorage.getItem('token');
  const headers = new HttpHeaders({ Authorization: 'Basic ' + token });
  return this.http.post('http://localhost:2019/api1/updateuser', user, {headers});
  }
}
