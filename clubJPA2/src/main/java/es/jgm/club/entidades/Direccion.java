package es.jgm.club.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.jgm.club.entidades.core.EntidadAbstracta;

@Entity
@Table(name = "DIRECCIONES")
public class Direccion extends EntidadAbstracta
{
    private static final long serialVersionUID = -9072290639177869624L;

    @Column(nullable = false)
    private Integer tipo = null;

    @Column(nullable = false)
    private String tipoCalle = null;

    @Column(nullable = false)
    private String nombreCalle = null;

    @Column(nullable = false)
    private String numeroCalle = null;

    @Column(nullable = false)
    private String codigoPostal = null;

    @Column(nullable = false)
    private String poblacion = null;

    @Column(nullable = false)
    private String provincia = null;

    @Column(nullable = false)
    private String pais = null;

    @ManyToOne
    @JoinColumn(name = "idPersona", foreignKey=@ForeignKey(name="FKDireccionPersona"))
    private Persona persona;

    public Direccion()
    {
        super();
    }

    public Integer getTipo()
    {
        return tipo;
    }

    public void setTipo(Integer tipo)
    {
        this.tipo = tipo;
    }

    public String getTipoCalle()
    {
        return tipoCalle;
    }

    public void setTipoCalle(String tipoCalle)
    {
        this.tipoCalle = tipoCalle;
    }

    public String getNombreCalle()
    {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle)
    {
        this.nombreCalle = nombreCalle;
    }

    public String getNumeroCalle()
    {
        return numeroCalle;
    }

    public void setNumeroCalle(String numeroCalle)
    {
        this.numeroCalle = numeroCalle;
    }

    public String getCodigoPostal()
    {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal)
    {
        this.codigoPostal = codigoPostal;
    }

    public String getPoblacion()
    {
        return poblacion;
    }

    public void setPoblacion(String poblacion)
    {
        this.poblacion = poblacion;
    }

    public String getProvincia()
    {
        return provincia;
    }

    public void setProvincia(String provincia)
    {
        this.provincia = provincia;
    }

    public String getPais()
    {
        return pais;
    }

    public void setPais(String pais)
    {
        this.pais = pais;
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
        builder.append("Direccion [tipo=").append(tipo).append(", tipoCalle=").append(
                tipoCalle).append(", nombreCalle=").append(nombreCalle).append(
                ", numeroCalle=").append(numeroCalle).append(", codigoPostal=").append(
                codigoPostal).append(", poblacion=").append(poblacion).append(
                ", provincia=").append(provincia).append(", pais=").append(pais).append(
                ", persona=").append(persona).append(", toString()=").append(
                super.toString()).append("]");
        return builder.toString();
    }

}
