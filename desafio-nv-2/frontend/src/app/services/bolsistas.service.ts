import { HttpClient, HttpParams } from '@angular/common/http';
import { Injector } from '@angular/core';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BolsistasService {

  private url: string = 'http://localhost:8080';
  constructor(private _http: HttpClient) {

  }

  listarTodosBolsistas(): Observable<any[]> {
    return this._http.get<any[]>(`${ this.url }/bolsistas`)
    // .subscribe(res => console.log(res));
  }

  // // GET heroes whose name contains search term
  //   searchHeroes(term: string): observable<Hero[]>{
  //     const params = new HttpParams({fromString: 'name=term'});
  //       return this.http.request('GET', `${ this.apiURL }/bolsistas`, {responseType:'json'});
  //    }

}
