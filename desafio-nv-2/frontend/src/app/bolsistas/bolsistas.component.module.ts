import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { BolsistasComponent } from './../bolsistas/bolsistas.component';
import { BasicDataTableModule } from './../components/basic-datatable/basic-datatable.component.module';

@NgModule({
  declarations: [
    BolsistasComponent
  ],
  imports: [
    BrowserModule,
    NgxDatatableModule,
    BasicDataTableModule
  ],
  providers: [],
  bootstrap: [BolsistasComponent],
  exports: [BolsistasComponent]
})
export class BolsistasModule { }