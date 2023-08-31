import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './component/product-list/product-list.component';
import { RouterModule, Routes } from '@angular/router';
import { CartDetailsComponent } from './component/cart-details/cart-details.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';


const routes: Routes = [
  { path: 'products', component: ProductListComponent },
  { path: 'cart-details', component: CartDetailsComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    CartDetailsComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


