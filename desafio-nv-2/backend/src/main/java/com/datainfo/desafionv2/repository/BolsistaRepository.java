package com.datainfo.desafionv2.repository;

import com.datainfo.desafionv2.model.TbBolsista;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BolsistaRepository extends JpaRepository<TbBolsista, Integer> {

    Optional<TbBolsista> findByEmail(String email);

}
