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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author melo
 */

@ManagedBean(name="pController")
//@SessionScoped
@ViewScoped
public class ProfissionalEnfController {
    
    private ProfissionalEnfermagem cadastro;
    private ProfissionalEnfermagem selecao;   
    
    @PostConstruct
    public void init(){
        this.cadastro = new ProfissionalEnfermagem();
        this.selecao = new ProfissionalEnfermagem(); //necessário para funcionar corretamente com o bootfaces. contudo não permiti atualização no primefaces
    }
    
    public void insert(String confirma){
        
        if(!confirma.equals(this.cadastro.getSenha())){
        FacesContext.getCurrentInstance().addMessage("formModal:txtPassword", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de validação", "A senha não confere"));
        return;
        }
        
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        
        this.cadastro = new ProfissionalEnfermagem();
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro salvo!",
                        "Profissional de saúde cadastrado com sucesso!"));         
    }
    
    public List<ProfissionalEnfermagem> readAll(){
        
        String query = "select p from ProfissionalEnfermagem p";
        
        return ManagerDao.getCurrentInstance().read(query, ProfissionalEnfermagem.class);    
    }
    
    public void update(){
    
        ManagerDao.getCurrentInstance().update(this.selecao);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("alteração salva! ",
                        "Registro "+this.selecao.getId() + " alterado com sucesso."));    
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
    
    
    
    public String insertPrimeface(){
        
     
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro salvo!",
                        "Profissional de saúde "+this.cadastro.getNome()+
                                " cadastrado com sucesso!"));         
        
        this.cadastro = new ProfissionalEnfermagem();
        
        return "apresentaprofissionaissaude.xhtml";
    }
    
    public String updatePrimeface(){
    
        ManagerDao.getCurrentInstance().update(this.selecao);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("alteração salva! ",
                        "Registro de Id número "+this.selecao.getId() + " alterado com sucesso."));
        
        return "apresentaprofissionaissaude.xhtml";        
    }
    
    public void deletePrimeface(){
    
        ManagerDao.getCurrentInstance().delete(this.selecao);
      
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("registro excluido! ",
                        "Registro de Id número " +this.getSelecao().getId() + " deletado com sucesso!"));        
    }
 
}
