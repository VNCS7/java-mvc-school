package controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Alunos;
import model.Curso;

public class CursoJdbcDAO {
	private Connection conn;

	public CursoJdbcDAO(Connection conn){
		this.conn = conn;
	}
	
	public void salvar(Curso curso) throws SQLException{
	String sql = "insert into curso (nome,cargaHoraria) values ('"+curso.getNome()+"','"+curso.getCargaHoraria()+"')";
	System.out.println(sql);
	PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
	prepareStatement.executeUpdate();
	prepareStatement.close();
}
	public void deletar(int idSelect) throws SQLException {
	String sql = "delete from curso where idCurso='"+idSelect+"'";		
	System.out.println(sql);
	PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
	prepareStatement.executeUpdate();
	prepareStatement.close();
}
	public void atualizar(int idSelect, Curso curso) throws SQLException {
	String sql = "update curso set nome='"+curso.getNome()+"',cargaHoraria='"+curso.getCargaHoraria()+"'where idCurso = '"+idSelect+"'";
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
		String sql = "select * from curso";
        System.out.println(sql);		
        List<Alunos> alunos = new ArrayList<Alunos>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				System.out.println("\nID: "+rs.getInt("idCurso")+"|NOME: "+rs.getString("nome")+"\t|CARGA HORÁRIA: "+rs.getInt("cargaHoraria"));
				}

			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}

}
