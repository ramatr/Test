import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private httpclient: HttpClient) { }

  getModifiedPhoneNumbers(phoneNo: string):Observable<any>{
    return <Observable<any>>this.httpclient.get(`${environment.apiEndpoint}/getModifiedPhoneNumbers/${phoneNo}`)
  }
}
