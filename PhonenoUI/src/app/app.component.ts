import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'PhonenoUI';
  modifiedPhoneNumber:any;
  phoneNumber:string;
  private gridApi;
  private gridOptions;
  private showGrid = false;
  columnDefs = [
    {headerName: 'Phone Number', field: 'phoneNo' }
  ]; 
  constructor(private appService:AppService){
    this.gridOptions = {
      rowHeight:39,
      pagination:true,
      paginationPageSize:10
    };
  }

  ngOnInit(){
    
  }
  
  onGridReady(params){
    this.gridApi = params.api;
  }

  updateValue(value){
    this.phoneNumber = value;
  }
  clear(){
    this.showGrid=false;
    this.phoneNumber = '';
  }
  getData(){
    this.appService.getModifiedPhoneNumbers(this.phoneNumber).subscribe(data=>{      
      this.showGrid=true;
      this.modifiedPhoneNumber=data;
    });
  }
}
