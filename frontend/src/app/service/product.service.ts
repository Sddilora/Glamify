import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from "rxjs";
import { CustomResponse } from "../interface/custom-response";
import { Product } from "../interface/product";

@Injectable({ providedIn: "root" })
export class ProductService {

  private baseUrl = "http://localhost:8191/";

  constructor(private http: HttpClient) { }

  public getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl + "product");
  }

  public getProductById(id: number): Observable<Product> {
    return this.http.get<Product>(this.baseUrl + "product/" + id);
  }

  public addProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.baseUrl + "product", product);
  }

  public updateProduct(product: Product, id: number): Observable<Product> {
    return this.http.put<Product>(this.baseUrl + "product" + id, product);
  }

  public deleteProduct(id: number): Observable<Product> {
    return this.http.delete<Product>(this.baseUrl + "product" + id);
  }

}
