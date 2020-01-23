import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MAIN_ROUTES} from './app.route';
import {HomePageComponent} from './home-page/home-page.component';
import {UserCartComponent} from './user-cart/user-cart.component';
import {ProductDetailsComponent} from './product-details/product-details.component';
import {NavBarComponent} from './nav-bar/nav-bar.component';
import {LoginComponent} from './login/login.component';
import {SignUpComponent} from './sign-up/sign-up.component';
import {AddProductComponent} from './add-product/add-product.component';
import {EditProductComponent} from './edit-product/edit-product.component';

@NgModule({
  imports: [RouterModule.forRoot(MAIN_ROUTES)],
  exports: [RouterModule]
})
export class AppRoutingModule { HomePageComponent; UserCartComponent;
ProductDetailsComponent; NavBarComponent; LoginComponent;
SignUpComponent; ProfileComponent; LogoutComponent;  AddProductComponent;  EditProductComponent; }
