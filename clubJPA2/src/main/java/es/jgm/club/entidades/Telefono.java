package es.jgm.club.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.jgm.club.entidades.core.EntidadAbstracta;

@Entity
@Table(name = "TELEFONOS")
public class Telefono extends EntidadAbstracta
{
    private static final long serialVersionUID = -4047339740617641412L;

    @Column(nullable = false)
    private Integer tipo = null;
    
    @Column(nullable = false)
    private String telefono = null;

    @ManyToOne
    @JoinColumn(name = "idPersona", foreignKey=@ForeignKey(name="FKTelefonoPersona"))
    private Persona persona = null;
    
    public Telefono()
    {
    }

    public Integer getTipo()
    {
        return tipo;
    }

    public void setTipo(Integer tipo)
    {
        this.tipo = tipo;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public Persona getPersona()
    {
        return persona;
    }

    public void setPersona(Persona persona)
    {
        this.persona = persona;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Telefono [tipo=").append(tipo).append(", telefono=").append(
                telefono).append(", persona=").append(persona).append(
                ", toString()=").append(super.toString()).append("]");
        return builder.toString();
    }

 
}
