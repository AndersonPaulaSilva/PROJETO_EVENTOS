package com.anderson.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Created by Anderson on 18/09/2019.
 */

@Entity
public class Evento {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @NotEmpty
    private String nome;
    @NotEmpty
    private String local;
    @NotEmpty
    private String data;
    @NotEmpty
    private String horario;


    @OneToMany
    private List<Convidado> convidados;

    public Evento() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

}
