/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.classes.ProfissionalEnfermagem;
import br.edu.ifpe.recife.model.dao.ManagerDao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author melo
 */

@ManagedBean(name="pController")
@SessionScoped
//@ViewScoped
public class ProfissionalEnfController {
    
    private ProfissionalEnfermagem cadastro;
    private ProfissionalEnfermagem selecao;   
    
    @PostConstruct
    public void init(){
        this.cadastro = new ProfissionalEnfermagem();
        
    }
    
    public String insert(){
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro salvo!",
                        "Profissional de saúde "+this.cadastro.getNome()+
                                " cadastrado com sucesso!"));         
        
        this.cadastro = new ProfissionalEnfermagem();
        
//        return "apresentaprofissionaissaude.xhtml";
        return "profissionaissaude.xhtml";
    }
    
    public List<ProfissionalEnfermagem> readAll(){
        
        String query = "select p from ProfissionalEnfermagem p";
        
        return ManagerDao.getCurrentInstance().read(query, ProfissionalEnfermagem.class);    
    }
    
    public String update(){
    
        ManagerDao.getCurrentInstance().update(this.selecao);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("alteração salva! ",
                        "Registro de Id número "+this.selecao.getId() + " alterado com sucesso."));
        
        return "apresentaprofissionaissaude.xhtml";        
    }
    
    public void delete(){
    
        ManagerDao.getCurrentInstance().delete(this.selecao);
      
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("registro excluido! ",
                        "Registro de Id número " +this.getSelecao().getId() + " deletado com sucesso!"));        
    }

    public ProfissionalEnfermagem getCadastro() {
        return cadastro;
    }

    public void setCadastro(ProfissionalEnfermagem cadastro) {
        this.cadastro = cadastro;
    }

    public ProfissionalEnfermagem getSelecao() {
        return selecao;
    }

    public void setSelecao(ProfissionalEnfermagem selecao) {
        this.selecao = selecao;
    }
 
}
