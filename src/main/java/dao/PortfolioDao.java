package dao;

import model.Categoria;
import model.Portfolio;

import javax.persistence.EntityManager;
import java.util.List;

public class PortfolioDao {
    private EntityManager em;

    public PortfolioDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Portfolio portfolio) {
        this.em.persist(portfolio);
    }

    public List<Portfolio> consultarTodos() {
        String jpql = "SELECT c FROM Portfolio c";
        return em.createQuery(jpql, Portfolio.class).getResultList();
    }

    public Portfolio buscarPorId(int id) {
        return em.find(Portfolio.class, id);
    }

    public void removerCategoria (Portfolio portfolio) {
        // carrega no gerenciamento do JPA
        em.merge(portfolio);
        //remove categoria
        this.em.remove(portfolio);
    }

    public void alterarPortfolio (Portfolio portfolio) {
        em.merge(portfolio);
    }

}