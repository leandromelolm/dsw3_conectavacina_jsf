/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.classes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author melo
 */
@Entity
public class Aplicacoes {
    
    @Id
    @Column(name="id_aplicacao")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="data_aplicacao")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column    
    private int hora;
    @Column (length = 70)  
    private String descricao;
    @JoinColumn 
    @ManyToOne
    private ProfissionalEnfermagem profissional;
    @JoinColumn
    @ManyToOne
    private Vacina vacina;    
    @ManyToOne
    private Paciente paciente;
    
    public Aplicacoes(){    
        this.data = new Date();        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ProfissionalEnfermagem getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalEnfermagem profissional) {
        this.profissional = profissional;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
            
}
