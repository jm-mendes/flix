package dao;

import model.Categoria;
import model.Plano;

import javax.persistence.EntityManager;
import java.util.List;

public class PlanoDao {
    private EntityManager em;

    public PlanoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Plano plano) {
        this.em.persist(plano);
    }

    public List<Plano> consultarTodos() {
        String jpql = "SELECT c FROM Plano c";
        return em.createQuery(jpql, Plano.class).getResultList();
    }

    public Plano buscarPorId(int id) {
        return em.find(Plano.class, id);
    }

    public void removerCategoria (Plano plano) {
        // carrega no gerenciamento do JPA
        em.merge(plano);
        //remove categoria
        this.em.remove(plano);
    }

    public void alterarPlano (Plano plano) {
        em.merge(plano);
    }

}