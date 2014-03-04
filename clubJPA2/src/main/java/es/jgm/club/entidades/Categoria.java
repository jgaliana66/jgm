package es.jgm.club.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.jgm.club.entidades.core.EntidadAbstracta;

@Entity
@Table(name = "CATEGORIAS", indexes={@Index(name="IdxUuid", unique=true, columnList = "uuid")})
public class Categoria extends EntidadAbstracta
{
    private static final long serialVersionUID = 2727837045741589006L;
     
    @Column(nullable = true)
    private String nombre;

    // ****************** Relaciones con otras entidades ******************** //
   
    @OneToOne(mappedBy="categoria", optional=false)
    @JoinColumn(name="idEquipo")
    private Equipo equipo = null;

    
    public Categoria()
    {
        super();
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Categoria [nombre=").append(nombre).append(", equipo=").append(
                equipo).append(", toString()=").append(super.toString()).append(
                "]");
        return builder.toString();
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
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
