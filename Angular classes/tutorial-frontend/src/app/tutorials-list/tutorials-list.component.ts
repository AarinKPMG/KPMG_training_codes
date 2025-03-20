import { Component, Input, OnInit } from '@angular/core';
import { Tutorial } from '../model/tutorial.model';
import { TutorialService } from '../service/tutorial.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { TutorialsDetailsComponent } from '../tutorials-details/tutorials-details.component';


@Component({
  selector: 'app-tutorials-list',
  imports: [FormsModule , CommonModule , TutorialsDetailsComponent],
  templateUrl: './tutorials-list.component.html',
  styleUrl: './tutorials-list.component.css'
})
export class TutorialsListComponent implements OnInit{

  tutorials: Tutorial[];
  @Input() currentTutorial: Tutorial={};
  currentIndex = -1;
  title='';

  constructor(private tutorialService: TutorialService){}

  ngOnInit(): void {
    this.retrieveTutorials();
  }

  retrieveTutorials(): void {
    
    this.tutorialService.getAll().subscribe({
      next : (data) => {
        this.tutorials = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  refreshList(): void {
    this.retrieveTutorials();
    this.currentTutorial = {};
    this.currentIndex = -1;
  }

  setActiveTutorial(tutorial : Tutorial , index : number): void {
    this.currentTutorial = tutorial ;
    this.currentIndex = index ;
  }

  removeAllTutorials() : void {
    this.tutorialService.deleteAll().subscribe({
      next : (res) => {
        console.log(res);
        this.refreshList();
      },
      error:(e)=>console.error(e)
    });
  }

  searchByTitle(): void {
    this.currentTutorial = {};
    this.currentIndex = -1 ;

    this.tutorialService.findByTitle(this.title).subscribe({
      next : (data) => {
        this.tutorials = data;
        console.log(data);
      },
      error : (e) => console.error(e)
    })
  }

}
