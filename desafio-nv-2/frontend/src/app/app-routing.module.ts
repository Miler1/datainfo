import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BolsistasComponent } from './bolsistas/bolsistas.component';

const routes: Routes = [
  { path: 'bolsistas', component: BolsistasComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
