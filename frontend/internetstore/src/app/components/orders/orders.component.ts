import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Orders } from 'src/app/models/order';



const ORDER_DATA: Orders[] = [
  { order_number: 1, order_id: 1234, order_date: new Date("2020-01-16"), order_status: 'approved' },
  { order_number: 2, order_id: 1652, order_date: new Date("2019-01-16"), order_status: 'pending' },
  { order_number: 3, order_id: 6616, order_date: new Date("2019-01-16"), order_status: 'awaiting paymnet' },
  { order_number: 4, order_id: 4658, order_date: new Date("2022-03-15"), order_status: 'order shipped' },
  { order_number: 5, order_id: 3554, order_date: new Date("2020-01-16"), order_status: 'pending' },
  { order_number: 6, order_id: 4989, order_date: new Date("2020-01-16"), order_status: 'approved' },
  { order_number: 7, order_id: 7984, order_date: new Date("2020-01-16"), order_status: 'pending' },
];
@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})


export class OrdersComponent {



  displayedColumns: string[] = ['order_number', 'order_id', 'order_date', 'order_status'];
  dataSource = new MatTableDataSource(ORDER_DATA);

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
};

