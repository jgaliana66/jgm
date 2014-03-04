package es.jgm.club.entidades.core;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;

/**
 * @author jgaliana
 * 
 *         Clase abstracta base para todas las entidades del dominio Implementa
 *         el interfaz EntidadPersistente
 * 
 *         Para que las entidades puedan ser clases derivadas de una clase
 *         abstracta debe usarse la anotación @Inheritance. La explicación se
 *         puede encontrar en:
 * 
 *         1) http://docs.oracle.com/javaee/6/tutorial/doc/bnbqn.html 
 *         2) http://docs.oracle.com/html/E13981_01/cmp30cfg016.htm
 * 
 */

@MappedSuperclass
public abstract class EntidadAbstracta implements EntidadPersistente, Serializable
{
    private static final long serialVersionUID = -7016198751525965539L;

    @Id
    @GeneratedValue
    private Integer id = null; // Clave primaria

    //@Column(name="uuid", nullable = false, length = 36)
    private String uuid = null; // Identificador único para cada entidad

    @Version
    private Integer version = null; // Control de version de la entidad para usar con el bloqueo optimista

    /*
     * Constructor por defecto y sin parámetros requerido por JPA
     */
    public EntidadAbstracta()
    {
    }

    /*
     * Usando la anotación @PrePersist, nos aseguramos que SÓLO la primera vez
     * que se almacena la entidad en la base de datos se genera el UUID.
     */
    @PrePersist
    public void obtenerUuid()
    {
        if (getUuid() == null)
        {
            setUuid(GeneradorId.createId());
        }
    }

    /*
     * Métodos equals y hash que usan únicamente el atributo uuid que es
     * inmutable y único para cualquier entidad generada, asegurando la unicidad
     * de la misma.
     * 
     * @see es.jgm.club.entidades.core.EntidadPersistente
     */

    public boolean equals(final Object objeto)
    {
        if (this == objeto)
        {
            return true;
        }
        if (objeto == null || !(objeto instanceof EntidadPersistente))
        {
            return false;
        }

        EntidadPersistente otro = (EntidadPersistente) objeto;
        if (uuid == null)
        {
            return false;
        }
        return uuid.equals(otro.getUuid());
    }

    public int hashCode()
    {
        return getUuid().hashCode();
    }

    public String toString()
    {
        return this.getClass().getName() + "[uuid=" + uuid + "]";
    }

    /*
     * Métodos set y get de los atributos necesarios en las entidades
     * 
     * @see es.jgm.club.entidades.core.EntidadPersistente#getId()
     */
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

}
