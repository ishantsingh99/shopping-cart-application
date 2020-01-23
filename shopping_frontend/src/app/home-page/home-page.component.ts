import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ItemserviceService} from '../itemservice.Service';
import {AppService} from '../app.service';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})

export class HomePageComponent implements OnInit {
  product1;
  items;
  totalquantity: number;
  category: string;
  constructor(private router: Router, private activated: ActivatedRoute,
              private httpclientService: ItemserviceService, private appService: AppService ) { }
   see;
  c1 = null ;
  hover: boolean;
  ngOnInit() {
    if (!this.appService.checkLogin()) {
      this.router.navigate(['login']);
    }
    this.httpclientService.getProducts().subscribe((data) => {
      this.product1 = data;
    });
  }
  goToDetails(id) {
    this.router.navigate(['/product-details'], { queryParams: {id}});
  }
  goToCart(id) {
    this.httpclientService.addProduct(id).subscribe((data) => {
      this.router.navigate(['/user-cart']);
    });
  }
  showElectronics() {
    this.c1 = 'electronics';
    this.httpclientService.getByCategory('electronics').subscribe((data) => {
      this.product1 = data;
    });
  }
  showSports() {
    this.c1 = 'sports';
    this.httpclientService.getByCategory('sports').subscribe((data) => {
      this.product1 = data;
    });
  }
  showClothing() {
    this.c1 = 'clothing';
    this.httpclientService.getByCategory('clothing').subscribe((data) => {
      this.product1 = data;
    });
  }
  showBooks() {
    this.c1 = 'books';
    this.httpclientService.getByCategory('books').subscribe((data) => {
      this.product1 = data;
    });
  }
  handleSelected($event, number1: number, number2: number) {
    if (!this.c1) {
      this.httpclientService.getPriceBtw(number1, number2).subscribe((data) => {
        this.product1 = data;
      });
    } else {
      this.httpclientService.getPriceAndCategoryBtw(this.c1, number1, number2).subscribe((data) => {
        this.product1 = data;
      });
    }
  }
  seename() {
    this.httpclientService.getByName(this.see).subscribe((data) => {
      this.product1 = data;
    });
  }
}



