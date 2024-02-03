/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * @author davitostes
 */
public class DaoFactory {
    
    public static JogoDaoJpa novoJogoDao() throws Exception {
        return new JogoDaoJpa();
    }
    
    public static ClienteDaoJpa novoClienteDao() throws Exception {
        return new ClienteDaoJpa();
    }
    
    public static EmprestimoDaoJpa novoEmprestimoDao() throws Exception {
        return new EmprestimoDaoJpa();
    }
}
