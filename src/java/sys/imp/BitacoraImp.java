/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.imp;

import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.daoBitacora;
import sys.model.BitacoraRecibos;
import sys.model.MaestroMaterias;
import sys.util.HibernateUtil;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class BitacoraImp implements daoBitacora {
    
     HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession sessionUsuario = request.getSession();
        int user=(int) sessionUsuario.getAttribute("idSesion");
        int empleado=(int) sessionUsuario.getAttribute("idEmpleado");

    @Override
    public void insertarTratamiento(BitacoraRecibos bitacora) {
       
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(bitacora);
            session.getTransaction().commit();
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
     
    }

    @Override
    public List<BitacoraRecibos> mostratTratamientosPorAlumno(MaestroMaterias mmaterias) {
        List<BitacoraRecibos> listBita= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql="from BitacoraRecibos as m inner join fetch m.alumnos left join fetch m.maestroMaterias "
                + "left join fetch m.menuTratamientos where m.maestroMaterias.clave = '"+mmaterias.getClave()+"' and m.alumnos.matricula="+user;
        try{
            listBita = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listBita;
    }

    @Override
    public List<BitacoraRecibos> mostrarTratamientosPorMaestros(MaestroMaterias mmaterias) {
        
        List<BitacoraRecibos> listBita= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql="from BitacoraRecibos as m inner join fetch m.alumnos left join fetch m.maestroMaterias "
                + "left join fetch m.menuTratamientos where m.maestroMaterias.clave = '"+mmaterias.getClave()+"' and m.maestroMaterias.maestro.idEmpleado="+empleado;
        try{
            listBita = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listBita;
        
    }

}