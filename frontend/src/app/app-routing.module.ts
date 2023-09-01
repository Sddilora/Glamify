import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductListComponent } from './component/product-list/product-list.component';
import { CartDetailsComponent } from './component/cart-details/cart-details.component';

const routes: Routes = [
  { path: 'products', component: ProductListComponent },
  { path: 'cart-details', component: CartDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
