import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/category';
import { CategoryService } from 'src/app/category.service';
@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  category!: Category;
  constructor(private categoryServ: CategoryService, private router: Router) { }

  ngOnInit(): void {
    this.category = new Category();
  }


  createCategory() {
    console.log(this.category);
    this.categoryServ.createCategory(this.category).subscribe(
      resp => {
        if (resp) {
          this.router.navigate(['']);
        }
        this.category = resp;
      });
  }


}
