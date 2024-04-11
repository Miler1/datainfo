package com.datainfo.desafionv2.controller;

import com.datainfo.desafionv2.dto.BolsistaDTO;
import com.datainfo.desafionv2.exception.RegraDeNegocioException;
import com.datainfo.desafionv2.model.TbBolsista;
import com.datainfo.desafionv2.service.IBolsistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/bolsista", produces = MediaType.APPLICATION_JSON_VALUE)
public class BolsistaController {

    @Autowired
    IBolsistaService bolsistaService;

    @GetMapping("/listar")
    public ResponseEntity<List<TbBolsista>> all() {
        List<TbBolsista> bolsistas = new ArrayList<>();
        try {
            //bolsistaService.listar().forEach(bolsistas::add);
            bolsistas = bolsistaService.listar();

            if (bolsistas.isEmpty()) {
                System.out.println("Vazio");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            for (TbBolsista pessoa : bolsistas) {
                System.out.println(pessoa.getNome());
            }
            return new ResponseEntity<>(bolsistas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity<BolsistaDTO> addBolsista(@RequestBody BolsistaDTO bolsista) {
        try {
            BolsistaDTO novoBolsista = bolsistaService.adicionar(bolsista);
            return new ResponseEntity<>(novoBolsista, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<BolsistaDTO> deleteBolsista(@PathVariable int id) {
        try {
            bolsistaService.remover(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/alterar")
    public ResponseEntity<BolsistaDTO> updateBolsista(@RequestBody BolsistaDTO bolsista) {
        try {
            BolsistaDTO alteradoBolsista = bolsistaService.alterar(bolsista);
            return new ResponseEntity<>(alteradoBolsista, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
