package model.respositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.entities.Carro;

public class CarroRepository implements BasicCrud {

	EntityManager em = Persistence.createEntityManagerFactory("lavacar").createEntityManager();

	@Override
	public Object create(Object object) {
		Carro carro = (Carro) object;
		em.getTransaction().begin();
		em.persist(carro);
		em.getTransaction().commit();
		return findById(carro.getId());
	}

	@Override
	public Object findById(Long id) {
		try {
			Carro carroInData = em.find(Carro.class, id);
			return carroInData;
		} catch (Exception e) {
			System.out.println(e.getCause());
		}

		return null;
	}

	@Override
	public Object updateById(Object object) {
		Carro carroUpdate = (Carro) object;
		em.getTransaction().begin();
		carroUpdate = em.merge(carroUpdate);
		em.getTransaction().commit();
		return carroUpdate;
	}

	@Override
	public void delete(Long id) {
		Carro carroToDelete = (Carro) findById(id);
		em.getTransaction().begin();
		em.remove(carroToDelete);
		em.getTransaction().commit();
	}

	public List<Carro> findAll() {
		return em.createQuery("SELECT c FROM Carro c", Carro.class).getResultList();
	}

	// retorna o carro de acordo com a placa
	public Carro findByPlaca(String placa) {
		try {
		    return em.createQuery("SELECT c FROM Carro c WHERE c.placa = :placa", Carro.class)
		             .setParameter("placa", placa)
		             .getSingleResult();
		} catch (javax.persistence.NoResultException e) {
		    return null;
		}
	}
	


	// retorna o carro de acordo com o chassi
	public Carro findByChassi(String chassi) {
		try {
		    return em.createQuery("SELECT c FROM Carro c WHERE c.chassi = :chassi", Carro.class)
		             .setParameter("chassi", chassi)
		             .getSingleResult();
		} catch (javax.persistence.NoResultException e) {
		    return null;
		}
	}

}
