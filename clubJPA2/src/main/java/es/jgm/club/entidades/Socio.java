package es.jgm.club.entidades;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Implementación de la clase para la entidad: Socio
 * 
 */
@Entity
@Table (name="SOCIOS")
@DiscriminatorValue("1") // Entidad tipo Socio
@PrimaryKeyJoinColumn(name="id", foreignKey=@ForeignKey(name="FKSocioPersona"))
public class Socio extends Persona
{
    private static final long serialVersionUID = -2634312083311813211L;

    // ****************** Relaciones con otras entidades ******************** //

    @OneToOne(mappedBy="socio", optional=true)
    @JoinColumn(name="idDirectivo")
    private Directivo directivo = null;
    
    @OneToOne(mappedBy="socio", optional=true)
    @JoinColumn(name="idEntrenador")
    private Entrenador entrenador = null;
    
    @OneToMany(mappedBy = "socio")
    private Set<Jugador> jugadores = new TreeSet<Jugador>();

    public Socio()
    {
        super();
    }

 
    public Set<Jugador> getJugadores()
    {
        return jugadores;
    }

    public void setJugadores(Set<Jugador> jugadores)
    {
        this.jugadores = jugadores;
    }



 

    @Override
    public String toString()
    {
        final int maxLen = 5;
        StringBuilder builder = new StringBuilder();
        builder.append("Socio [directivo=").append(directivo).append(
                ", entrenador=").append(entrenador).append(", jugadores=").append(
                jugadores != null ? toString(jugadores, maxLen) : null).append(
                ", toString()=").append(super.toString()).append("]");
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


}
