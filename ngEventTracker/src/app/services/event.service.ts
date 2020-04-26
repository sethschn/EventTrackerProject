import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { Tracker } from '../model/tracker';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private baseUrl = environment.baseUrl;
  private url = this.baseUrl + 'api/trackers';

  constructor(private http: HttpClient) { }

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
     // 'Authorization': 'my-auth-token'
    })
  };

  public create(event: Tracker,emotionId: number){
    return this.http.post<Tracker>(`${this.url}/${emotionId}`, event, this.httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('create method in event service failed');
        })
      );
  }

  index() {
    return this.http.get<Tracker[]>(this.url)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('index method in event service failed');
      })
      );
    }


  public show(id: number){
    return this.http.get<Tracker>(`${this.url}/${id}`)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('show single id in event service failed');
      })
    );
  }




  public update(event: Tracker){
    return this.http.put<Tracker>(`${this.url}/${event.id}`, event, this.httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('update method in event service failed');
        })
      );
    }


  public destroy(id: number){
    return this.http.delete<Tracker>(`${this.url}/${id}`)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('delete method in event service failed');
      })
    );
  }


}
