package dao;

import model.Perfil;
import model.Plano;

import javax.persistence.EntityManager;
import java.util.List;

public class PerfilDao {
    private EntityManager em;

    public PerfilDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Perfil perfil) {
        this.em.persist(perfil);
    }

    public List<Perfil> consultarTodos() {
        String jpql = "SELECT c FROM Perfil c";
        return em.createQuery(jpql, Perfil.class).getResultList();
    }

    public List<Perfil> consultarPerfisPorId(int idUsuario) {
        String jpql = "SELECT p FROM Perfil p WHERE p.idUsuario = " + idUsuario + "";
        System.out.println(jpql);
        return em.createQuery(jpql, Perfil.class).getResultList();
    }


    public Perfil buscarPorId(int id) {
        return em.find(Perfil.class, id);
    }

    public void removerCategoria (Perfil perfil) {
        // carrega no gerenciamento do JPA
        em.merge(perfil);
        //remove
        this.em.remove(perfil);
    }

    public void alterarPerfil (Perfil perfil) {
        em.merge(perfil);
    }

}