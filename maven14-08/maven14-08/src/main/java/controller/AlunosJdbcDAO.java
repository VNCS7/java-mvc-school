package controller;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Alunos;

public class AlunosJdbcDAO {
	private Connection conn;

	public AlunosJdbcDAO(Connection conn){
		this.conn = conn;
	}

	public void salvar(Alunos c) throws SQLException {
		String sql = "insert into aluno (nome,rg,cpf,endereco,bairro,cep,idCurso) values ('"+c.getNome()+"','"+c.getRg()+"','"+c.getCpf()+"','"+c.getEndereco()+"','"+c.getBairro()+"','"+c.getCep()+"','"+c.getIdCurso()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	public void deletar(int idSelect) throws SQLException {
		String sql = "delete from aluno where id='"+idSelect+"'";		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	//NECESSITA DE ALTERAÇÕES (FALTANDO COLUNAS NA QUERY)
	public void atualizar(int idSelect, Alunos c) throws SQLException {
		String sql = "update alunos set nome='"+c.getNome()+"',endereco='"+c.getEndereco()+"',bairro='"+c.getBairro()+"',idCurso='"+c.getIdCurso()+"'where id = '"+idSelect+"'";
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
		String sql = "select * from aluno";
        System.out.println(sql);		
        List<Alunos> alunos = new ArrayList<Alunos>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				System.out.println("\nID: "+rs.getInt("idAluno")+"|NOME: "+rs.getString("nome")+"\t|ENDEREÇO: "+rs.getString("endereco")+"\t|BAIRRO: "+rs.getString("bairro")+"|\t|ID CURSO: "+rs.getInt("idCurso"));
				}

			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}

}
