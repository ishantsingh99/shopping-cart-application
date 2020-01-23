import { Component, OnInit } from '@angular/core';
import {ItemserviceService} from '../itemservice.Service';

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.scss']
})
export class OrderHistoryComponent implements OnInit {
  totalQuantity: number;
  totalPrice: number;
  order;


  constructor(private httpc: ItemserviceService) { }

  ngOnInit() {
    this.httpc.showorderhistory().subscribe(data => {
      this.order = data;
    });
    }

}
