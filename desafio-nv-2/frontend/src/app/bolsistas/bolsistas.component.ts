import { Component } from '@angular/core';
import { BasicDataTableComponentConfig } from '../components/basic-datatable/basic-datatable.component';
import { BolsistasService } from '../services/bolsistas.service';

@Component({
  selector: 'bolsistas',
  templateUrl: './bolsistas.component.html',
  styleUrl: './bolsistas.component.scss'
})
export class BolsistasComponent {

  dados: any[] = [];

  constructor(service: BolsistasService) {
    service.listarTodosBolsistas().subscribe(res => {
      console.log('res', res)
      this.dados = res;
    });
  }

  datatableConfig: BasicDataTableComponentConfig = {
    columns: [
      {
        name: "Nome",
        prop: "nome",
        width: 100
      },
      {
        name: "Tipo de identificador",
        prop: "tipoIdentificador",
        width: 100
      },
      {
        name: "Número do indentificador",
        prop: "numeroIdentificador",
        width: 100
      },
      {
        name: "Dados bancários",
        prop: "email",
        width: 100
      },
      {
        name: "Data do cadastro",
        prop: "dataInclusao",
        width: 100
      }
    ]
  }

}
