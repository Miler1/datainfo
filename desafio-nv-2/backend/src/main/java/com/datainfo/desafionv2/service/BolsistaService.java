package com.datainfo.desafionv2.service;

import com.datainfo.desafionv2.dto.BolsistaDTO;
import com.datainfo.desafionv2.enums.TipoIdentificador;
import com.datainfo.desafionv2.exception.RegraDeNegocioException;
import com.datainfo.desafionv2.model.TbBolsista;
import com.datainfo.desafionv2.repository.BolsistaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BolsistaService implements IBolsistaService {

    @Autowired
    BolsistaRepository bolsistaRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<TbBolsista> listar() {

        /*BolsistaDTO bolsistaDTO = new BolsistaDTO.BolsistaDTOBuilder(1, "Miler", TipoIdentificador.CPF, "1", new Date(), "11", 2, 3).build();
        BolsistaDTO bolsistaDTO1 = new BolsistaDTO.BolsistaDTOBuilder(2, "Vitor", TipoIdentificador.CPF, "1", new Date(), "11", 2, 3).build();
        BolsistaDTO bolsistaDTO2 = new BolsistaDTO.BolsistaDTOBuilder(3, "João", TipoIdentificador.CPF, "1", new Date(), "11", 2, 3).build();

        List<BolsistaDTO> bolsistas = new ArrayList<>();

        bolsistas.add(bolsistaDTO);
        bolsistas.add(bolsistaDTO1);
        bolsistas.add(bolsistaDTO2);

        return bolsistas;*/
        return bolsistaRepository.findAll();
    }

    @Override
    public BolsistaDTO adicionar(BolsistaDTO bolsista) throws RegraDeNegocioException {
        /*return bolsista;*/
        try {
            TbBolsista novo = modelMapper.map(bolsista, TbBolsista.class);
            bolsistaRepository.save(novo);

            /*BolsistaDTO retornoBolsista = new BolsistaDTO.BolsistaDTOBuilder(
                    novo.getId(),
                    novo.getNome(),
                    novo.getTipoIdentificador(),
                    novo.getNumeroIdentificador(),
                    novo.getDataInclusao(),
                    novo.getCodigoBanco(),
                    novo.getNumeroAgencia(),
                    novo.getNumeroConta()).build();

            return retornoBolsista;*/
            BolsistaDTO bolsistaDto = new BolsistaDTO();

            //BolsistaDTO.builder().nome(bolsista.getNome()).codigoBanco()

            return BolsistaDTO.builder()
                    .id(bolsista.getId())
                    .nome(bolsista.getNome())
                    .tipoIdentificador(bolsista.getTipoIdentificador())
                    .numeroIdentificador(bolsista.getNumeroIdentificador())
                    .email(bolsista.getEmail())
                    .dataInclusao(bolsista.getDataInclusao())
                    .codigoBanco(bolsista.getCodigoBanco())
                    .numeroAgencia(bolsista.getNumeroAgencia())
                    .numeroConta(bolsista.getNumeroConta()).build();

            //return retornoBolsista;

        } catch (Exception e) {
            throw new RegraDeNegocioException("Não foi possível salvar as informações do bolsista", e);
        }

    }

    @Override
    public void remover(int id) throws RegraDeNegocioException {
        try {
            bolsistaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RegraDeNegocioException("Não foi encontrado nenhum bolsista para a exclusão", e);
        }
    }

    @Override
    public BolsistaDTO alterar(BolsistaDTO bolsistaDto) throws RegraDeNegocioException {

        try {
            Optional<TbBolsista> bolsistaData = bolsistaRepository.findById(bolsistaDto.getId());

            TbBolsista alterado;

            if (bolsistaData.isPresent()) {
                alterado = modelMapper.map(bolsistaDto, TbBolsista.class);
                bolsistaRepository.save(alterado);
                /*return new BolsistaDTO.BolsistaDTOBuilder(
                        bolsistaDto.getId(),
                        alterado.getNome(),
                        alterado.getTipoIdentificador(),
                        alterado.getNumeroIdentificador(),
                        alterado.getDataInclusao(),
                        alterado.getCodigoBanco(),
                        alterado.getNumeroAgencia(),
                        alterado.getNumeroConta()).build();*/
                return BolsistaDTO.builder()
                        .id(alterado.getId())
                        .nome(alterado.getNome())
                        .tipoIdentificador(alterado.getTipoIdentificador())
                        .numeroIdentificador(alterado.getNumeroIdentificador())
                        .email(alterado.getEmail())
                        .dataInclusao(alterado.getDataInclusao())
                        .codigoBanco(alterado.getCodigoBanco())
                        .numeroAgencia(alterado.getNumeroAgencia())
                        .numeroConta(alterado.getNumeroConta()).build();

            } else {
                throw new RegraDeNegocioException("Não foi encontrado nenhum bolsista para a alteração");
            }

        } catch (Exception e) {
            throw new RegraDeNegocioException("Não foi possível alterar as informações do bolsista",e);
        }
    }
}
