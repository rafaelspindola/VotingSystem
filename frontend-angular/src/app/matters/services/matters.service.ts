import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

import { Matter } from './../model/matter';
import { first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MattersService {

  private readonly API = '/assets/matters.json';

  constructor(private httpClient: HttpClient) { }

  findAllMatters() {
    return this.httpClient.get<Matter[]>(this.API)
    .pipe(
      first(),
      tap(matters => console.log(matters))
    );
  }
}
