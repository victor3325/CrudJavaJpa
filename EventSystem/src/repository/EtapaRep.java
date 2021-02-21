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
import model.EtapaEntity;
import model.EtapaEntity;
import util.ConexaoBD;

/**
 *
 * @author victo
 */
public class EtapaRep extends EtapaEntity{
    private static final String INSERT = "insert into etapa (descricao) values (?);";

    private static final String SELECT = "select descricao from etapa order by idetapa";

    private static final String DELETE = "delete from etapa where idetapa = ?";

    private static final String UPDATE = "update etapa set descricao = ? where idetapa = ?";
    
    private Connection connection = ConexaoBD.conectarBanco();
    private PreparedStatement pstm;
    
    public void adicionar(EtapaEntity etapa) {
        
        try {
            
            pstm = connection.prepareStatement(INSERT);
            
            pstm.setString(1, etapa.getDescricao());
            pstm.execute();
            pstm.close();
        
            System.out.println("Concluido!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }
    }
    public void alterar(EtapaEntity etapa) {
        
        try {
            
            pstm = connection.prepareStatement(UPDATE);
            
            pstm.setString(1, etapa.getDescricao());
            pstm.setInt(2, etapa.getIdEtapa());
            pstm.execute();
            pstm.executeUpdate();
            pstm.close();
            
            
            System.out.println("Concluido!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }
    }
    public void excluir(EtapaEntity etapa) {
        try {
            pstm = connection.prepareStatement(DELETE);
            pstm.setInt(1, etapa.getIdEtapa());
            pstm.executeUpdate();
            
            System.out.println("Concluido!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }

    }

    public List<EtapaEntity> listar() {
        List<EtapaEntity> etapas = new ArrayList<>();
        ResultSet res;
        
        try {
            pstm = connection.prepareStatement(SELECT);
            
            res = pstm.executeQuery();

            while (res.next()) {
                EtapaEntity c = new  EtapaEntity();
                c.setIdEtapa(res.getInt("idEtapa"));
                c.setDescricao(res.getString("descricao"));                
                etapas.add(c);
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os dados do banco: " + ex.getMessage());
        }
        return etapas;
    }
    
    public ArrayList<EtapaEntity> listarPorNome(String nome) {
        ArrayList<EtapaEntity> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM etapa where descricao LIKE '%"+nome+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                EtapaEntity c = new  EtapaEntity();
                c.setIdEtapa(res.getInt("idEtapa"));
                c.setDescricao(res.getString("descricao"));
               
                
                lista.add(c);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os estudantes do banco: " + ex.getMessage());
        }
        return lista;
    }
    
    public ArrayList<EtapaEntity> listarPorID(int id) {
        ArrayList<EtapaEntity> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM etapa where idEtapa LIKE '%"+id+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                EtapaEntity c = new  EtapaEntity();
                c.setIdEtapa(res.getInt("idEtapa"));
                c.setDescricao(res.getString("descricao"));
               
                lista.add(c);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os dados do banco: " + ex.getMessage());
        }
        return lista;
    }
}
