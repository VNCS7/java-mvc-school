package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.CursoJdbcDAO;
import controller.DisciplinaJdbcDAO;
import controller.JdbUtil;
import model.Curso;
import model.Disciplina;

public class AtualizarDisciplina extends JFrame{
	JTextField txtID = new JTextField();
	JLabel ID = new JLabel("ID: ");
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
	
	JTextField txtCargaHoraria = new JTextField();
	JLabel cargaHoraria = new JLabel("CARGA HORARIA: ");
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnVoltar = new JButton("Voltar");
	public AtualizarDisciplina() {
		super("Atualizar Disciplina");
		
Container paine = this.getContentPane();
		
		paine.add(ID);
		paine.add(txtID);	
		ID.setBounds(10, 15, 45, 30);
		txtID.setBounds(130, 15, 225, 30);
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 50, 45, 30);
		txtNome.setBounds(130, 50, 225, 30);
	
		paine.add(cargaHoraria);
		paine.add(txtCargaHoraria);	
		cargaHoraria.setBounds(10, 85, 110, 30);
		txtCargaHoraria.setBounds(130, 85, 225, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(50, 130, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {					
					Connection connection = JdbUtil.getConnection();
					DisciplinaJdbcDAO disciplinasJdbcDao = new DisciplinaJdbcDAO(connection);
					Disciplina disciplinas = new Disciplina();
					
					disciplinas.setNomeDisciplina(txtNome.getText());
					disciplinas.setCargaHoraria(Integer.parseInt(txtCargaHoraria.getText()));
					
					int id = Integer.parseInt(txtID.getText());
					disciplinasJdbcDao.atualizar(id, disciplinas);
				
					JOptionPane.showMessageDialog(new JFrame(), "Atualização Efetuado com Sucesso!");
									
					for (int i=0; i < getContentPane().getComponentCount(); i++) {
						Component c = getContentPane().getComponent(i);
						
						if(c instanceof JTextField) {
							JTextField field = (JTextField) c;
							field.setText("");
						}	
					}
					
					}catch(Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(new JFrame(), "ERRO! Cadastro não realizado");
					}
			}
		});
		
		
		paine.add(btnVoltar);
		btnVoltar.setBounds(200, 130, 130, 30);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App voltarApp = new App();
				dispose();
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(380, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String args[]) {
		AtualizarDisciplina attDis = new AtualizarDisciplina();
	}

}
