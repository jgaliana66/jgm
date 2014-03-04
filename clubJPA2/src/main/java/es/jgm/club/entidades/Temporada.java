package es.jgm.club.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.jgm.club.entidades.core.EntidadAbstracta;

@Entity
@Table(name = "TEMPORADAS", indexes={@Index(name="IdxUuid", unique=true, columnList = "uuid")})
public class Temporada extends EntidadAbstracta
{
    private static final long serialVersionUID = -255517766685581426L;
    
    @Column(nullable = true)
    public String nombre = null;
    
    @Column(nullable = true)
    public Date fechaInicio = null;
    
    @Column(nullable = true)
    public Date fechaFin = null;
   
    // ****************** Relaciones con otras entidades ******************** //
    
    @OneToOne(mappedBy="temporada", optional=false)
    @JoinColumn(name="idEquipo")
    private Equipo equipo = null;
    
    
    public Temporada()
    {
        super();
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Temporada [nombre=").append(nombre).append(
                ", fechaInicio=").append(fechaInicio).append(", fechaFin=").append(
                fechaFin).append(", equipo=").append(equipo).append(
                ", toString()=").append(super.toString()).append("]");
        return builder.toString();
    }

    public Date getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin()
    {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin)
    {
        this.fechaFin = fechaFin;
    }

    public Equipo getEquipo()
    {
        return equipo;
    }

    public void setEquipo(Equipo equipo)
    {
        this.equipo = equipo;
    }
    
}
