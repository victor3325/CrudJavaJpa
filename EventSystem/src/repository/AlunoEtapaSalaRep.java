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
import model.AlunoEtapaSalaEntity;
import model.IdCompostoAlunoEtapaSala;
import util.ConexaoBD;

/**
 *
 * @author victo
 */
public class AlunoEtapaSalaRep extends AlunoEtapaSalaEntity{
    private static final String INSERT = "insert into alunoetapasala (idAluno, idEtapa, idSala) values (?,?,?);";

    private static final String SELECT = "select * from alunoetapasala order by idAluno";

    private static final String DELETE = "delete from alunoetapasala where idAluno = ?";

    private static final String UPDATE = "update alunoetapasala set idEtapa = ?, idSala = ?  where idAluno = ?";
    
    private Connection connection = ConexaoBD.conectarBanco();
    private PreparedStatement pstm;
    
    public void adicionar(AlunoEtapaSalaEntity aes) {
        
        try {
            
            pstm = connection.prepareStatement(INSERT);
            
            pstm.setInt(1, aes.getId().getIdAluno());
            pstm.setInt(2, aes.getId().getIdEtapa());
            pstm.setInt(3, aes.getId().getIdSala());
            pstm.execute();
            pstm.close();
        
            System.out.println("Concluido!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }
    }
    public void alterar(AlunoEtapaSalaEntity aes) {
        
        try {
            
            pstm = connection.prepareStatement(UPDATE);
            
            pstm.setInt(1, aes.getId().getIdEtapa());
            pstm.setInt(2, aes.getId().getIdSala());
            pstm.setInt(3, aes.getId().getIdAluno());
            pstm.execute();
            pstm.executeUpdate();
            pstm.close();
            
            
            System.out.println("Concluido!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }
    }
    public void excluir(AlunoEtapaSalaEntity aes) {
        try {
            pstm = connection.prepareStatement(DELETE);
            pstm.setInt(1, aes.getId().getIdAluno());
            pstm.executeUpdate();
            
            System.out.println("Concluido!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }

    }
    public void excluirEtapa1(AlunoEtapaSalaEntity aes) {
        try {
            pstm = connection.prepareStatement("delete from alunoetapasala where idEtapa = 1");
            
            pstm.executeUpdate();
            
            System.out.println("Concluido!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }

    }
    public void excluirEtapa2(AlunoEtapaSalaEntity aes) {
        try {
            pstm = connection.prepareStatement("delete from alunoetapasala where idEtapa = 2");
            
            pstm.executeUpdate();
            
            System.out.println("Concluido!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }

    }
    public ArrayList<IdCompostoAlunoEtapaSala> listar() {
        ArrayList<IdCompostoAlunoEtapaSala> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement(SELECT);
             res = pstm.executeQuery();
             while (res.next()) {
                
                IdCompostoAlunoEtapaSala idEs = new IdCompostoAlunoEtapaSala();
                
                idEs.setIdAluno(res.getInt("idAluno"));
                idEs.setIdEtapa(res.getInt("idEtapa"));
                idEs.setIdSala(res.getInt("idSala"));
                
                lista.add(idEs);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os dados do banco: " + ex.getMessage());
        }
        return lista;
    }
    
     public ArrayList<IdCompostoAlunoEtapaSala> listarPorIdEtapaComposto(int idetapa,int idaluno) {
        ArrayList<IdCompostoAlunoEtapaSala> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM alunoetapasala where idEtapa LIKE '%"+idetapa+"%' and idAluno LIKE '%"+idaluno+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                
                IdCompostoAlunoEtapaSala idEs = new IdCompostoAlunoEtapaSala();
                
                idEs.setIdAluno(res.getInt("idAluno"));
                idEs.setIdEtapa(res.getInt("idEtapa"));
                idEs.setIdSala(res.getInt("idSala"));
                
                lista.add(idEs);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os dados do banco: " + ex.getMessage());
        }
        return lista;
    }
    
     public ArrayList<IdCompostoAlunoEtapaSala> listarPorIdAlunoComposto(int id) {
        ArrayList<IdCompostoAlunoEtapaSala> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM alunoetapasala where idAluno LIKE '%"+id+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                
                IdCompostoAlunoEtapaSala idEs = new IdCompostoAlunoEtapaSala();
                
                idEs.setIdAluno(res.getInt("idAluno"));
                idEs.setIdEtapa(res.getInt("idEtapa"));
                idEs.setIdSala(res.getInt("idSala"));
                
                lista.add(idEs);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os dados do banco: " + ex.getMessage());
        }
        return lista;
    }
    
    
    
    public ArrayList<IdCompostoAlunoEtapaSala> listarPorIdSalaComposto(int idSala,int idEtapa) {
        ArrayList<IdCompostoAlunoEtapaSala> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM alunoetapasala where idSala LIKE '%"+idSala+"%' and idEtapa LIKE '%"+idEtapa+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                
                IdCompostoAlunoEtapaSala idEs = new IdCompostoAlunoEtapaSala();
                
                idEs.setIdAluno(res.getInt("idAluno"));
                idEs.setIdEtapa(res.getInt("idEtapa"));
                idEs.setIdSala(res.getInt("idSala"));
                
                lista.add(idEs);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os dados do banco: " + ex.getMessage());
        }
        return lista;
    }
  
}
