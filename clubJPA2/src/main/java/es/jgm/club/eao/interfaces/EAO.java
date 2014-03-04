package es.jgm.club.eao.interfaces;

import java.util.List;

public interface EAO<K, E>
{
    public E alta(E entidad);
    public E actualiza(E entidad);
    public E deshacerCambios(E entidad);
    public boolean borrar(E entidad);
    public E obtenerPK(E entidad, Integer id);
    public List<E> obtenerTodos(E entidad); 
}
