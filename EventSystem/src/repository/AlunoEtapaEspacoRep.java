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
import model.AlunoEtapaEspacoEntity;
import model.IdCompostoAlunoEtapaEspaco;

import util.ConexaoBD;

/**
 *
 * @author victo
 */
public class AlunoEtapaEspacoRep extends AlunoEtapaEspacoEntity {
    private static final String INSERT = "insert into alunoetapaespaco (idAluno, idEtapa, idEspaco) values (?,?,?);";

    private static final String SELECT = "select * from alunoetapaespaco order by idAluno";

    private static final String DELETE = "delete from alunoetapaespaco where idAluno = ?";

    private static final String UPDATE = "update alunoetapaespaco set idEtapa = ?, idEspaco = ?  where idAluno = ?";
    
    private Connection connection = ConexaoBD.conectarBanco();
    private PreparedStatement pstm;
    
    public void adicionar(AlunoEtapaEspacoEntity aee) {
        
        try {
            
            pstm = connection.prepareStatement(INSERT);
            
            pstm.setInt(1, aee.getId().getIdAluno());
            pstm.setInt(2, aee.getId().getIdEtapa());
            pstm.setInt(3, aee.getId().getIdEspaco());
            pstm.execute();
            pstm.close();
        
            System.out.println("Concluido!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }
    }
    public void alterar(AlunoEtapaEspacoEntity aee) {
        
        try {
            
            pstm = connection.prepareStatement(UPDATE);
            
            pstm.setInt(1, aee.getId().getIdEtapa());
            pstm.setInt(2, aee.getId().getIdEspaco());
            pstm.setInt(3, aee.getId().getIdAluno());
            pstm.execute();
            pstm.executeUpdate();
            pstm.close();
            
            
            System.out.println("Concluido!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }
    }
    public void excluir(AlunoEtapaEspacoEntity aee) {
        try {
            pstm = connection.prepareStatement(DELETE);
            pstm.setInt(1, aee.getId().getIdAluno());
            pstm.executeUpdate();
            
            System.out.println("Concluido!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }

    }

    public List<IdCompostoAlunoEtapaEspaco> listar() {
        List<IdCompostoAlunoEtapaEspaco> aee = new ArrayList<>();
        ResultSet res;

        try {
            pstm = connection.prepareStatement(SELECT);
            res = pstm.executeQuery();

            while (res.next()) {
                IdCompostoAlunoEtapaEspaco idEe = new IdCompostoAlunoEtapaEspaco();
                
                idEe.setIdAluno(res.getInt("idAluno"));
                idEe.setIdEtapa(res.getInt("idEtapa"));
                idEe.setIdEspaco(res.getInt("idEspaco"));
                
                
                aee.add(idEe);
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os estudantes do banco: " + ex.getMessage());
        }
        return aee;
    }
    
    public ArrayList<IdCompostoAlunoEtapaEspaco> listarPorIdEspacoComposto(int idEspaco, int idEtapa) {
        ArrayList<IdCompostoAlunoEtapaEspaco> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM alunoetapaespaco where idEspaco LIKE '%"+idEspaco+"%' and idEtapa LIKE '%"+idEtapa+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                
                IdCompostoAlunoEtapaEspaco idEe = new IdCompostoAlunoEtapaEspaco();
                
                idEe.setIdAluno(res.getInt("idAluno"));
                idEe.setIdEtapa(res.getInt("idEtapa"));
                idEe.setIdEspaco(res.getInt("idEspaco"));
                
                lista.add(idEe);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os dados do banco: " + ex.getMessage());
        }
        return lista;
    }
    
    public ArrayList<IdCompostoAlunoEtapaEspaco> listarPorIdAlunoComposto(int id) {
        ArrayList<IdCompostoAlunoEtapaEspaco> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM alunoetapaespaco where idAluno LIKE '%"+id+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                
                IdCompostoAlunoEtapaEspaco idEe = new IdCompostoAlunoEtapaEspaco();
                
                idEe.setIdAluno(res.getInt("idAluno"));
                idEe.setIdEtapa(res.getInt("idEtapa"));
                idEe.setIdEspaco(res.getInt("idEspaco"));
                
                lista.add(idEe);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os dados do banco: " + ex.getMessage());
        }
        return lista;
    }
    
    public ArrayList<IdCompostoAlunoEtapaEspaco> listarPorIdEtapaComposto(int idEtapa, int idAluno) {
        ArrayList<IdCompostoAlunoEtapaEspaco> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM alunoetapaespaco where idEtapa LIKE '%"+idEtapa+"%' and idAluno LIKE '%"+idAluno+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                
                IdCompostoAlunoEtapaEspaco idEe = new IdCompostoAlunoEtapaEspaco();
                
                idEe.setIdAluno(res.getInt("idAluno"));
                idEe.setIdEtapa(res.getInt("idEtapa"));
                idEe.setIdEspaco(res.getInt("idEspaco"));
                
                lista.add(idEe);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os dados do banco: " + ex.getMessage());
        }
        return lista;
    }
}
