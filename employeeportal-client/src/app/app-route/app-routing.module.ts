import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeRegistrationComponent } from '../app-pages/employee-registration/employee-registration.component';
import { EmployeesDisplayComponent } from '../app-pages/employees-display/employees-display.component';
import { DashboardComponent } from '../app-pages/dashboard/dashboard.component';

const routes: Routes = [  
{ path: '', redirectTo: "/index.html", pathMatch: 'full'},
{ path: 'index.html', component: DashboardComponent  },
{ path: 'employee', component: EmployeeRegistrationComponent },
{ path: 'employees', component: EmployeesDisplayComponent },]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
