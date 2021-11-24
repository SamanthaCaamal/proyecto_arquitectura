import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EmployeeResponse } from 'src/app/model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  url_base: string = "http://localhost:8081/api/employee";
  params = { };
  headers = { 
    'Access-Control-Allow-Origin': '*',
    'Content-Type' : 'application/json'
  };

  constructor(
    private httpClient: HttpClient
  ) { }

  getEmployees(): Observable<any> {
    const options = {params: this.params, headers: this.headers};
    return this.httpClient.get(this.url_base + "/", options);
  }

  getEmployeeById(id: number): Observable<any> {
    const options = {params: this.params, headers: this.headers};
    return this.httpClient.get(this.url_base + "/" + id, options);
  }

  createEmployee(id: number, model: EmployeeResponse): Observable<any> {
    return this.httpClient.post(this.url_base + "/" + id, model, {headers: this.headers});
  }

  updateEmployee(model: EmployeeResponse): Observable<any> {
    return this.httpClient.put(this.url_base + "/" + model.id, model, {headers: this.headers});
  }

  deleteEmployee(model: EmployeeResponse) {
    return this.httpClient.delete(this.url_base + "/" + model.id, {headers: this.headers}).toPromise();
  }
}
