import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';
import {AppService} from '../app.service';
import {ItemserviceService} from '../itemservice.Service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss']
})
export class AddProductComponent implements OnInit {
  name;
  price;
  active;
  category;
  deliveredby;
  src;
  others;
  pid;
  prods;
  // url = 'http://localhost:2019/cart/addtocart/recieve';
  constructor(private http: HttpClient, private route: Router,
              private serve: AppService, private r: ActivatedRoute,
              private it: ItemserviceService, ) { }

  ngOnInit() {
    if (this.serve.checkEdit()) {
      this.r.queryParamMap.subscribe((data) => {
        this.pid = data.get('pid');
        this.it.getById(this.pid).subscribe((pdata) => {
          this.prods = pdata;
          this.name = this.prods.name;
          this.category = this.prods.category;
          this.src =  this.prods.src;
          this.active =  this.prods.active;
          this.deliveredby = this.prods.deliveredby;
          this.others = this.prods.others;
          this.price = this.prods.price;
        });
      });
    }
  }

  add() {
    this.it.createProduct({
      name: this.name,
      price: this.price,
      category: this.category,
      others: this.others,
      deliveredby: this.deliveredby,
      src: this.src,
      active: this.active
    }).subscribe(() => {
      this.route.navigate(['/home-page']);
    });
  }

}
