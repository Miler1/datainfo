import { Component } from '@angular/core';
import { BasicDataTableComponentConfig } from '../components/basic-datatable/basic-datatable.component';

@Component({
  selector: 'bolsistas',
  templateUrl: './bolsistas.component.html',
  styleUrl: './bolsistas.component.scss'
})
export class BolsistasComponent {
	
  /** aqui seria feito uma chamada ao bk através do observable não deu tempo de finalizar! */
  public dados = [
    {
      nome:"mercy"
    },
    {
      nome:"Vincent"
    },
    {
      nome:"Wesley"
    }
  ]

  //criando as colunas da tabela dinamicamente
  datatableConfig: BasicDataTableComponentConfig = {
    datatableConfig: BasicDataTableComponentConfig = {
    columns: [
      {
        name: "ID",
        prop: "id",
        width: 20
      },
      {
        name: "Nome Completo",
        prop: "nome",
        width: 100
      },
      {
        name: "Identificador",
        prop: "tipoIdentificador",
        width: 100
      },
      {
        name: "Numero Ident.",
        prop: "numeroIdentificador",
        width: 100
      },
      {
        name: "email",
        prop: "email",
        width: 100
      },
      {
        name: "Data Inclusão",
        prop: "dataInclusao",
        width: 100
      },
      {
        name: "Codigo Banco",
        prop: "codigoBanco",
        width: 100
      },
      {
        name: "Numero Agencia",
        prop: "numeroAgencia",
        width: 100
      },
      {
        name: "Numero Conta",
        prop: "numeroConta",
        width: 100
      },
    ]
  }

  }

}
