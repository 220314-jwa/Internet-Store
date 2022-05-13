import { BrowserModule } from '@angular/platform-browser';
/* Routing */
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
/* Angular Material */
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './angular-material.module';
import { NgModule } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
/* FormsModule */
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
/* Angular Flex Layout */
import { FlexLayoutModule } from "@angular/flex-layout";
import { OrdersComponent } from './components/orders/orders.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { SignupComponent } from './components/signup/signup.component';
import { CartComponent } from './components/cart/cart.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ProfilePageComponent } from './components/profile-page/profile-page.component';
import { ProductComponent } from './components/product/product.component';
import { HttpClientModule } from '@angular/common/http';
import { ProductService } from './services/product.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ProductListComponent } from './components/product-list/product-list.component';
import { CreateproductComponent } from './createproduct/createproduct.component';
import { NewProductComponent } from './new-product/new-product.component';
import { CategoryComponent } from './components/category/category.component';
import { ProductSearchPipe } from './product-search.pipe';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
/* Components */



@NgModule({
  declarations: [
    AppComponent,
    OrdersComponent,
    LoginComponent,
    HomeComponent,
    SignupComponent,
    CartComponent,
    NavbarComponent,
    ProfileComponent,
    ProfilePageComponent,
    ProductComponent,
    ProductListComponent,
    CreateproductComponent,
    NewProductComponent,
    CategoryComponent,
    ProductSearchPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    ReactiveFormsModule,
    FormsModule,
    FlexLayoutModule,
    HttpClientModule,
    NgbModule,
    MatDatepickerModule,
    MatNativeDateModule,
  ],
  providers: [ProductService, MatDatepickerModule,],
  bootstrap: [AppComponent],
})
export class AppModule { }