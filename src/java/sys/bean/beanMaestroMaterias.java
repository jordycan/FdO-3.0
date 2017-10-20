/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import clases.Clave;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
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
@Named(value = "beanMaestroMaterias")
@ViewScoped
public class beanMaestroMaterias implements Serializable {

    /**
     * Creates a new instance of beanMaestroMaterias
     */
    private MaestroMaterias maestroMaterias;

    private List<MaestroMaterias> maestroM;
    private Maestro maestro;
    private Materias materias;
    

    public beanMaestroMaterias() {
        maestroMaterias = new MaestroMaterias();
        maestro = new Maestro();
        materias = new Materias();
    }

    public MaestroMaterias getMaestroMaterias() {
        return maestroMaterias;
    }

    public void prepararNuevoMaestroM(ActionEvent actionEvent) {
        maestroMaterias = new MaestroMaterias();
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

 
    

    public void setMaestroMaterias(MaestroMaterias maestroMaterias) {
        this.maestroMaterias = maestroMaterias;
    }

    public List<MaestroMaterias> getMaestroM() {
        daoMaestroMaterias mdao = new MaestroMateriasImp();
        maestroM = mdao.mostrarMaestroMaterias();
        return maestroM;
    }
}
