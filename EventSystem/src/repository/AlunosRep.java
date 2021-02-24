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
import model.AlunosEntity;
import util.ConexaoBD;

/**
 *
 * @author victo
 */
public class AlunosRep extends AlunosEntity{
    private static final String INSERT = "insert into alunos (nomeAluno, sobrenome) values (?,?);";

    private static final String SELECT = "select idAluno, nomealuno, sobrenome from alunos order by idaluno";

    private static final String DELETE = "delete from alunos where idAluno = ?";

    private static final String UPDATE = "update alunos set nomeAluno = ?, sobrenome = ? where idAluno = ?";
    
    private Connection connection = ConexaoBD.conectarBanco();
    private PreparedStatement pstm;
    
    public void adicionar(AlunosEntity alunos) {
        
        try {
            
            pstm = connection.prepareStatement(INSERT);
            
            pstm.setString(1, alunos.getNomeAluno());
            pstm.setString(2, alunos.getSobrenome());
            pstm.execute();
            pstm.close();
        
            System.out.println("Concluido!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }
    }
    public void alterar(AlunosEntity alunos) {
        
        try {
            
            pstm = connection.prepareStatement(UPDATE);
            
            pstm.setString(1, alunos.getNomeAluno());
            pstm.setString(2, alunos.getSobrenome());
            pstm.setInt(3, alunos.getIdAluno());
            pstm.execute();
            pstm.executeUpdate();
            pstm.close();
            
            
            System.out.println("Concluido!");

        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }
    }
    public void excluir(AlunosEntity alunos) {
        try {
            pstm = connection.prepareStatement(DELETE);
            pstm.setInt(1, alunos.getIdAluno());
            pstm.executeUpdate();
            
            System.out.println("Concluido!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar salvar: " + ex.getMessage());
        }

    }

    public List<AlunosEntity> listar() {
        List<AlunosEntity> alunos = new ArrayList<>();
        ResultSet res;
        
        try {
            pstm = connection.prepareStatement(SELECT);
            
            res = pstm.executeQuery();

            while (res.next()) {
                AlunosEntity c = new  AlunosEntity();
                c.setIdAluno(res.getInt("idAluno"));
                c.setNomeAluno(res.getString("nomeAluno"));
                c.setSobrenome(res.getString("Sobrenome"));                
                alunos.add(c);
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os estudantes do banco: " + ex.getMessage());
        }
        return alunos;
    }
    
    public ArrayList<AlunosEntity> listarPorNome(String nome) {
        ArrayList<AlunosEntity> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM alunos where nomeAluno LIKE '%"+nome+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                AlunosEntity c = new  AlunosEntity();
                c.setIdAluno(res.getInt("idAluno"));
                c.setNomeAluno(res.getString("nomeAluno"));
                c.setSobrenome(res.getString("Sobrenome"));
                
                lista.add(c);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os estudantes do banco: " + ex.getMessage());
        }
        return lista;
    }
    
    public ArrayList<AlunosEntity> listarPorID(int id) {
        ArrayList<AlunosEntity> lista = new ArrayList<>();
        ResultSet res;
        try {
             pstm = connection.prepareStatement("SELECT * FROM alunos where idAluno LIKE '%"+id+"%'");
             res = pstm.executeQuery();
             while (res.next()) {
                AlunosEntity c = new  AlunosEntity();
                c.setIdAluno(res.getInt("idAluno"));
                c.setNomeAluno(res.getString("nomeAluno"));
                c.setSobrenome(res.getString("Sobrenome"));
                
                lista.add(c);
            }
             
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os dados do banco: " + ex.getMessage());
        }
        return lista;
    }
    public List<AlunosEntity> listarPorSala(int idAluno, int idSala, int idEtapa) {
        List<AlunosEntity> alunos = new ArrayList<>();
        ResultSet res;
        
        try {
            pstm = connection.prepareStatement("SELECT alunos.idAluno, alunos.nomeAluno, alunos.sobrenome FROM alunoEtapaSala JOIN alunos ON alunoetapasala.idAluno = alunos.idAluno JOIN etapa  on alunoetapasala.idEtapa = etapa.idEtapa JOIN salas  ON alunoetapasala.idSala = salas.idSala where alunos.idAluno LIKE '%"+idAluno+"%' and alunoetapasala.idSala LIKE '%"+idSala+"%' and alunoetapasala.idEtapa LIKE '%"+idEtapa+"%'"); 
            
            res = pstm.executeQuery();

            while (res.next()) {
                AlunosEntity c = new  AlunosEntity();
                c.setIdAluno(res.getInt("idAluno"));
                c.setNomeAluno(res.getString("nomeAluno"));
                c.setSobrenome(res.getString("Sobrenome"));                
                alunos.add(c);
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os estudantes do banco: " + ex.getMessage());
        }
        return alunos;
    }
    
    public List<AlunosEntity> listarPorEspaco(int idAluno, int idEspaco, int idEtapa) {
        List<AlunosEntity> alunos = new ArrayList<>();
        ResultSet res;
        
        try {
            pstm = connection.prepareStatement("SELECT alunos.idAluno, alunos.nomeAluno, alunos.sobrenome FROM alunoEtapaEspaco JOIN alunos ON alunoetapaespaco.idAluno = alunos.idAluno JOIN etapa on alunoetapaespaco.idEtapa = etapa.idEtapa JOIN espaco ON alunoetapaespaco.idEspaco = espaco.idEspaco where alunos.idAluno LIKE '%"+idAluno+"%' and alunoetapaespaco.idEspaco LIKE '%"+idEspaco+"%' and alunoetapaespaco.idEtapa LIKE '%"+idEtapa+"%'"); 
            
            res = pstm.executeQuery();

            while (res.next()) {
                AlunosEntity c = new  AlunosEntity();
                c.setIdAluno(res.getInt("idAluno"));
                c.setNomeAluno(res.getString("nomeAluno"));
                c.setSobrenome(res.getString("Sobrenome"));                
                alunos.add(c);
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os estudantes do banco: " + ex.getMessage());
        }
        return alunos;
    }
    
}
