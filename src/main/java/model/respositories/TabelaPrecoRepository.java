package model.respositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.entities.TabelaPreco;

public class TabelaPrecoRepository implements BasicCrud {

	EntityManager em = Persistence.createEntityManagerFactory("lavacar").createEntityManager();

	@Override
	public Object create(Object object) {
		TabelaPreco tabelaPreco = (TabelaPreco) object;
		em.getTransaction().begin();
		em.persist(tabelaPreco);
		em.getTransaction().commit();
		return findById(tabelaPreco.getId());
	}

	@Override
	public Object findById(Long id) {
		try {
			TabelaPreco tabelaPrecoInData = em.find(TabelaPreco.class, id);
			return tabelaPrecoInData;
		} catch (Exception e) {
			System.out.println(e.getCause());
		}
		return null;
	}

	@Override
	public Object updateById(Object object) {
		TabelaPreco tabelaPrecoUpdate = (TabelaPreco) object;
		em.getTransaction().begin();
		tabelaPrecoUpdate = em.merge(tabelaPrecoUpdate);
		em.getTransaction().commit();
		return tabelaPrecoUpdate;
	}

	@Override
	public void delete(Long id) {
		TabelaPreco tabelaPrecoToDelete = (TabelaPreco) findById(id);
		em.getTransaction().begin();
		em.remove(tabelaPrecoToDelete);
		em.getTransaction().commit();
	}

	public List<TabelaPreco> findAll() {
		return em.createQuery("SELECT t FROM TabelaPreco t", TabelaPreco.class).getResultList();
	}

	// Procurar Preço por Modelo do carro
	// UPER pra ficar num padrão e evitar erro por CaseSensitive
	public TabelaPreco findByModelo(String modelo) {
		try {
			return em.createQuery("SELECT t FROM TabelaPreco t WHERE UPPER(t.modelo) = :modelo", TabelaPreco.class)
					.setParameter("modelo", modelo.toUpperCase()).getSingleResult();
		} catch (javax.persistence.NoResultException e) {
		    return null;
		}
	}
}
