import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/interface/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit{

  products: Product[] = [];

  constructor( private productService: ProductService, private route: ActivatedRoute ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
  }

  listProducts() {
    this.productService.getAllProducts().subscribe(
      (response: any) => {
        this.products = response.data.products; // Assign the array of products
      },
      (error) => {
        console.error(error);
      }
    );
  }

}
