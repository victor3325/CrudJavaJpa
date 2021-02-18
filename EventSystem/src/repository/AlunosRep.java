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
    private static final String INSERT = "insert into alunos ( nomeAluno, sobrenome) values (?,?);";

    private static final String SELECT = "select idAluno, nomeAluno, sobrenome from alunos order by idAluno";

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
                
                c.setIdAluno(res.getInt("idAlunos"));
                c.setNomeAluno(res.getString("nomeAlunos"));
                c.setSobrenome(res.getString("Sobrenome"));             
                
                alunos.add(c);
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar buscar os estudantes do banco: " + ex.getMessage());
        }
        return alunos;
    }
}
