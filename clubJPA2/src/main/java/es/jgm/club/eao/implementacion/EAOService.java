package es.jgm.club.eao.implementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.jgm.club.eao.interfaces.EAO;

public class EAOService<E, K> implements EAO<K, E>
{

    @PersistenceContext
    protected EntityManager em;

    @Override
    public E alta(E entidad)
    {
        em.persist(entidad);
        return entidad;
    }

    @Override
    public E actualiza(E entidad)
    {
        em.merge(entidad);
        return entidad;
    }

    @Override
    public E deshacerCambios(E entidad)
    {
        em.refresh(entidad);
        return entidad;
    }

    @Override
    public boolean borrar(E entidad)
    {
        em.remove(entidad);
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> obtenerTodos(E entidad)
    {
        Query query = em.createQuery("SELECT e FROM " + entidad.getClass() + " e");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public E obtenerPK(E entidad, Integer id)
    {
        return (E)em.find(entidad.getClass(), id);
        
   }
}
