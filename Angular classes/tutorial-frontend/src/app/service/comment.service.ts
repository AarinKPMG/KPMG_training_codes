import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const baseURL = "http://localhost:8084/api/tutorials";

@Injectable({
  providedIn: 'root'
})

export class CommentService {

  constructor( private httpClient : HttpClient) { }

  getAllCommentsForTutorial(tutorialId : any ) : Observable< Comment[] >{
    return this.httpClient.get<Comment[]>( `${baseURL}/${tutorialId}/comments`);
  }

  getComment(id : any) : Observable<Comment> {
    return this.httpClient.get<Comment>(`${baseURL}/comments/${id}`);
  }

  deleteComment(id : any) : Observable<Comment> {
    return this.httpClient.delete<Comment>(`${baseURL}/comments/${id}`);
  }

  createComment(tutorialId : any , data : any ) : Observable<any> {
    return this.httpClient.post(`${baseURL}/tutorials/${tutorialId}/comments` , data );
  }

  deleteCommentOfTutorial(tutorialId : any ) : Observable<any> {
    return this.httpClient.delete(`${baseURL}/tutorials/${tutorialId}/comments`)
  }

}
