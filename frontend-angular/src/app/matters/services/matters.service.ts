import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

import { Matter } from './../model/matter';
import { delay, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MattersService {

  private readonly API = '/assets/matters.json'; //api/v1/matters

  constructor(private httpClient: HttpClient) { }

  findAllMatters() {
    return this.httpClient.get<Matter[]>(this.API)
    .pipe(
      first(),
      delay(5000),
      tap(matters => console.log(matters))
    );
  }
}
