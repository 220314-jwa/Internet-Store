import { Pipe, PipeTransform } from '@angular/core';
import { Product } from './models/product';

@Pipe({
  name: 'productSearch'
})
export class ProductSearchPipe implements PipeTransform {

  transform(products: Product[], searchText: string): Product[] {
    let filteredProducts = [];
    searchText = searchText.toLowerCase();

    for (let product of products) {
      if (product.name != undefined && product.category?.name != undefined) {
        if (product.name.toLowerCase().includes(searchText)
          || product.category.name.toLowerCase().includes(searchText)) {
          filteredProducts.push(product);
        }
      }

    }

    return filteredProducts;
  }


}
