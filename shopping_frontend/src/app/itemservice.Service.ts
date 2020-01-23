import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class ItemserviceService {

  constructor(
    private route: Router,
    private httpClient: HttpClient
  ) {
  }

  updateNote(id, data) {
    console.log(id);
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.put('http://localhost:2019/products/put/' + id, data, {headers});
  }

  createProduct(data) {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.post('http://localhost:2019/products/post', data, {headers});
  }

  getByCategory(type) {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/products/cat/' + type, {headers});
  }

  public getProducts() {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/products/api', {headers});
  }

  public getById(id1) {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/products/getbyid/' + id1, {headers});
  }

  public getPriceAndCategoryBtw(category, type1, type2) {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/products/category/' + category + '/price/' + type1 + '/between/' + type2, {headers});
  }

  public getPriceBtw(type1, type2) {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/products/get/' + type1 + '/between/' + type2, {headers});
  }

  public findByUserId(id1) {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/products/getbyid/' + id1, {headers});
  }

  getByName(name) {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/products/search/' + name, {headers});
  }

  removeproduct(id1) {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/cart/removeproduct/recieve/' + id1, {headers});
  }

  addProduct(id1) {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/cart/addtocart/recieve/' + id1, {headers});
  }

  removefromcart(id1) {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/cart/removefromcart/recieve/' + id1, {headers});
  }

  showcart() {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/cart/showcart/recieve', {headers});
  }

  clearcart() {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/cart/clearcart/recieve', {headers});
  }

  checkout() {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/cart/checkout', {headers});
  }

  calquantity() {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/cart/quantity', {headers});
  }

  calprice() {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/cart/price', {headers});
  }

  showorderhistory() {
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({Authorization: 'Basic ' + token});
    return this.httpClient.get('http://localhost:2019/cart/showOrderHistory', {headers});
  }
}


