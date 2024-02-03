/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import model.Emprestimo;

/**
 *
 * @author davitostes
 */
public class EmprestimoDaoJpa implements InterfaceDao<Emprestimo> {

    @Override
    public void incluir(Emprestimo entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void editar(Emprestimo entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Emprestimo entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();

            Emprestimo c1 = em.find(Emprestimo.class, entidade.getId());
            em.remove(c1);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Emprestimo pesquisarPorId(int id) throws Exception {
        Emprestimo c = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();

            c = em.find(Emprestimo.class, id);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }

    @Override
    public List<Emprestimo> listar() throws Exception {
        List<Emprestimo> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("SELECT * FROM Emprestimo").getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return lista;
    }

    @Override
    public List<Emprestimo> filtrarPorNome(String nome) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();

        Query query = em.createQuery("SELECT * FROM Emprestimo e INNER JOIN Cliente c 0N e.cliente_id = c.id WHERE c.nome = :nome");
        query.setParameter("nome", nome);
        List<Emprestimo> resultado = query.getResultList();
        return resultado;
    }
    
}
