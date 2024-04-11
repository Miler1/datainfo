package com.datainfo.desafionv2.repository;

import com.datainfo.desafionv2.dto.BolsistaDTO;
import com.datainfo.desafionv2.enums.TipoIdentificador;
import com.datainfo.desafionv2.model.TbBolsista;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BolsistaRepositoryTest {

    @Autowired
    private BolsistaRepository bolsistaRepository;

    private TbBolsista bolsista;

    @AfterEach
    void tearDown() {
        bolsistaRepository.deleteAll();
    }

    @BeforeEach
    public void setupTestData() {
        // Given : Setup object or precondition

        bolsista = TbBolsista.builder()
                .nome("Miler")
                .tipoIdentificador(TipoIdentificador.CPF)
                .numeroIdentificador("111.222.333.444-45")
                .dataInclusao(new Date())
                .codigoBanco("341")
                .numeroAgencia(3320)
                .numeroConta(111122).build();
    }

    // Teste JUnit para operação de salvamento de bolsistas
    @Test
    @DisplayName("Teste JUnit para operação de salvamento de bolsista")
    public void givenEmployeeObject_whenSave_thenReturnSaveEmployee(){


        // When : Action of behavious that we are going to test
        TbBolsista saveEmployee = bolsistaRepository.save(bolsista);

        // Then : Verify the output

        assertThat(saveEmployee).isNotNull();
        assertThat(saveEmployee.getId()).isGreaterThan(0);

    }

    // JUnit test for get Employee List operation
    @Test
    @DisplayName("Teste JUnit para obter lista de bolsistas")
    public void givenEmployeeList_whenFindAll_thenEmployeeList(){

        // Given : Setup object or precondition
        TbBolsista bolsistaOne = TbBolsista.builder()
                .nome("Miler")
                .tipoIdentificador(TipoIdentificador.CPF)
                .numeroIdentificador("111.222.333.444-45")
                .dataInclusao(new Date())
                .codigoBanco("341")
                .numeroAgencia(3320)
                .numeroConta(111122).build();

        TbBolsista bolsistaTwo = TbBolsista.builder()
                .nome("Vitor")
                .tipoIdentificador(TipoIdentificador.CPF)
                .numeroIdentificador("432.768.211.555-54")
                .dataInclusao(new Date())
                .codigoBanco("341")
                .numeroAgencia(3333)
                .numeroConta(222211).build();

        bolsistaRepository.save(bolsistaOne);
        bolsistaRepository.save(bolsistaTwo);

        // When : Action of behavious that we are going to test
        List<TbBolsista> bolsistas = bolsistaRepository.findAll();

        // Then : Verify the output
        assertThat(bolsistas).isNotEmpty();
        assertThat(bolsistas.size()).isEqualTo(5);
    }

    // JUnit test for get Employee By Id operation

    @Test
    @DisplayName("Teste JUnit para obter bolsista por ID")
    public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject()
    {
        // Given : Setup object or precondition
        bolsistaRepository.save(bolsista);

        // When : Action of behavious that we are going to test
        TbBolsista getBolsista = bolsistaRepository.findById(bolsista.getId()).get();

        // Then : Verify the output
        assertThat(getBolsista).isNotNull();
    }


    // JUnit test for get employee by email operation
    @Test
    @DisplayName("Teste JUnit para obter e-mail de bolsista")
    public void givenEmployeeEmail_whenFindByEmail_thenEmployeeObject() {

        // Given: Setup object or precondition

        bolsistaRepository.save(bolsista);
        //incluir atributo email
        // When: Action or behavior that we are going to test
        TbBolsista getBolsista = bolsistaRepository.findByEmail("milergrudtner@gmail.com").get();

        // Then: Verify the output or expected result
        assertThat(getBolsista).isNotNull();
        assertThat(getBolsista.getEmail()).isEqualTo("milergrudtner@gmail.com");
    }


    // JUnit test for get employee update operation
    @Test
    @DisplayName("Teste JUnit para obter operação de atualização de bolsista")
    public void givenEmployeeObject_whenUpdate_thenEmployeeObject() {

        // Given: Setup object or precondition

        bolsistaRepository.save(bolsista);

        // When: Action or behavior that we are going to test
        TbBolsista getBolsista = bolsistaRepository.findById(bolsista.getId()).get();

        getBolsista.setNome("João");
        //getEmployee.setLastName("Last Name");
        getBolsista.setEmail("update@gmail.com");
        getBolsista.setTipoIdentificador(TipoIdentificador.CNH);

        TbBolsista updatedBolsista = bolsistaRepository.save(getBolsista);

        // Then: Verify the output or expected result
        assertThat(updatedBolsista).isNotNull();
        assertThat(updatedBolsista.getEmail()).isEqualTo("update@gmail.com");
    }


    // JUnit test for delete employee operation
    @Test
    @DisplayName("Teste JUnit para operação de exclusão de bolsista")
    public void givenEmployeeObject_whenDelete_thenRemoveEmployee() {

        // Given: Setup object or precondition

        bolsistaRepository.save(bolsista);

        // When: Action or behavior that we are going to test
        bolsistaRepository.deleteById(bolsista.getId());
        Optional<TbBolsista> deleteBolsista = bolsistaRepository.findById(bolsista.getId());

        // Then: Verify the output or expected result
        assertThat(deleteBolsista).isEmpty();
    }


    // JUnit test for custom query using JPQL with index param
    /*@Test
    @DisplayName("JUnit test for custom query using JPQL with index")
    public void givenFirstNameAndLastName_whenFindByJPQL_thenReturnEmployeeObject() {

        // Given: Setup object or precondition

        bolsistaRepository.save(bolsista);

        // When: Action or behavior that we are going to test
        TbBolsista getEmployee =   bolsistaRepository.findByJPQL(bolsista.getFirstName(), bolsista.getLastName());

        // Then: Verify the output or expected result
        assertThat(getEmployee).isNotNull();
    }*/

    // JUnit test for custom query using JPQL with name param
    /*@Test
    @DisplayName("JUnit test for custom query using JPQL with name param ")
    public void givenFirstNameAndLastName_whenFindByJPQLNameParams_thenReturnEmployeeObject() {

        // Given: Setup object or precondition

        bolsistaRepository.save(bolsista);

        // When: Action or behavior that we are going to test
        TbBolsista getEmployee =   bolsistaRepository.findByJPQLNameParams(bolsista.getFirstName(), bolsista.getLastName());

        // Then: Verify the output or expected result
        assertThat(getEmployee).isNotNull();
    }*/


    // JUnit test for custom query using findByNativeSQL with name index
    /*@Test
    @DisplayName("JUnit test for custom query using findByNativeSQL with name param  ")
    public void givenFirstNameAndLastName_whenFindByfindByNativeSQL_thenReturnEmployeeObject() {

        // Given: Setup object or precondition

        bolsistaRepository.save(bolsista);

        // When: Action or behavior that we are going to test
        /*TbBolsista getEmployee =   bolsistaRepository.findByJPQLNameParams(bolsista.getFirstName(), bolsista.getLastName());

        // Then: Verify the output or expected result
        assertThat(getEmployee).isNotNull();
    }*/


    // JUnit test for custom query using findByNativeSQLNameParam with name param
    /*@Test
    @DisplayName("JUnit test for custom query using findByNativeSQLNameParam with name param  ")
    public void givenFirstNameAndLastName_whenfindByNativeSQLNameParam_thenReturnEmployeeObject() {

        // Given: Setup object or precondition

        bolsistaRepository.save(bolsista);

        // When: Action or behavior that we are going to test
        TbBolsista getEmployee =   bolsistaRepository.findByJPQLNameParams(bolsista.getFirstName(), bolsista.getLastName());

        // Then: Verify the output or expected result
        assertThat(getEmployee).isNotNull();
    }*/


}