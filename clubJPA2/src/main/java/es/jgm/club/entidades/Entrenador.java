package es.jgm.club.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

/**
 * Implementación de la clase para la entidad: Jugador
 * 
 */
@Entity
@Table(name="ENTRENADORES")
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id", foreignKey=@ForeignKey(name="FKEntrenadorPersona"))
@DiscriminatorValue("4") // Entidad tipo Entrenador
public class Entrenador extends Persona 
{
    private static final long serialVersionUID = 4145689406230521224L;

    // ****************** Relaciones con otras entidades ******************** //

    @OneToOne(optional=true)
    @JoinColumn(name="idSocio", foreignKey=@ForeignKey(name="FKEntrenadorSocio"))
    private Socio socio = null;

    @ManyToOne
    @JoinColumn(name = "idEquipo", foreignKey=@ForeignKey(name="FKEntrenadorEquipo"))
    private Equipo equipo;

    public Entrenador()
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
        builder.append("Entrenador [socio=").append(socio).append(", equipo=").append(
                equipo).append(", toString()=").append(super.toString()).append(
                "]");
        return builder.toString();
    }

    
}
