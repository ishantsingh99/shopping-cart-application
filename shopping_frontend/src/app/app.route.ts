import {Routes} from '@angular/router';
import {HomePageComponent} from './home-page/home-page.component';
import {UserCartComponent} from './user-cart/user-cart.component';
import {ProductDetailsComponent} from './product-details/product-details.component';
import {NavBarComponent} from './nav-bar/nav-bar.component';
import {LoginComponent} from './login/login.component';
import {SignUpComponent} from './sign-up/sign-up.component';
import {ProfileComponent} from './profile/profile.component';
import {LogoutComponent} from './logout/logout.component';
import {OrderHistoryComponent} from './order-history/order-history.component';
import {AddProductComponent} from './add-product/add-product.component';
import {EditProductComponent} from './edit-product/edit-product.component';


export const MAIN_ROUTES: Routes = [
  { path: '', redirectTo: 'home-page', pathMatch: 'full',  },
  { path: 'home-page', component: HomePageComponent, },
  { path: 'user-cart', component: UserCartComponent, },
  { path: 'product-details', component: ProductDetailsComponent, },
  { path: 'nav-bar', component: NavBarComponent, },
  { path: 'login', component: LoginComponent, },
  { path: 'logout', component: LogoutComponent, },
  { path: 'profile', component: ProfileComponent, },
  { path: 'signup', component: SignUpComponent, },
  { path: 'add-product', component:  AddProductComponent, },
  { path: 'edit-product', component:  EditProductComponent, },
  { path: 'order-history', component: OrderHistoryComponent, },
  { path: '**', component: HomePageComponent, },

];
