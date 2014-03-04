package es.jgm.club.entidades;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Index;

import es.jgm.club.entidades.core.EntidadAbstracta;

/**
 * Implementación de la clase para la entidad: Persona
 * 
 */

@Entity
@Table(name = "PERSONAS", indexes={@Index(name="IdxUuid", unique=true, columnList = "uuid")})
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipoPersona", discriminatorType = DiscriminatorType.INTEGER)
public class Persona extends EntidadAbstracta
{
    private static final long serialVersionUID = -2634312083311813211L;

    @Column(nullable = false, length = 45)
    private String nombre = null;

    @Column(nullable = true, length = 255)
    private String primerApellido = null;

    @Column(nullable = true, length = 255)
    private String segundoApellido = null;

    @Column(nullable = true, length = 255)
    private String eMail = null;

    @Temporal(value = TemporalType.DATE)
    @Column(nullable = true)
    private Date fechaAlta = null;

    @Temporal(value = TemporalType.DATE)
    @Column(nullable = true)
    private Date fechaBaja = null;

    @Temporal(value = TemporalType.DATE)
    @Column(nullable = true)
    private Date fechaNacimiento = null;

    @Column(nullable = true)
    private String dni = null;

    // ****************** Relaciones con otras entidades ******************** //

    @OneToMany(mappedBy = "persona")
    private Set<Direccion> direcciones = new TreeSet<Direccion>();

    @OneToMany(mappedBy = "persona")
    private Set<Telefono> telefonos = new TreeSet<Telefono>();

    @OneToOne(mappedBy = "persona", optional = true)
    @JoinColumn(name = "idCuenta")
    private CuentaIBAN cuenta = null;

    public Persona()
    {
        super();
        this.setFechaAlta(new Date(System.currentTimeMillis()));
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Set<Direccion> getDirecciones()
    {
        return direcciones;
    }

    public void setDirecciones(Set<Direccion> direcciones)
    {
        this.direcciones = direcciones;
    }

    public Set<Telefono> getTelefonos()
    {
        return telefonos;
    }

    public void setTelefonos(Set<Telefono> telefonos)
    {
        this.telefonos = telefonos;
    }

    public String geteMail()
    {
        return eMail;
    }

    public void seteMail(String eMail)
    {
        this.eMail = eMail;
    }

    public String getPrimerApellido()
    {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido)
    {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido()
    {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido)
    {
        this.segundoApellido = segundoApellido;
    }

    public String getDni()
    {
        return dni;
    }

    public void setDni(String dni)
    {
        this.dni = dni;
    }

    public void setFechaAlta(Date fechaAlta)
    {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaAlta()
    {
        return fechaAlta;
    }

    public void setFechaAltaClub(Date fechaAlta)
    {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja()
    {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBajaClub)
    {
        this.fechaBaja = fechaBajaClub;
    }

    public Date getFechaNacimiento()
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String getUuid()
    {
        return super.getUuid();
    }

    @Override
    public void setUuid(String uuid)
    {
        super.setUuid(uuid);
    }

    @Override
    public Integer getVersion()
    {
        return super.getVersion();
    }

    @Override
    public void setVersion(Integer version)
    {
        super.setVersion(version);
    }

    public CuentaIBAN getCuenta()
    {
        return cuenta;
    }

    public void setCuenta(CuentaIBAN cuenta)
    {
        this.cuenta = cuenta;
    }

    @Override
    public String toString()
    {
        final int maxLen = 5;
        StringBuilder builder = new StringBuilder();
        builder.append("Persona [nombre=").append(nombre).append(
                ", primerApellido=").append(primerApellido).append(
                ", segundoApellido=").append(segundoApellido).append(", eMail=").append(
                eMail).append(", fechaAlta=").append(fechaAlta).append(
                ", fechaBaja=").append(fechaBaja).append(", fechaNacimiento=").append(
                fechaNacimiento).append(", dni=").append(dni).append(
                ", direcciones=").append(
                direcciones != null ? toString(direcciones, maxLen) : null).append(
                ", telefonos=").append(
                telefonos != null ? toString(telefonos, maxLen) : null).append(
                ", cuenta=").append(cuenta).append("]");
        return builder.toString();
    }

    private String toString(Collection<?> collection, int maxLen)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int i = 0;
        for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++)
        {
            if (i > 0)
                builder.append(", ");
            builder.append(iterator.next());
        }
        builder.append("]");
        return builder.toString();
    }

}
