package es.jgm.club.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Implementación de la clase para la entidad: Jugador
 * 
 */
@Entity
@Table(name="DIRECTIVOS")
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id", foreignKey=@ForeignKey(name="FKDirectivoPersona"))
@DiscriminatorValue("3") // Entidad tipo Directivo
public class Directivo extends Persona 
{
    private static final long serialVersionUID = 4145689406230521224L;
    
    @OneToOne(optional=true)
    @JoinColumn(name="idSocio", foreignKey=@ForeignKey(name="FKDirectivoSocio"))
    private Socio socio = null;
    
    
 
    public Directivo()
    {
        super();
    }



    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Directivo [socio=").append(socio).append(
                ", toString()=").append(super.toString()).append("]");
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
