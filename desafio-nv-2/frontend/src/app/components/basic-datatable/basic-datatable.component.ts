import { Component, Input } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'basic-datatable',
  // standalone: false,
  // imports: [RouterOutlet],
  templateUrl: './basic-datatable.component.html',
  styleUrl: './basic-datatable.component.scss'
})
export class BasicDataTableComponent {

  @Input() titulo: string = '';
  @Input()
  public set lista(lista: any[]) {
    this.dados = lista;
  }
  @Input() config: BasicDataTableComponentConfig = new BasicDataTableComponentConfig;
  public dados: any[] = [];

}

export class BasicDataTableComponentConfig {
  columns: BasicDataTableComponentColumnConfig[] = [];
}

export class BasicDataTableComponentColumnConfig {

  public name: string = '';
  public prop: string = '';
  public type?: "string" | "number" | "date";
  public width: number = 100;
  public click?: (cel: any) => void;
  public cellClass?: string;
  public link?: boolean = false;

}
