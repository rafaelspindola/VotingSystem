import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

import { Matter } from './../model/matter';
import { delay, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MattersService {

  private readonly API = 'api/v1/matters';

  constructor(private httpClient: HttpClient) { }

  findAllMatters() {
    return this.httpClient.get<Matter[]>(this.API)
    .pipe(
      first(),
      delay(2000),
      tap(matters => console.log(matters))
    );
  }

  createMatter(record: Partial<Matter>) {
    return this.httpClient.post<Matter>(this.API, record).pipe(first());
  }
}
