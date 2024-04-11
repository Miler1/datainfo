package com.datainfo.desafionv2.dto;

import com.datainfo.desafionv2.enums.TipoIdentificador;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BolsistaDTO {

    private int id;
    private String nome;
    private TipoIdentificador tipoIdentificador;
    private String numeroIdentificador;
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private String email;
    private Date dataInclusao;
    private String codigoBanco;
    private int numeroAgencia;
    private int numeroConta;

    /*public BolsistaDTO(BolsistaDTOBuilder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.tipoIdentificador = builder.tipoIdentificador;
        this.numeroIdentificador = builder.numeroIdentificador;
        this.dataInclusao = builder.dataInclusao;
        this.codigoBanco = builder.codigoBanco;
        this.numeroAgencia = builder.numeroAgencia;
        this.numeroConta = builder.numeroConta;
    }*/

    //Builder Class
    /*public static class BolsistaDTOBuilder {

        // required parameters
        private int id;
        private String nome;
        private TipoIdentificador tipoIdentificador;
        private String numeroIdentificador;
        private Date dataInclusao;
        private String codigoBanco;
        private int numeroAgencia;
        private int numeroConta;

        public BolsistaDTOBuilder(int id, String nome, TipoIdentificador tipoIdentificador, String numeroIdentificador, Date dataInclusao, String codigoBanco, int numeroAgencia, int numeroConta){
            this.id = id;
            this.nome = nome;
            this.tipoIdentificador = tipoIdentificador;
            this.numeroIdentificador = numeroIdentificador;
            this.dataInclusao = dataInclusao;
            this.codigoBanco = codigoBanco;
            this.numeroAgencia = numeroAgencia;
            this.numeroConta = numeroConta;
        }

        public BolsistaDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public BolsistaDTOBuilder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public BolsistaDTOBuilder setTipoIdentificador(TipoIdentificador tipoIdentificador) {
            this.tipoIdentificador = tipoIdentificador;
            return this;
        }

        public BolsistaDTOBuilder setNumeroIdentificador(String numeroIdentificador) {
            this.numeroIdentificador = numeroIdentificador;
            return this;
        }

        public BolsistaDTOBuilder setDataInclusao(Date dataInclusao) {
            this.dataInclusao = dataInclusao;
            return this;
        }

        public BolsistaDTOBuilder setCodigoBanco(String codigoBanco) {
            this.codigoBanco = codigoBanco;
            return this;
        }

        public BolsistaDTOBuilder setNumeroAgencia(int numeroAgencia) {
            this.numeroAgencia = id;
            return this;
        }

        public BolsistaDTOBuilder setNumeroConta(int numeroConta) {
            this.numeroConta = numeroConta;
            return this;
        }

        public BolsistaDTO build(){
            return new BolsistaDTO(this);
        }
    }*/

}
