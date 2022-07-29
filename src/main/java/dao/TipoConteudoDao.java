package dao;

import model.Categoria;
import model.TipoConteudo;

import javax.persistence.EntityManager;
import java.util.List;

public class TipoConteudoDao {
    private EntityManager em;

    public TipoConteudoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(TipoConteudo tipoConteudo) {
        this.em.persist(tipoConteudo);
    }

    public List<TipoConteudo> consultarTodos() {
        String jpql = "SELECT c FROM TipoConteudo c";
        return em.createQuery(jpql, TipoConteudo.class).getResultList();
    }

    public TipoConteudo buscarPorId(int id) {
        return em.find(TipoConteudo.class, id);
    }

    public void removerTipoConteudo (TipoConteudo tipoConteudo) {
        // carrega no gerenciamento do JPA
        em.merge(tipoConteudo);
        //remove categoria
        this.em.remove(tipoConteudo);
    }

    public void alterarTipoConteudo (TipoConteudo tipoConteudo) {
        em.merge(tipoConteudo);
    }

}