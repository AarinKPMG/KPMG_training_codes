import { Injectable } from '@angular/core';
import { Tag } from '../model/tag.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

const baseURL = "http://localhost:8084/api/tutorials";

@Injectable({
  providedIn: 'root'
})

export class TagService {

  constructor( private httpClient : HttpClient ) { }

  getAllTags(tutorialId : any ) : Observable<Tag[]> {
    return this.httpClient.get<Tag[]>(`${baseURL}/${tutorialId}/tags`)
  }
}
