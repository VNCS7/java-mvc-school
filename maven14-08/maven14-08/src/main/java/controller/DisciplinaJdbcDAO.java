package controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.*;

public class DisciplinaJdbcDAO {
	private Connection conn;
	
	public DisciplinaJdbcDAO(Connection conn){
		this.conn = conn;
	}
	
	public void salvar(Disciplina disciplina) throws SQLException{
		String sql = "insert into disciplina (nomeDisciplina,idCurso,cargaHoraria) values ('"+disciplina.getNomeDisciplina()+"','"+disciplina.getIdCurso()+"','"+disciplina.getCargaHoraria()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void deletar(int idSelect) throws SQLException {
		String sql = "delete from disciplina where idDisciplina='"+idSelect+"'";		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	//NECESSITA DE ALTERAÇÕES (FALTANDO COLUNAS NA QUERY)
	public void atualizar(int idSelect, Disciplina disciplina) throws SQLException {
		String sql = "update disciplina set nomeDisciplina='"+disciplina.getNomeDisciplina()+"',cargaHoraria='"+disciplina.getCargaHoraria()+"'where idDisciplina = '"+idSelect+"'";
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
			String sql = "select * from disciplina";
	        System.out.println(sql);		
	        List<Alunos> alunos = new ArrayList<Alunos>();
			try {
				PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
				ResultSet rs = prepareStatement.executeQuery();
				while(rs.next()) {
					System.out.println("\nID: "+rs.getInt("idDisciplina")+"|NOME: "+rs.getString("nomeDisciplina")+"\t|CARGA HORÁRIA: "+rs.getInt("cargaHoraria"));
					}

				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return alunos;
		}

}
