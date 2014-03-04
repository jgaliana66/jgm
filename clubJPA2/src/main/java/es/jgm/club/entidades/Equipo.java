package es.jgm.club.entidades;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.jgm.club.entidades.core.EntidadAbstracta;

@Entity
@Table(name = "EQUIPOS", indexes={@Index(name="IdxUuid", unique=true, columnList = "uuid")})
public class Equipo extends EntidadAbstracta
{
    private static final long serialVersionUID = -7168427764379564050L;
    
    @Column(nullable = true)
    public String nombre;
    
    // ****************** Relaciones con otras entidades ******************** //

    @OneToOne
    @JoinColumn(name="idCategoria", foreignKey=@ForeignKey(name="FKEquipoCategoria"))
    private Categoria categoria = null;
    
    @OneToOne
    @JoinColumn(name="idTemporada", foreignKey=@ForeignKey(name="FKEquipoTemporada"))
    private Temporada temporada = null;
    
    @OneToMany(mappedBy = "equipo")
    private Set<Jugador> jugadores = new TreeSet<Jugador>();

    @OneToMany(mappedBy = "equipo")
    private Set<Entrenador> entrenadores = new TreeSet<Entrenador>();
  
    public Equipo()
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

    public Categoria getCategoria()
    {
        return categoria;
    }

    public void setCategoria(Categoria categoria)
    {
        this.categoria = categoria;
    }

    public Temporada getTemporada()
    {
        return temporada;
    }

    public void setTemporada(Temporada temporada)
    {
        this.temporada = temporada;
    }

    public Set<Jugador> getJugadores()
    {
        return jugadores;
    }

    public void setJugadores(Set<Jugador> jugadores)
    {
        this.jugadores = jugadores;
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
    public String toString()
    {
        final int maxLen = 5;
        StringBuilder builder = new StringBuilder();
        builder.append("Equipo [nombre=").append(nombre).append(", categoria=").append(
                categoria).append(", temporada=").append(temporada).append(
                ", jugadores=").append(
                jugadores != null ? toString(jugadores, maxLen) : null).append(
                ", toString()=").append(super.toString()).append("]");
        return builder.toString();
    }
    
    
    
}
