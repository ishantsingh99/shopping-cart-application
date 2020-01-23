import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ItemserviceService} from '../itemservice.Service';
import {AppService} from '../app.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss']
})
export class ProductDetailsComponent implements OnInit {
  products;
  userId: number;

  constructor(private activatedRoute: ActivatedRoute, private router: Router,
              private httpclientService: ItemserviceService, private appService: AppService) { }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe((params) => {
      this.userId = params.id;
    });
    this.httpclientService.getById(this.userId).subscribe((data) => {
      this.products = data;
    });
  }
  goToCart(id) {
    this.httpclientService.addProduct(id).subscribe((data) => {
      this.router.navigate(['/user-cart']);
    });
  }

  editpro(id: any) {
    this.appService.edit(true);
    this.router.navigate(['/edit-product'], {
      relativeTo : this.activatedRoute,
      queryParams: {
        id: id
      }
    });
  }
}

