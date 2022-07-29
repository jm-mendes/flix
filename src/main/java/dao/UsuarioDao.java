package dao;

import model.Portfolio;
import model.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDao {
    private EntityManager em;

    public UsuarioDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Usuario usuario) {
        this.em.persist(usuario);
    }

    public List<Usuario> consultarTodos() {
        String jpql = "SELECT c FROM Usuario c";
        return em.createQuery(jpql, Usuario.class).getResultList();
    }

    public Usuario buscarPorId(int id) {
        return em.find(Usuario.class, id);
    }

    public void removerUsuario (Usuario usuario) {
        // carrega no gerenciamento do JPA
        em.merge(usuario);
        //remove categoria
        this.em.remove(usuario);
    }

    public void alterarUsuario (Usuario usuario) {
        em.merge(usuario);
    }

}