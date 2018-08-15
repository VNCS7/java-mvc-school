package view;

import java.sql.Connection;
import model.*;
import controller.*;

import controller.JdbUtil;



public class Exec {
	public static void main(String args[]){
		
		Alunos alunos 			= new Alunos();
		Curso cursos 			= new Curso();
		Disciplina disciplina 	= new Disciplina();
		Professor prof 			= new Professor();
		
		try{
				alunos.setNome("Vinícius Alves");
				alunos.setEndereco("R. Milagre dos Peixes");
				alunos.setBairro("Castro Alves");
				alunos.setIdCurso(2);		
				
				cursos.setNome("Desnevolvimento de Sistemas");
				cursos.setCargaHoraria(1000);
				
				disciplina.setNomeDisciplina("Programação de Computadores II");
				disciplina.setCargaHoraria(5);
								
				prof.setNome("Jeferson");
				prof.setEndereco("Av. Águia de Haia");
				prof.setBairro("Cidade A.E Carvalho");
				prof.setIdCurso(2);
				prof.setIdDisciplina(1);
				
				
				Connection connection = JdbUtil.getConnection();
				
				AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
				CursoJdbcDAO cursosJdbcDao = new CursoJdbcDAO(connection);
				DisciplinaJdbcDAO disciplinaJdbcDao = new DisciplinaJdbcDAO(connection);
				ProfessorJdbcDAO professorJdbcDao = new ProfessorJdbcDAO(connection);
				
				//alunosJdbcDao.salvar(alunos);
				//alunosJdbcDao.atualizar(2, alunos);
				//alunosJdbcDao.deletar(2);
				//alunosJdbcDao.listar();
				
				cursosJdbcDao.salvar(cursos);
				//cursosJdbcDao.atualizar(idSelect, curso);
				//cursosJdbcDao.deletar(idSelect);
				//cursosJdbcDao.listar();
				
				disciplinaJdbcDao.salvar(disciplina);
				//disciplinaJdbcDao.atualizar(idSelect, disciplina);
				//disciplinaJdbcDao.deletar(idSelect);
				//disciplinaJdbcDao.listar();
				
				professorJdbcDao.salvar(prof);
				//professorJdbcDao.atualizar(1, prof);
				//professorJdbcDao.listar();
				
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
