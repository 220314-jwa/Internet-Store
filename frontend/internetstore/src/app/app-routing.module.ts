import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OrdersComponent } from './components/orders/orders.component';
import { CartComponent } from './components/cart/cart.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { ProductComponent } from './components/product/product.component';
import { ProfilePageComponent } from './components/profile-page/profile-page.component';
import { CreateproductComponent } from './createproduct/createproduct.component';
import { NewProductComponent } from './new-product/new-product.component';
import { Category } from './category';
import { CategoryComponent } from './components/category/category.component';
const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'signup', component: SignupComponent },
    { path: 'myCart', component: CartComponent },
    { path: 'myOrders', component: OrdersComponent },
    { path: 'product', component: ProductComponent },
    { path: "profilePage", component: ProfilePageComponent },
    { path: "createProduct", component: CreateproductComponent },
    { path: "createCategory", component: CategoryComponent },
];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }