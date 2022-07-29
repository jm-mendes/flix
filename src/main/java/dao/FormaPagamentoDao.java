package dao;

import model.FormaPagamento;

import javax.persistence.EntityManager;
import java.util.List;

public class FormaPagamentoDao {
    private static EntityManager em;

    public FormaPagamentoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(FormaPagamento formaPagamento) {
        this.em.persist(formaPagamento);
    }

    public List<FormaPagamento> consultarTodos() {
        String jpql = "SELECT c FROM FormaPagamento c";
        return em.createQuery(jpql, FormaPagamento.class).getResultList();
    }

    public static FormaPagamento buscarPorId(int id) {
        return em.find(FormaPagamento.class, id);
    }

    public void removerCategoria (FormaPagamento formaPagamento) {
        // carrega no gerenciamento do JPA
        em.merge(formaPagamento);
        //remove categoria
        this.em.remove(formaPagamento);
    }

    public void alterarFormaPagamento (FormaPagamento formaPagamento) {
        em.merge(formaPagamento);
    }

}