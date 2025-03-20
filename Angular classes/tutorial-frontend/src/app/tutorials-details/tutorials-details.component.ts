import { Component, Input, OnInit } from '@angular/core';
import { TutorialService } from '../service/tutorial.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Tutorial } from '../model/tutorial.model';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-tutorials-details',
  imports: [ CommonModule, RouterLink , ReactiveFormsModule , FormsModule ],
  templateUrl: './tutorials-details.component.html',
  styleUrl: './tutorials-details.component.css'
})
export class TutorialsDetailsComponent implements OnInit {

  @Input() viewMode = false;

  @Input() currentTutorial : Tutorial = {
    title : '',
    description : '',
    published : false 
  };

  message = '';

  constructor(
    private tutorialService: TutorialService ,
    private route : ActivatedRoute ,
    private router : Router 
  ){}

  ngOnInit(){

    if(!this.viewMode){
      this.message='';
      this.getTutorial(this.route.snapshot.params['id']);
      console.log("---------",this.viewMode)
      console.log("---------",this.message)
    }
    
  }

  getTutorial(id : String) : void {
    this.tutorialService.get(id).subscribe({
      next : (data) => {
        this.currentTutorial = data ;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  deleteTutorial(): void {
    this.tutorialService.delete(this.currentTutorial.id).subscribe({
      next: (res) => {
        console.log(res);
      },
      error: (e) => console.error(e)
    });
    setTimeout(()=>{
      this.router.navigate(['/tutorials']);
    } , 500 );
  }

  updateTutorial(): void {
    this.message = '';

    this.tutorialService.update(this.currentTutorial.id , this.currentTutorial )
      .subscribe({
        next: (res)=>{ console.log(res);
        this.message = res.message ? res.message : "This tutorial was update successfully";
        },
        error : (e) => console.error(e)
      });

      setTimeout( ()=>{
        this.router.navigate(['/tutorials']);
      }, 500 );
  }

  updatePublished(status : boolean) : void {
    const data = {
      title:this.currentTutorial.title,
      description : this.currentTutorial.description ,
      published : status 
    };

    this.message = '';

    this.tutorialService.update(this.currentTutorial.id , data).subscribe({
      next : (res) =>{
        console.log(res);
        this.currentTutorial.published = status ;
        this.message = res.message ? res.message : "This status was updated successfully";
      },
      error: (e) => console.error(e)
    });

    setTimeout(()=>{
      this.router.navigate(['/tutorials']);
    }, 500);
  }
  
}
