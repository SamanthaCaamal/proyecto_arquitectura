import { Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { EmployeeResponse } from 'src/app/model/employee';
import { EmployeeService } from 'src/app/service/employee/employee.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  public employeesList: EmployeeResponse[] = [];
  model = new EmployeeResponse();
  dialog!: NgbModalRef | null;
  public clientIdSelected!: any;
  @ViewChild('content') content!: ElementRef;
  public page = 20;
  public pageSize = 6;
//  public arrayChecked: string[] = [];

  constructor(
    private employeeService: EmployeeService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  private async getEmployees() {
    try {
      this.employeesList = await this.employeeService.getEmployees().toPromise();
    } catch (e) {
      console.log(e);
    }
  }

  public save() {
    if(this.model.id) {
      this.updateEmployee()
    } else {
      this.addEmployee();
    }
  }

  //Methods Api
  async addEmployee() {
    try {
      await this.employeeService.createEmployee(this.model).toPromise();
      //console.log(this.model);
      this.getEmployees();
      this.close();
      Swal.fire({title: 'Empleado registrado exitosamente', icon: 'success'});
    } catch (e: any) {
      Swal.fire({title: e.error.message, icon: 'error'});
    }
  }

  async updateEmployee() {
    try {
      await this.employeeService.updateEmployee(this.model).toPromise();
        this.getEmployees();
        this.close();
        Swal.fire({title: 'Información del empleado actualizado', icon: 'success'});
    } catch (e: any) {
      console.log(e);
      Swal.fire({title: e.error.message, icon: 'error'});
    }
  }

  public deleteEmployee(item: EmployeeResponse) {
    Swal.fire({
      title: '¿Desea eliminar al empleado?',
      icon: 'question',
      showCancelButton: true,
      confirmButtonText: 'Aceptar',
      cancelButtonText: 'Cancelar'
    }).then( async res => {
      if (res.value) {
        await this.employeeService.deleteEmployee(item);
        this.getEmployees();
        Swal.fire({title: 'Empleado eliminado exitosamente', icon: 'success'});
      }
    })
  }

  //Controller Modal
  public open(content: any) {
    this.model = new EmployeeResponse();
    this.dialog = this.modalService.open(content);
  }

  public edit(item: EmployeeResponse) {
    this.open(this.content);
    this.model = item;
  }

  public close() {
    if ( this.dialog ) {
      this.dialog.dismiss();
      this.dialog = null;
      }
  }

  public removeItems() {
    Swal.fire({
      title: '¿Seguro desea eliminar los elementos?',
      icon: 'question',
      showCancelButton: true,
      confirmButtonText: 'Aceptar',
      cancelButtonText: 'Cancelar'
    }).then(async res => {
      if (res.value) {
        const employesToDelete = this.employeesList.filter(e => e.checked);
        
        for ( let element of employesToDelete) {
          await this.employeeService.deleteEmployee(element);          
        }

        Swal.fire({title: 'Elementos eliminados con exitosamente', icon: 'success'});
        this.getEmployees();
      }
    })
  }

}
