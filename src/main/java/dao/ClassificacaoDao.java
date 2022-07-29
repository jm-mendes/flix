package dao;

import model.Classificacao;

import javax.persistence.EntityManager;
import java.util.List;

public class ClassificacaoDao {
    private EntityManager em;

    public ClassificacaoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Classificacao classificacao) {
        this.em.persist(classificacao);
    }

    public List<Classificacao> consultarTodos() {
        String jpql = "SELECT c FROM Classificacao c";
        return em.createQuery(jpql, Classificacao.class).getResultList();
    }

    public Classificacao buscarPorId(int id) {
        return em.find(Classificacao.class, id);
    }

    public void removerCategoria (Classificacao classificacao) {
        // carrega no gerenciamento do JPA
        em.merge(classificacao);
        //remove categoria
        this.em.remove(classificacao);
    }

    public void alterarClassificacao (Classificacao classificacao) {
        em.merge(classificacao);
    }

}