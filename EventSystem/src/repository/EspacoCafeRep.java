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
import model.EspacoCafeEntity;
import model.EspacoCafeEntity;
import util.ConexaoBD;

/**
 *
 * @author victo
 */
public class EspacoCafeRep extends EspacoCafeEntity{
    
    
    private static final String INSERT = "insert into espaco (nomeEspaco, lotacao) values (?,?);";

    private static final String SELECT = "select idEspaco, nomEspaco, lotacao from espaco order by idEspaco";

    private static final String DELETE = "delete from espaco where idEspaco = ?";

    private static final String UPDATE = "update espaco set nomeEspaco = ?, lotacao = ? where idEspaco = ?";
    
    private Connection connection = ConexaoBD.conectarBanco();
    private PreparedStatement pstm;
    
    public void adicionar(EspacoCafeEntity espaco) {
        
        try {
            
            pstm = connection.prepareStatement(INSERT);
            
            pstm.setString(1, espaco.getNomeEspaco());
            pstm.setInt(2, espaco.getLotacao());                     
            pstm.execute();
            pstm.close();
        
            System.out.println("Concluido!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }
    }
    public void alterar(EspacoCafeEntity espaco) {
        
        try {
            
            pstm = connection.prepareStatement(UPDATE);
            
            pstm.setString(1, espaco.getNomeEspaco());
            pstm.setInt(2, espaco.getLotacao());
            pstm.execute();
            pstm.executeUpdate();
            pstm.close();
            
            
            System.out.println("Concluido!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }
    }
    public void excluir(EspacoCafeEntity espaco) {
        try {
            pstm = connection.prepareStatement(DELETE);
            pstm.setInt(1, espaco.getIdEspaco());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }

    }

    public List<EspacoCafeEntity> listar() {
        List<EspacoCafeEntity> espaco = new ArrayList<>();
        ResultSet res;

        try {
            pstm = connection.prepareStatement(SELECT);
            res = pstm.executeQuery();

            while (res.next()) {
                EspacoCafeEntity e = new  EspacoCafeEntity();
                
                e.setIdEspaco(res.getInt("idEspaco"));
                e.setNomeEspaco(res.getString("nomeEspaco"));             
                e.setLotacao(res.getInt("lotacao"));
                espaco.add(e);
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os espaçoCafe no banco: " + ex.getMessage());
        }
        return espaco;
    }
    
    public ArrayList<EspacoCafeEntity> listarPorNome(String nome) {
        ArrayList<EspacoCafeEntity> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM espaco where nomeEspaco LIKE '%"+nome+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                EspacoCafeEntity c = new  EspacoCafeEntity();
                c.setIdEspaco(res.getInt("idEspaco"));
                c.setNomeEspaco(res.getString("nomeEspaco"));
                c.setLotacao(res.getInt("lotacao"));
                
                lista.add(c);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os estudantes do banco: " + ex.getMessage());
        }
        return lista;
    }
    
    public ArrayList<EspacoCafeEntity> listarPorID(int id) {
        ArrayList<EspacoCafeEntity> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM espaco where idEspaco LIKE '%"+id+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                EspacoCafeEntity c = new  EspacoCafeEntity();
                c.setIdEspaco(res.getInt("idEspaco"));
                c.setNomeEspaco(res.getString("nomeEspaco"));
                c.setLotacao(res.getInt("lotacao"));
                lista.add(c);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os dados do banco: " + ex.getMessage());
        }
        return lista;
    }
}
