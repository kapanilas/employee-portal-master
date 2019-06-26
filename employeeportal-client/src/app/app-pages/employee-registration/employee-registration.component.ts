import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbDateParserFormatter, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { EmployeeService } from 'src/app/app-service/api/employee.service';
import { Employee } from '../../app-service/model/employee';

@Component({
  selector: 'app-employee-registration',
  templateUrl: './employee-registration.component.html',
  styleUrls: ['./employee-registration.component.css']
})
export class EmployeeRegistrationComponent implements OnInit {
  employeeForm: FormGroup;
  message: string;
  employee: Employee;

  constructor(private fb: FormBuilder,private router: Router, private dateFormatter: NgbDateParserFormatter, private employeeService: EmployeeService) { }

  ngOnInit() {
      this.employeeForm = this.fb.group({
         employeeId: ['', [Validators.required, Validators.pattern(/^-?(0|[1-9]\d*)?$/)]],
          firstName: ['', [Validators.required, Validators.pattern('^[A-Za-z]+$')]],
          lastName: ['', [Validators.required, Validators.pattern('^[A-Za-z]+$')]],
          gender: 'Male',
          dob: [''],
          department: ''
      });

      this.employeeForm.get('gender').valueChanges.subscribe(
          value => this.setGender(value)
      );


      this.employeeForm.get('dob').valueChanges.subscribe(
          value => this.setDob(value)
      );
  }

  register() {
      if (this.employeeForm.valid) {

          const date: NgbDateStruct = this.employeeForm.value["dob"];

          this.employee = new Employee();
          this.employee.employeeId = this.employeeForm.value["employeeId"];
          this.employee.firstName = this.employeeForm.value["firstName"];
          this.employee.lastName = this.employeeForm.value["lastName"];
          this.employee.dob = this.dateFormatter.format(date);
          this.employee.gender = this.employeeForm.value["gender"];
          this.employee.department = this.employeeForm.value["department"];

          this.employeeService.registerEmployee(this.employee).subscribe(
              response => {
                  if (response == "200") {
                      this.message = "Registration Successful";
                  }
              }, error => {
                  console.log(error);
                  if (error.status == "409") {
                      this.message = "Employee already exists";
                  } else {
                      this.message = "Registration is Unsuccessful"
                  }
              })
      } else {
          console.log("Validations failed! Cannot proceed further");
          this.message = "Validations failed! Cannot proceed further";
      }
  }

  setDob(dob: string): void {
      console.log(dob);
  }

  setGender(gender: string): void {
      if (gender === 'Male') {

      } else {

      }
  }

}

