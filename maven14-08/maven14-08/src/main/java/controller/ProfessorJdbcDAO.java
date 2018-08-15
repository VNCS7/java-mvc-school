package controller;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Alunos;
import model.Professor;

public class ProfessorJdbcDAO {
	
	private Connection conn;

	public ProfessorJdbcDAO(Connection conn){
		this.conn = conn;
	}
	
	public void salvar(Professor c) throws SQLException {
		String sql = "insert into professor (nome,endereco,bairro,idCurso, idDisciplina) values ('"+c.getNome()+"','"+c.getBairro()+"','"+c.getEndereco()+"','"+c.getIdCurso()+"','"+c.getIdDisciplina()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	public void deletar(int idSelect) throws SQLException {
		String sql = "delete from professor where id='"+idSelect+"'";		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	public void atualizar(int idSelect, Professor c) throws SQLException {
		String sql = "update professor set nome='"+c.getNome()+"',endereco='"+c.getEndereco()+"',bairro='"+c.getBairro()+"',idCurso='"+c.getIdCurso()+"',idDisciplina='"+c.getIdDisciplina()+"where id = '"+idSelect+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public List<Alunos> listar() throws SQLException{
		String sql = "select * from professor";
        System.out.println(sql);		
        List<Alunos> alunos = new ArrayList<Alunos>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				System.out.println("\nID: "+rs.getInt("idProfessor")+"\t|NOME: "+rs.getString("nome")+"\t|ENDEREÇO: "+rs.getString("endereco")+"\t|BAIRRO: "+rs.getString("bairro")+"|\t|ID CURSO: "+rs.getInt("idCurso"));
				}

			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}
}

