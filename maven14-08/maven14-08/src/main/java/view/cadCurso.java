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
import controller.JdbUtil;
import model.Alunos;
import model.Curso;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class cadCurso extends JFrame {
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
	
	JTextField txtCargaHoraria = new JTextField();
	JLabel cargaHoraria = new JLabel("CARGA HORARIA: ");
	
	JButton btnSalvar = new JButton("Salvar");
	
	public cadCurso(){
		super("Cadastro de Curso");
		
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
				Curso cursos = new Curso();
				//Curso.setNome(txtNome.getText());
				cursos.setNome(txtNome.getText());
				cursos.setCargaHoraria(Integer.parseInt(txtCargaHoraria.getText()));
				Connection connection = JdbUtil.getConnection();
				CursoJdbcDAO cursosJdbcDao = new CursoJdbcDAO(connection);
				cursosJdbcDao.salvar(cursos);
				
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
    	cadCurso cadastrarCurso = new cadCurso();
    }

}

