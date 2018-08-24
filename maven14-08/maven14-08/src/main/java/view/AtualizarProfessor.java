package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import controller.ProfessorJdbcDAO;
import model.Alunos;
import model.Professor;

public class AtualizarProfessor extends JFrame {
	
	JTextField txtID = new JTextField();
	JLabel ID = new JLabel("ID: ");
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME: ");
	/// /// ///
	JLabel rg = new JLabel("RG:");
	JFormattedTextField txtRg = new JFormattedTextField();
	
	JLabel cpf = new JLabel("CPF:");
	JFormattedTextField txtCpf = new JFormattedTextField();
	
	JLabel cep = new JLabel("CEP:");
	JFormattedTextField txtCep = new JFormattedTextField();
	/// /// ///
	
	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("ENDEREÇO: ");
	
	JTextField txtBairro = new JTextField();
	JLabel bairro = new JLabel("BAIRRO: ");

	JTextField txtidCurso = new JTextField();
	JLabel idCurso = new JLabel("ID CURSO: ");	
	
	JTextField txtidDisciplina = new JTextField();
	JLabel idDisciplina = new JLabel("ID DISCIPLINA: ");	
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnVoltar = new JButton("Voltar");
	
	
	public AtualizarProfessor() {
	super("Atualizar Professor");
			try {
				MaskFormatter mrg = new MaskFormatter("##.###.###-#");
				mrg.setPlaceholderCharacter('0');
				mrg.install(txtRg);
				
				MaskFormatter mcpf = new MaskFormatter("###.###.###/##");
				mcpf.setPlaceholderCharacter('0');
				mcpf.install(txtCpf);
				
				MaskFormatter mcep = new MaskFormatter("#####-###");
				mcep.setPlaceholderCharacter('0');
				mcep.install(txtCep);

			}catch(Exception e) {
				e.printStackTrace();
			}
			
			Container paine = this.getContentPane();
			
			paine.add(ID);
			paine.add(txtID);	
			ID.setBounds(10, 15, 45, 30);
			txtID.setBounds(110, 15, 225, 30);
			
			paine.add(nome);
			paine.add(txtNome);	
			nome.setBounds(10, 50, 45, 30);
			txtNome.setBounds(110, 50, 225, 30);
			/// /// ///
			paine.add(rg);
			paine.add(txtRg);
			rg.setBounds(10,85,70,30);
			txtRg.setBounds(110, 85, 225, 30);
			/// /// ///
			paine.add(cpf);
			paine.add(txtCpf);
			cpf.setBounds(10,120,70,30);
			txtCpf.setBounds(110, 120, 225, 30);
			/// /// ///
			paine.add(end);
			paine.add(txtEnd);	
			end.setBounds(10, 155, 70, 30);
			txtEnd.setBounds(110, 155, 225, 30);	
			/// /// ///
			paine.add(bairro);
			paine.add(txtBairro);	
			bairro.setBounds(10, 190, 70, 30);
			txtBairro.setBounds(110, 190, 225, 30);
			/// /// ///
			paine.add(cep);
			paine.add(txtCep);
			cep.setBounds(10, 225, 70, 30);
			txtCep.setBounds(110, 225, 225, 30);
			/// /// ///
			paine.add(idCurso);
			paine.add(txtidCurso);	
			idCurso.setBounds(10, 260, 70, 30);
			txtidCurso.setBounds(110, 260, 225, 30);
			
			paine.add(idDisciplina);
			paine.add(txtidDisciplina);	
			idDisciplina.setBounds(10, 295, 100, 30);
			txtidDisciplina.setBounds(110, 295, 225, 30);
	
			paine.add(btnSalvar);
			btnSalvar.setBounds(50, 360, 130, 30);
			btnSalvar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try {
						//int idSelecionado = txtID
						int id = Integer.parseInt(txtID.getText());
						Professor professores = new Professor();
						professores.setNome(txtNome.getText());
						professores.setRg(txtRg.getText());
						professores.setCpf(txtCpf.getText());
						professores.setEndereco(txtEnd.getText());
						professores.setBairro(txtBairro.getText());
						professores.setCep(txtCep.getText());
						professores.setIdCurso(Integer.parseInt(txtidCurso.getText()));
						professores.setIdDisciplina(Integer.parseInt(txtidDisciplina.getText()));
						Connection connection = JdbUtil.getConnection();
						ProfessorJdbcDAO profJdbcDao = new ProfessorJdbcDAO (connection);
						
						profJdbcDao.atualizar(id,professores);
						JOptionPane.showMessageDialog(new JFrame(), "Cadastro Efetuado com Sucesso!");
										
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
			btnVoltar.setBounds(200, 360, 130, 30);
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					App voltarApp = new App();
					dispose();
				}
			});
			
			
			
			
			
			
			
			
			
			
			
			
			
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(380, 450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String args[]) {
		AtualizarProfessor attProfessor = new AtualizarProfessor();
		
	}
	

}
