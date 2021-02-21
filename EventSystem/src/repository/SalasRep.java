/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SalasEntity;
import util.ConexaoBD;

/**
 *
 * @author victo
 */
public class SalasRep extends SalasEntity{
        
    
    private static final String INSERT = "insert into salas (nomesala, lotacao) values (?,?);";

    private static final String SELECT = "select idsala, nomesala, lotacao from salas order by idsala";

    private static final String DELETE = "delete from salas where idsala = ?";

    private static final String UPDATE = "update salas set nomesala = ?, lotacao = ? where idsala = ?";
    
    private Connection connection = ConexaoBD.conectarBanco();
    private PreparedStatement pstm;
    
    /**
     *
     * @param salas
     */
    public void adicionar(SalasEntity salas) {
        
        try {
            
            pstm = connection.prepareStatement(INSERT);
            
            pstm.setString(1, salas.getNomeSala());
            pstm.setInt(2, salas.getLotacao());
            pstm.execute();
            pstm.close();
        
            System.out.println("Concluido!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }
    }
    public void alterar(SalasEntity salas) {
        
        try {
            
            pstm = connection.prepareStatement(UPDATE);
            
            pstm.setString(1, salas.getNomeSala());
            pstm.setInt(2, salas.getLotacao());
            pstm.execute();
            pstm.executeUpdate();
            pstm.close();
            
            
            System.out.println("Concluido!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }
    }
    public void excluir(SalasEntity salas) {
        try {
            pstm = connection.prepareStatement(DELETE);
            pstm.setInt(1, salas.getIdSala());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }

    }

    public List<SalasEntity> listar() {
        List<SalasEntity> salas = new ArrayList<>();
        ResultSet res;

        try {
            pstm = connection.prepareStatement(SELECT);
            res = pstm.executeQuery();

            while (res.next()) {
                SalasEntity s = new  SalasEntity();
                
                s.setIdSala(res.getInt("idAlunos"));
                s.setNomeSala(res.getString("nomeAlunos")); 
                s.setLotacao(res.getInt("lotacao"));
                
                salas.add(s);
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os espaçoCafe no banco: " + ex.getMessage());
        }
        return salas;
    }
    
    public ArrayList<SalasEntity> listarPorID(int id) {
        ArrayList<SalasEntity> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM salas where idSala LIKE '%"+id+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                SalasEntity c = new  SalasEntity();
                c.setIdSala(res.getInt("idSala"));
                c.setNomeSala(res.getString("nomeSala"));
                c.setLotacao(res.getInt("lotacao"));
                lista.add(c);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os dados do banco: " + ex.getMessage());
        }
        return lista;
    }
    
    public ArrayList<SalasEntity> listarPorNome(String nome) {
        ArrayList<SalasEntity> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM salas where nomesala LIKE '%"+nome+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                SalasEntity c = new  SalasEntity();
                c.setIdSala(res.getInt("idSala"));
                c.setNomeSala(res.getString("nomeSala"));
                c.setLotacao(res.getInt("lotacao"));
                lista.add(c);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os dados do banco: " + ex.getMessage());
        }
        return lista;
    }
}
