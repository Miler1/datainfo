import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { BasicDataTableComponent } from './basic-datatable.component';

@NgModule({
  declarations: [
    BasicDataTableComponent
  ],
  imports: [
    BrowserModule,
    NgxDatatableModule,
  ],
  providers: [],
  bootstrap: [BasicDataTableComponent],
  exports: [BasicDataTableComponent]
})
export class BasicDataTableModule { }