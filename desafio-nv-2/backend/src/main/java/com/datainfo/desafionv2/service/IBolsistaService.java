package com.datainfo.desafionv2.service;

import com.datainfo.desafionv2.dto.BolsistaDTO;
import com.datainfo.desafionv2.exception.RegraDeNegocioException;
import com.datainfo.desafionv2.model.TbBolsista;

import java.io.Serializable;
import java.util.List;

public interface IBolsistaService extends Serializable {

    List<TbBolsista> listar();

    BolsistaDTO adicionar(BolsistaDTO bolsista) throws RegraDeNegocioException;

    void remover(int id) throws RegraDeNegocioException;

    BolsistaDTO alterar(BolsistaDTO bolsista) throws RegraDeNegocioException;

}
