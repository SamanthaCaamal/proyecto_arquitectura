import { Component, OnInit } from '@angular/core';
import { EmployeeResponse } from 'src/app/model/employee';
import { EmployeeService } from 'src/app/service/employee/employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  public employeesList: EmployeeResponse[] = [];

  constructor(
    private employeeService: EmployeeService
  ) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  private async getEmployees() {
    try {
      this.employeesList = await this.employeeService.getEmployees().toPromise();
      console.log(this.employeesList);
    } catch (e) {
      console.log(e);
    }
  }

}
