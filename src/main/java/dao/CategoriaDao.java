package dao;

import model.Categoria;
import model.Classificacao;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {
    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }

    public List<Categoria> consultarTodos() {
        String jpql = "SELECT c FROM Categoria c";
        return em.createQuery(jpql, Categoria.class).getResultList();
    }

    public Categoria buscarPorId(int id) {
        return em.find(Categoria.class, id);
    }

    public void removerCategoria (Categoria categoria) {
        // carrega no gerenciamento do JPA
        em.merge(categoria);
        //remove categoria
        this.em.remove(categoria);
    }

    public void alterarCategoria (Categoria categoria) {
        em.merge(categoria);
    }

}