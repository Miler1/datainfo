package com.datainfo.desafionv2.model;

import com.datainfo.desafionv2.dto.BolsistaDTO;
import com.datainfo.desafionv2.enums.TipoIdentificador;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_BOLSISTA")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@ToString(of = {"id"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TbBolsista {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="nome", nullable=false)
    private String nome;

    @Column(name="tipo_identificador", nullable=false)
    private TipoIdentificador tipoIdentificador;

    @Column(name="numero_identificador", nullable=false)
    private String numeroIdentificador;

    @Column(name="email", nullable = true)
    private String email;

    @Column(name="data_inclusao", nullable=false)
    private Date dataInclusao;

    @Column(name="codigo_banco", nullable=true)
    private String codigoBanco;

    @Column(name="numero_agencia", nullable=true)
    private int numeroAgencia;

    @Column(name="numero_conta", nullable=true)
    private int numeroConta;

    /*public TbBolsista(TbBolsista builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.tipoIdentificador = builder.tipoIdentificador;
        this.numeroIdentificador = builder.numeroIdentificador;
        this.email = builder.email;
        this.dataInclusao = builder.dataInclusao;
        this.codigoBanco = builder.codigoBanco;
        this.numeroAgencia = builder.numeroAgencia;
        this.numeroConta = builder.numeroConta;
    }

    public static class TbBolsistaBuilder {

        // required parameters
        private int id;
        private String nome;
        private TipoIdentificador tipoIdentificador;
        private String numeroIdentificador;
        private Date dataInclusao;
        private String codigoBanco;
        private int numeroAgencia;
        private int numeroConta;

        public TbBolsistaBuilder(int id, String nome, TipoIdentificador tipoIdentificador, String numeroIdentificador, Date dataInclusao, String codigoBanco, int numeroAgencia, int numeroConta) {
            this.id = id;
            this.nome = nome;
            this.tipoIdentificador = tipoIdentificador;
            this.numeroIdentificador = numeroIdentificador;
            this.dataInclusao = dataInclusao;
            this.codigoBanco = codigoBanco;
            this.numeroAgencia = numeroAgencia;
            this.numeroConta = numeroConta;
        }

        public TbBolsista.TbBolsistaBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public TbBolsista.TbBolsistaBuilder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public TbBolsista.TbBolsistaBuilder setTipoIdentificador(TipoIdentificador tipoIdentificador) {
            this.tipoIdentificador = tipoIdentificador;
            return this;
        }

        public TbBolsista.TbBolsistaBuilder setNumeroIdentificador(String numeroIdentificador) {
            this.numeroIdentificador = numeroIdentificador;
            return this;
        }

        public TbBolsista.TbBolsistaBuilder setDataInclusao(Date dataInclusao) {
            this.dataInclusao = dataInclusao;
            return this;
        }

        public TbBolsista.TbBolsistaBuilder setCodigoBanco(String codigoBanco) {
            this.codigoBanco = codigoBanco;
            return this;
        }

        public TbBolsista.TbBolsistaBuilder setNumeroAgencia(int numeroAgencia) {
            this.numeroAgencia = id;
            return this;
        }

        public TbBolsista.TbBolsistaBuilder setNumeroConta(int numeroConta) {
            this.numeroConta = numeroConta;
            return this;
        }

        public TbBolsista build() {
            return new TbBolsista(this);
        }
    }*/

}
