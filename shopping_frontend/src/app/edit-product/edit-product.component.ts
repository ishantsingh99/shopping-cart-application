import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';
import {AppService} from '../app.service';
import {ItemserviceService} from '../itemservice.Service';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.scss']
})
export class EditProductComponent implements OnInit {
  private pid: any;
  private prods;
  private category: any | string;
  private name: any;
  private src: string | any;
  private deliveredby: any;
  private active: any;
  private price: any;
  private others: any;


  constructor(private http: HttpClient, private route: Router,
              private serve: AppService, private r: ActivatedRoute,
              private it: ItemserviceService) { }
  ngOnInit() { if (this.serve.checkEdit()) {
    this.r.queryParamMap.subscribe((data) => {
      console.log(data.get('id'));
      this.pid = data.get('id');
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
    console.log(this.pid);
  }
  }

  editP() {
    this.it.updateNote(this.pid, {
      name: this.name,
      id: this.pid,
      price: this.price,
      category: this.category,
      others: this.others,
      deliveredby: this.deliveredby,
      src: this.src,
      active: this.active
    }).subscribe((data) => {
      localStorage.removeItem('edit');
      alert('Product Updated Successfully!!');
      this.route.navigate(['/home-page']);
    });
  }
}
