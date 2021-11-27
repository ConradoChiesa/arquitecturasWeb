import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Product } from '../model/product';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ProductService {

  private productUrl: string;

  constructor(private http: HttpClient) {
    this.productUrl = 'http://localhost:8080/product';
   }

   public findAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productUrl + '/getProducts');
  }

  public save(product: Product) {
    return this.http.post<Product>(this.productUrl + '/addProduct', product);
  }


}
