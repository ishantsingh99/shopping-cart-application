import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../authentication.service';
import {ProfileService} from '../profile_service';
import {RouterEntryPoint} from '@angular/compiler-cli/src/ngtsc/routing/src/route';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AppService} from '../app.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  user;
  disabled = true;
  url = 'http://localhost:2019/api1/updateuser';

  constructor(private auth: AuthenticationService, private profileservice: ProfileService,
              private router: Router, private route: ActivatedRoute,
              private http: HttpClient, private app: AppService) {
  }
  ngOnInit() {
    this.profileservice.getUsers().subscribe(data => {
      this.user = data;
    });
  }
  toggle() {
    this.disabled = false;
  }
  save() {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.http.put(this.url, this.user, {headers}).subscribe(data => {
      alert('MyProfile Updated');
      console.log(this.user);
      this.app.isLoggedin(false);
      this.router.navigate(['/login']);
      this.disabled = true;
    });
  }
}
