import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ItemserviceService} from '../itemservice.Service';
import {AppService} from '../app.service';

@Component({
  selector: 'app-user-cart',
  templateUrl: './user-cart.component.html',
  styleUrls: ['./user-cart.component.scss']
})
export class UserCartComponent implements OnInit {
  userId;
  product1;
  totalQuantity: number;
  totalPrice: any = 0;

  Id1: number;

  constructor(private httpclientService: ItemserviceService,
              private route: Router ) { }

  ngOnInit() {
    return this.httpclientService.showcart().subscribe((data) => {
      this.product1 = data;
      this.totalquantity();
      this.totalprice();
    });
  }
    addProduct(id1: number) {
      this.httpclientService.addProduct(id1).subscribe((data) => {
        this.httpclientService.showcart().subscribe((data1) => {
          this.product1 = data1;
          this.totalquantity();
          this.totalprice();
        });
      });
    }
    removefromcart(id1: number) {
      this.httpclientService.removefromcart(id1).subscribe((data) => {
        this.httpclientService.showcart().subscribe((data1) => {
          this.product1 = data1;
        });
      });
    }
    removeproduct(id1: number) {
      this.httpclientService.removeproduct(id1).subscribe((data) => {
        this.httpclientService.showcart().subscribe((data1) => {
          this.product1 = data1;
          this.totalquantity();
          this.totalprice();
        });
      });
    }
    clearcart() {
      this.httpclientService.clearcart().subscribe((data) => {
        this.httpclientService.showcart().subscribe((data1) => {
          this.product1 = data1;
          this.totalQuantity = 0;
          this.totalPrice = 0;
        });
      });
    }
  checkout() {
    this.httpclientService.checkout().subscribe((data) => {
      this.httpclientService.showcart().subscribe((data1) => {
        this.product1 = data1;
        this.totalQuantity = 0;
        this.totalPrice = 0;
        this.route.navigate(['/order-history']);
      });
    });
  }
  totalquantity() {
    this.httpclientService.calquantity().subscribe((data: number) => {
      this.totalQuantity = data;
    });
  }
  totalprice() {
    this.httpclientService.calprice().subscribe((data) => {
      this.totalPrice = data;
    });
  }
}
