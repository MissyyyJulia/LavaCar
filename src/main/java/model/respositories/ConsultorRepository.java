package model.respositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.entities.Consultor;

public class ConsultorRepository implements BasicCrud {

	EntityManager em = Persistence.createEntityManagerFactory("lavacar").createEntityManager();

	@Override
	public Object create(Object object) {
		Consultor consultor = (Consultor) object;
		em.getTransaction().begin();
		em.persist(consultor);
		em.getTransaction().commit();
		return findById(consultor.getId());
	}

	@Override
	public Object findById(Long id) {
		try {
			Consultor consultorInData = em.find(Consultor.class, id);
			return consultorInData;
		} catch (Exception e) {
			System.out.println(e.getCause());
		}

		return null;
	}

	@Override
	public Object updateById(Object object) {
		Consultor consultorUpdate = (Consultor) object;
		em.getTransaction().begin();
		consultorUpdate = em.merge(consultorUpdate);
		em.getTransaction().commit();
		return consultorUpdate;
	}

	@Override
	public void delete(Long id) {
		Consultor consultorToDelete = (Consultor) findById(id);
		em.getTransaction().begin();
		em.remove(consultorToDelete);
		em.getTransaction().commit();
	}

	public List<Consultor> findAll() {
		return em.createQuery("SELECT co FROM Consultor co", Consultor.class).getResultList();
	}

	// retorna o consultor de acordo com o nome
	public Consultor findByNome(String nome) {
		try {
			return em.createQuery("SELECT co FROM Consultor co WHERE co.nome = :nome", Consultor.class)
					.setParameter("nome", nome).getSingleResult();
		} catch (javax.persistence.NoResultException e) {
		    return null;
		}
	}

}
