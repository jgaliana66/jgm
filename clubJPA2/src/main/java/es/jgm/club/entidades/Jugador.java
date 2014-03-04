package es.jgm.club.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Implementación de la clase para la entidad: Jugador
 * 
 */
@Entity
@Table(name = "JUGADORES")
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id", foreignKey=@ForeignKey(name="FKJugadorPersona"))
@DiscriminatorValue("2") // Entidad tipo Jugador
public class Jugador extends Persona
{
    private static final long serialVersionUID = 4145689406230521224L;

    // ****************** Relaciones con otras entidades ******************** //

    @ManyToOne
    @JoinColumn(name = "idSocio", foreignKey=@ForeignKey(name="FKJugadorSocio"))
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "idEquipo", foreignKey=@ForeignKey(name="FKJugadorEquipo"))
    private Equipo equipo;
   
    
    public Jugador()
    {
        super();
    }

    public Socio getSocio()
    {
        return socio;
    }


    public void setSocio(Socio socio)
    {
        this.socio = socio;
    }


    public Equipo getEquipo()
    {
        return equipo;
    }


    public void setEquipo(Equipo equipo)
    {
        this.equipo = equipo;
    }


    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Jugador [socio=").append(socio).append(", equipo=").append(
                equipo).append("]");
        return builder.toString();
    }

}
