package model.respositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.entities.Lavagem;

public class LavagemRepository implements BasicCrud {

	EntityManager em = Persistence.createEntityManagerFactory("lavacar").createEntityManager();

	@Override
	public Object create(Object object) {
		Lavagem lavagem = (Lavagem) object;
		em.getTransaction().begin();
		em.persist(lavagem);
		em.getTransaction().commit();
		return findById(lavagem.getId());
	}

	@Override
	public Object findById(Long id) {
		try {
			Lavagem lavagemInData = em.find(Lavagem.class, id);
			return lavagemInData;
		} catch (Exception e) {
			System.out.println(e.getCause());
		}

		return null;
	}

	@Override
	public Object updateById(Object object) {
		Lavagem lavagemUpdate = (Lavagem) object;
		em.getTransaction().begin();
		lavagemUpdate = em.merge(lavagemUpdate);
		em.getTransaction().commit();
		return lavagemUpdate;
	}

	@Override
	public void delete(Long id) {
		Lavagem lavagemToDelete = (Lavagem) findById(id);
		em.getTransaction().begin();
		em.remove(lavagemToDelete);
		em.getTransaction().commit();
	}

	public List<Lavagem> findAll() {
		return em.createQuery("SELECT l FROM Lavagem l", Lavagem.class).getResultList();
	}

	// Encontra a lavagem de acordo com o construtor
	public List<Lavagem> findByConsultorId(Long idConsultor) {
		return em.createQuery("SELECT l FROM Lavagem l WHERE l.consultor.id = :idConsultor", Lavagem.class)
				.setParameter("idConsultor", idConsultor).getResultList();
	}

}
