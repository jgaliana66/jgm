package es.jgm.club.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import es.jgm.club.entidades.core.EntidadAbstracta;

@Entity
@Table(name = "TIPOCOBRO", indexes =
{ @Index(name = "IdxUuid", unique = true, columnList = "uuid") })
public class TipoCobro extends EntidadAbstracta
{
    private static final long serialVersionUID = 1866677601902499829L;

    @Column(nullable = false)
    private String nombre;

    public TipoCobro()
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

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("TipoCobro [nombre=").append(nombre).append(
                ", toString()=").append(super.toString()).append("]");
        return builder.toString();
    }

}
