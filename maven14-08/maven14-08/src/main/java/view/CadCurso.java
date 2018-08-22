package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import controller.AlunosJdbcDAO;
import controller.CursoJdbcDAO;
import controller.JdbUtil;
import model.Alunos;
import model.Curso;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class CadCurso extends JFrame {
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
	
	JTextField txtCargaHoraria = new JTextField();
	JLabel cargaHoraria = new JLabel("CARGA HORARIA: ");
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnVoltar = new JButton("Voltar");
	
	public CadCurso(){
		super("Cadastro de Curso");
		
		Container paine = this.getContentPane();
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(125, 15, 225, 30);
		
		paine.add(cargaHoraria);
		paine.add(txtCargaHoraria);	
		cargaHoraria.setBounds(10, 50, 110, 30);
		txtCargaHoraria.setBounds(125, 50, 225, 30);	

		

		paine.add(btnSalvar);
		btnSalvar.setBounds(50, 100, 130, 30);
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
				
				for (int i=0; i < getContentPane().getComponentCount(); i++) {
					Component c = getContentPane().getComponent(i);
					
					if(c instanceof JTextField) {
						JTextField field = (JTextField) c;
						field.setText("");
					}	
				}
				
				
				
				JOptionPane.showMessageDialog(new JFrame(), "Cadastro Efetuado com Sucesso!");
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(new JFrame(), "ERRO! Cadastro não realizado");
				}
				
			}
		});
		
		paine.add(btnVoltar);
		btnVoltar.setBounds(200, 100, 130, 30);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App voltarApp = new App();
				dispose();
			}
		});
	
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(360, 180);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
    public static void main( String[] args )
    {
    	CadCurso cadastrarCurso = new CadCurso();
    }

}

