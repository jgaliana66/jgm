package es.jgm.club.entidades.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.jgm.club.entidades.Socio;
import es.jgm.club.entidades.core.EntidadPersistente;

@RunWith(Arquillian.class)
public class ClubPersistenceTest
{
    @Deployment
    public static Archive<?> createDeployment()
    {
        WebArchive archivo = ShrinkWrap.create(WebArchive.class, "test.war").addPackage(
                Socio.class.getPackage()).addPackage(
                EntidadPersistente.class.getPackage()).addAsResource(
                "test-persistence.xml", "META-INF/persistence.xml").addAsWebInfResource(
                EmptyAsset.INSTANCE, "beans.xml");

        return archivo;
    }

    private static final String[] GAME_TITLES =
    { "Super Mario Brothers", "Mario Kart", "F-Zero" };

    @PersistenceContext
    EntityManager em;

    @Inject
    UserTransaction utx;

    @Before
    public void preparePersistenceTest() throws Exception
    {
        System.out.println("Transacción: " + utx.toString());
        clearData();
        insertData();
        startTransaction();
    }

    @After
    public void commitTransaction() throws Exception
    {
        utx.commit();
    }

    private void clearData() throws Exception
    {
        utx.begin();
        em.joinTransaction();
        System.out.println("Descartando registros obsoletos...");
        em.createQuery("delete from Socio").executeUpdate();
        utx.commit();
    }

    private void insertData() throws Exception
    {
        utx.begin();
        em.joinTransaction();
        System.out.println("Insertando registros...");
        for (String title : GAME_TITLES)
        {
            Socio socio = new Socio();
            socio.setNombre(title);
            em.persist(socio);
        }
        utx.commit();
        // Vacía el contexto de persistencia (cache de primer nivel)
        em.clear();
    }

    private void startTransaction() throws Exception
    {
        utx.begin();
        em.joinTransaction();
    }

    // ***************************************************************** tests
    // go here

    @Test
    public void shouldFindAllGamesUsingCriteriaApi() throws Exception
    {
        // dado (given)
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Socio> criteria = builder.createQuery(Socio.class);

        Root<Socio> socio = criteria.from(Socio.class);
        criteria.select(socio);
        // TIP: Si no quieres usar el metamodelo de JPA 2
        // puedes cambiar la llamada al método get() por get("id")
        criteria.orderBy(builder.asc(socio.get("id")));
        // Sin cláusula WHERE , lo que implica select all

        // cuando (when)
        System.out.println("Consultando (usando Criteria)...");
        List<Socio> socios = em.createQuery(criteria).getResultList();

        // entonces (then)
        System.out.println("Encontrado(s) " + socios.size() + " socios (usando Criteria):");
        assertContainsAllSocios(socios);
    }

    private static void assertContainsAllSocios(Collection<Socio> retrievedSocios)
    {
        Assert.assertEquals(GAME_TITLES.length, retrievedSocios.size());
        final Set<String> retrievedGameTitles = new HashSet<String>();
        for (Socio socio : retrievedSocios)
        {
            System.out.println("* " + socio);
            retrievedGameTitles.add(socio.getNombre());
        }
        Assert.assertTrue(retrievedGameTitles.containsAll(Arrays.asList(GAME_TITLES)));
    }
}