import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

import { Matter } from './../model/matter';

@Injectable({
  providedIn: 'root'
})
export class MattersService {

  constructor(private httpClient: HttpClient) { }

  findAllMatters(): Matter[] {
    return [
      { _id: "1", matter: 'Raise', author: 'Rafael'}
    ];
  }
}
