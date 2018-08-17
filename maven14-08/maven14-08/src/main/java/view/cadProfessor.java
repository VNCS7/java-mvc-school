package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AlunosJdbcDAO;
import controller.CursoJdbcDAO;
import controller.DisciplinaJdbcDAO;
import controller.JdbUtil;
import controller.ProfessorJdbcDAO;
import model.Alunos;
import model.Curso;
import model.Disciplina;
import model.Professor;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class cadProfessor extends JFrame {
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
	
	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("ENDEREÇO: ");
	
	JTextField txtBairro = new JTextField();
	JLabel bairro = new JLabel("BAIRRO: ");

	JTextField txtidCurso = new JTextField();
	JLabel idCurso = new JLabel("ID CURSO: ");	
	
	JTextField txtidDisciplina = new JTextField();
	JLabel idDisciplina = new JLabel("ID DISCIPLINA: ");	
	
	JButton btnSalvar = new JButton("Salvar");

	public cadProfessor(){
		super("Cadastro de Professor");
		
		Container paine = this.getContentPane();
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(90, 15, 225, 30);
		
		paine.add(end);
		paine.add(txtEnd);	
		end.setBounds(10, 50, 70, 30);
		txtEnd.setBounds(90, 50, 225, 30);	
		
		paine.add(bairro);
		paine.add(txtBairro);	
		bairro.setBounds(10, 85, 70, 30);
		txtBairro.setBounds(90, 85, 225, 30);
		
		paine.add(idCurso);
		paine.add(txtidCurso);	
		idCurso.setBounds(10, 120, 70, 30);
		txtidCurso.setBounds(90, 120, 225, 30);
		
		paine.add(idDisciplina);
		paine.add(txtidDisciplina);
		idDisciplina.setBounds(10,155,70,30);
		txtidDisciplina.setBounds(90,155,225,30);

		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Professor prof = new Professor();
				prof.setNome(txtNome.getText());
				prof.setEndereco(txtEnd.getText());
				prof.setBairro(txtBairro.getText());
				prof.setIdCurso(Integer.parseInt(txtidCurso.getText()));
				prof.setIdDisciplina(Integer.parseInt(txtidDisciplina.getText()));
				
				Connection connection = JdbUtil.getConnection();
				ProfessorJdbcDAO profJdbcDao = new ProfessorJdbcDAO(connection);
				profJdbcDao.salvar(prof);
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(600, 330);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
    public static void main( String[] args )
    {
    	cadProfessor cadastrarProfessor = new cadProfessor();
    }

}

