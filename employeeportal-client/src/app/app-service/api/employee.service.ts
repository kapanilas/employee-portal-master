/**
 * Employee Protal API
 * Manage the Employees of The Company
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
/* tslint:disable:no-unused-variable member-ordering */

import { Inject, Injectable, Optional }                      from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,
         HttpResponse, HttpEvent }                           from '@angular/common/http';
import { CustomHttpUrlEncodingCodec }                        from '../encoder';


import { Employee } from '../model/employee';

import { BASE_PATH, COLLECTION_FORMATS }                     from '../variables';
import { Configuration }                                     from '../configuration';
import { Observable }                                        from 'rxjs/internal/Observable';


@Injectable()
export class EmployeeService {

    protected basePath = 'http://127.0.0.1:8080/employeeportal';
    public defaultHeaders = new HttpHeaders();
    public configuration = new Configuration();

    constructor(protected httpClient: HttpClient, @Optional()@Inject(BASE_PATH) basePath: string, @Optional() configuration: Configuration) {
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
            this.basePath = basePath || configuration.basePath || this.basePath;
        }
    }

    /**
     * @param consumes string[] mime-types
     * @return true: consumes contains 'multipart/form-data', false: otherwise
     */
    private canConsumeForm(consumes: string[]): boolean {
        const form = 'multipart/form-data';
        for (const consume of consumes) {
            if (form === consume) {
                return true;
            }
        }
        return false;
    }


    /**
     * Gets all Employees
     * Fetch all employees
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public getAllEmployees(observe?: 'body', reportProgress?: boolean): Observable<Array<Employee>>;
    public getAllEmployees(observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<Array<Employee>>>;
    public getAllEmployees(observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<Array<Employee>>>;
    public getAllEmployees(observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            'application/json'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
        ];

        return this.httpClient.get<Array<Employee>>(`${this.basePath}/employees`,
            {
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * Registration of the Employee
     * Register an employee in the Employee Portal
     * @param employee Employee Details
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public registerEmployee(employee: Employee, observe?: 'body', reportProgress?: boolean): Observable<string>;
    public registerEmployee(employee: Employee, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<string>>;
    public registerEmployee(employee: Employee, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<string>>;
    public registerEmployee(employee: Employee, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (employee === null || employee === undefined) {
            throw new Error('Required parameter employee was null or undefined when calling registerEmployee.');
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            'application/json'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
        ];
        const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
        if (httpContentTypeSelected != undefined) {
            headers = headers.set('Content-Type', httpContentTypeSelected);
        }

        return this.httpClient.post<string>(`${this.basePath}/employee`,
            employee,
            {
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

}
