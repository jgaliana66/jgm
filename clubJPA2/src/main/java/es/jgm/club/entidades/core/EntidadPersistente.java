package es.jgm.club.entidades.core;

/**
 * @author jgaliana
 * 
 *         Interfaz que contiene los getter's y setter's de las propiedades que
 *         tienen que estar presentes en cualquier entidad
 * 
 *         Este interfaz nos sirve para implementar en la clase abstracta los
 *         metodos equals y hash que usan un único identificador, el atributo
 *         UUID. Según el contrato del método hash para las entidades
 *         persistentes, los atributos que se usen dentro del método para
 *         generar el hash deben ser inmutables.
 * 
 *         El id (clave primaria) está desaconsejado, versión se usa para el
 *         bloqueo optimista por lo que será mutable cada vez que se
 *         inserte/actualice en la base de datos y el resto de propiedades de la
 *         entidad pueden ser mutables.
 * 
 *         Usando un atributo extra, el uuid, que generamos la primera vez que
 *         se guarda en la base de datos no se vuelve a modificad para dicha
 *         entidad, nos garantizamos que se puedan usar los métodos hash y
 *         equals correctamente.
 *         
 *         El desarrollo de todo esto se puede ver en:
 *         
 *         1) http://www.onjava.com/pub/a/onjava/2006/09/13/dont-let-hibernate-steal-your-identity.html?page=1
 *         2) http://stackoverflow.com/questions/5031614/the-jpa-hashcode-equals-dilemma
 *         
 */

public interface EntidadPersistente
{
    public Integer getId();

    public String getUuid();

    public Integer getVersion();

    public void setId(Integer id);

    public void setUuid(String uuid);

    public void setVersion(Integer version);

}
