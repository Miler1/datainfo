import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BasicDataTableModule } from './components/basic-datatable/basic-datatable.component.module';
import { BolsistasModule } from './../app/bolsistas/bolsistas.component.module';
import { BolsistasComponent } from './bolsistas/bolsistas.component';
import { Routes } from '@angular/router';

const appRoute: Routes = [
  // { path: 'about', component: BolsistasComponent },
  // { path: 'service', component: Service },
  // { path: 'dashboard', component: Dashboard, canActivate: [] }
]

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BolsistasModule,
    BasicDataTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
