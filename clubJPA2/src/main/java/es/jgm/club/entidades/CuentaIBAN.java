package es.jgm.club.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.jgm.club.entidades.core.EntidadAbstracta;

@Entity
@Table(name="cuentas")
public class CuentaIBAN extends EntidadAbstracta implements Serializable 
{
    private static final long serialVersionUID = 4203872057142572118L;

    @Column(nullable = false, length = 4)
    private String pais;
    @Column(nullable = false, length = 4)
    private String numeroControl;
    @Column(nullable = false, length = 4)
    private String entidad;
    @Column(nullable = false, length = 4)
    private String sucursal;
    @Column(nullable = false, length = 2)
    private String digitoControl;
    @Column(nullable = false, length = 10)
    private String cc;

    @OneToOne(optional=true)
    @JoinColumn(name="idPersona", foreignKey=@ForeignKey(name="FKCuentaPersona"))
    private Persona persona = null;
    
    public CuentaIBAN()
    {

    }

    public String getPais()
    {
        return pais;
    }

    public void setPais(String pais)
    {
        this.pais = pais;
    }

    public String getNumeroControl()
    {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl)
    {
        this.numeroControl = numeroControl;
    }

    public String getEntidad()
    {
        return entidad;
    }

    public void setEntidad(String entidad)
    {
        this.entidad = entidad;
    }

    public String getSucursal()
    {
        return sucursal;
    }

    public void setSucursal(String sucursal)
    {
        this.sucursal = sucursal;
    }

    public String getDigitoControl()
    {
        return digitoControl;
    }

    public void setDigitoControl(String digitoControl)
    {
        this.digitoControl = digitoControl;
    }

    public String getCc()
    {
        return cc;
    }

    public void setCc(String cc)
    {
        this.cc = cc;
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
        builder.append("CuentaIBAN [pais=").append(pais).append(
                ", numeroControl=").append(numeroControl).append(", entidad=").append(
                entidad).append(", sucursal=").append(sucursal).append(
                ", digitoControl=").append(digitoControl).append(", cc=").append(
                cc).append(", persona=").append(persona).append(", toString()=").append(
                super.toString()).append("]");
        return builder.toString();
    }

}
