package sys.model.pacientes;
// Generated 11/04/2018 12:39:53 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * PlanTratamiento generated by hbm2java
 */

@Entity
@Table(name = "plan_tratamiento")
public class PlanTratamiento  implements java.io.Serializable {


     private int id;
     private int idPaciente,idTratamiento;
     private String folio;
     private Date fecha;

    public PlanTratamiento() {
    }

    public PlanTratamiento(int idPaciente, int idTratamiento, String folio, Date fecha) {
        this.idPaciente = idPaciente;
        this.idTratamiento = idTratamiento;
        this.folio = folio;
        this.fecha = fecha;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "id_paciente")
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Column(name = "id_tratamiento")
    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    @Column(name = "folio")
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }
    
    @Column(name = "fecha")
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}


