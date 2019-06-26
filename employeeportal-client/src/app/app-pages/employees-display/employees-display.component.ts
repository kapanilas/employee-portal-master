import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/app-service/api/employee.service';
import { Employee } from 'src/app/app-service/model/employee';

@Component({
  selector: 'app-employees-display',
  templateUrl: './employees-display.component.html',
  styleUrls: ['./employees-display.component.css']
})
export class EmployeesDisplayComponent implements OnInit {
  employees: Employee[] = [];
  message: string;
  constructor(private employeeService: EmployeeService) { }


   ngOnInit(): void {
     this.employeeService.getAllEmployees().subscribe(employees => {
         this.employees = employees
     }, error=> {
       this.message = "No Employees to display, Please register employees!!!"
     })
  }

}
