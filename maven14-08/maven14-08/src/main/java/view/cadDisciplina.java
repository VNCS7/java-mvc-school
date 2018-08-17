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
import model.Alunos;
import model.Curso;
import model.Disciplina;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class cadDisciplina extends JFrame {
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
	
	JTextField txtCargaHoraria = new JTextField();
	JLabel cargaHoraria = new JLabel("CARGA HORARIA: ");
	
	JButton btnSalvar = new JButton("Salvar");
	
	public cadDisciplina(){
		super("Cadastro de Disciplina");
		
		Container paine = this.getContentPane();
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(90, 15, 225, 30);
		
		paine.add(cargaHoraria);
		paine.add(txtCargaHoraria);	
		cargaHoraria.setBounds(10, 50, 70, 30);
		txtCargaHoraria.setBounds(90, 50, 225, 30);	
		

		paine.add(btnSalvar);
		btnSalvar.setBounds(100, 100, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Disciplina disciplinas = new Disciplina();
				//Curso.setNome(txtNome.getText());
				disciplinas.setNomeDisciplina(txtNome.getText());
				disciplinas.setCargaHoraria(Integer.parseInt(txtCargaHoraria.getText()));
				Connection connection = JdbUtil.getConnection();
				DisciplinaJdbcDAO disciplinaJdbcDao = new DisciplinaJdbcDAO(connection);
				disciplinaJdbcDao.salvar(disciplinas);
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(360, 180);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
    public static void main( String[] args )
    {
    	cadDisciplina cadastrarDisciplina = new cadDisciplina();
    }

}

