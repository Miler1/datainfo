package com.datainfo.desafionv2.enums;

import lombok.Getter;

@Getter
public enum TipoIdentificador {

    CPF("CPF","Certificado de Pessoa Física"), CNH("CNH", "Carteira Nacional de Habilitação"), PASSAPORTE("PASSAPORTE", "passaporte"), RG("RG", "Registro Geral");

    private String sigla;
    private String valor;

    TipoIdentificador(String sigla, String valor) {
        this.sigla = sigla;
        this.valor = valor;
    }
}
