/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import sys.dao.daoMaestro;
import sys.dao.daoMaestroMaterias;
import sys.imp.MaestroImp;
import sys.imp.MaestroMateriasImp;
import sys.model.Maestro;
import sys.model.MaestroMaterias;
import sys.model.Materias;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Named(value = "beanMaestro")
@ViewScoped
public class beanMaestro implements Serializable {

    private Maestro maestro;
    private MaestroMaterias maestroMaterias;
    private Materias materias;
    private List<Maestro> listar;
   
    private List<SelectItem> listarMaterias;
    private List<SelectItem> listarMaestros;
    private String clave;

    public beanMaestro() {
        maestro = new Maestro();
        maestroMaterias = new MaestroMaterias();
        materias = new Materias();
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

  

    public Materias getMaterias() {
        return materias;
    }

    public void setMaterias(Materias materias) {
        this.materias = materias;
    }

    public MaestroMaterias getMaestroMaterias() {
        return maestroMaterias;
    }

    public void setMaestroMaterias(MaestroMaterias maestroMaterias) {
        this.maestroMaterias = maestroMaterias;
    }
    
    
    public void prepararNuevoMaestro(ActionEvent actionEvent) {
        maestro = new Maestro();
    }

    public String getClave() {
        return clave;
    }
    
   
    public void codigo(){
         daoMaestro mdao = new MaestroImp();
         clave = mdao.mostrarCodigo();
         
    }
    
   
    public void insertarMaestro() {
        daoMaestro mdao = new MaestroImp();
        mdao.insertarMaestro(maestro);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se ha ingresado satisfactoriamente"));
    }

    public List<Maestro> getListar() {
        daoMaestro mdao = new MaestroImp();
        listar = mdao.mostrarMaestro();
        return listar;
    }

    public void actualizarMaestro() {
        daoMaestro mdao = new MaestroImp();
        mdao.editarMaestro(maestro);
        maestro = new Maestro();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se ha actualizado satisfactoriamente"));
    }

    public void eliminarMaestro() {
        daoMaestro mdao = new MaestroImp();
        mdao.eliminarMaestro(maestro);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se ha eliminado satisfactoriamente"));
    }

    public List<SelectItem> getListMaestro() {
        this.listarMaestros = new ArrayList<SelectItem>();
        daoMaestro mdao = new MaestroImp();
        List<Maestro> m = mdao.mostrarMaestro();
        listarMaestros.clear();
        for (Maestro g : m) {
            SelectItem gradoItem = new SelectItem(g.getIdEmpleado(), g.getNombre() + " " + g.getApellidoPaterno() + " " + g.getApellidoMaterno());
            this.listarMaestros.add(gradoItem);
        }
        return listarMaestros;
    }

   public List<SelectItem> getListarMaterias() {
        this.listarMaterias = new ArrayList<SelectItem>();
        daoMaestro mdao = new MaestroImp();
        List<Materias> m = mdao.mostrarMaterias(this.maestroMaterias);
        listarMaterias.clear();
        for (Materias materia : m) {
            SelectItem materiaItem = new SelectItem(materia.getIdMateria(), materia.getMateria());
            this.listarMaterias.add(materiaItem);
        }

        return listarMaterias;
    }


    
    public void insertarMaestroMaterias() {
        daoMaestro mdao = new MaestroImp();
        mdao.insertarMaestroMaterias(maestroMaterias);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se ha ingresado satisfactoriamente"));

    }

  
    
    

    public void cancelar() {
        maestro = new Maestro();
      
    }
}
