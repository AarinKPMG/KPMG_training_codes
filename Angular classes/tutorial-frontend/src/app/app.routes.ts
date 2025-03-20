import { Routes } from '@angular/router';
import { TutorialsListComponent } from './tutorials-list/tutorials-list.component';
import { TutorialsDetailsComponent } from './tutorials-details/tutorials-details.component';
import { AddTutorialComponent } from './add-tutorial/add-tutorial.component';

export const routes: Routes = [
    {path : '', redirectTo: 'tutorials' , pathMatch: 'full'},
    {path : 'tutorials' , component: TutorialsListComponent },
    {path : 'tutorials/:id' , component: TutorialsDetailsComponent },
    {path : 'add', component : AddTutorialComponent}
];
