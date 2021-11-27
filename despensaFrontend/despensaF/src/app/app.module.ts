import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { ProductComponentComponent } from './component/product-component/product-component.component';
import { ProductFormComponent } from './component/product-form/product-form.component';
import { ProductService } from './service/product-service.service';


@NgModule({
  declarations: [
    AppComponent,
    ProductComponentComponent,
    ProductFormComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule

  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
