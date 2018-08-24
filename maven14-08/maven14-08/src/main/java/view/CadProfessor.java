package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JOptionPane;

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
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class CadProfessor extends JFrame {
		/// /// ///
		JLabel rg = new JLabel("RG:");
		JFormattedTextField txtRg = new JFormattedTextField();
		
		JLabel cpf = new JLabel("CPF:");
		JFormattedTextField txtCpf = new JFormattedTextField();
		
		JLabel cep = new JLabel("CEP:");
		JFormattedTextField txtCep = new JFormattedTextField();
		/// /// ///
		
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
	JButton btnVoltar = new JButton("Voltar");
	
	public CadProfessor(){
		super("Cadastro de Professor");
		
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
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(120, 15, 225, 30);
		/// /// ///
		paine.add(rg);
		paine.add(txtRg);
		rg.setBounds(10,50,70,30);
		txtRg.setBounds(120, 50, 225, 30);
		/// /// ///
		paine.add(cpf);
		paine.add(txtCpf);
		cpf.setBounds(10,85,70,30);
		txtCpf.setBounds(120, 85, 225, 30);
		/// /// ///
		paine.add(end);
		paine.add(txtEnd);	
		end.setBounds(10, 120, 70, 30);
		txtEnd.setBounds(120, 120, 225, 30);	
		/// /// ///
		paine.add(bairro);
		paine.add(txtBairro);	
		bairro.setBounds(10, 155, 70, 30);
		txtBairro.setBounds(120, 155, 225, 30);
		/// /// ///
		paine.add(cep);
		paine.add(txtCep);
		cep.setBounds(10, 190, 70, 30);
		txtCep.setBounds(120, 190, 225, 30);
		/// /// ///
		paine.add(idCurso);
		paine.add(txtidCurso);	
		idCurso.setBounds(10, 225, 70, 30);
		txtidCurso.setBounds(120, 225, 225, 30);
			
		paine.add(idDisciplina);
		paine.add(txtidDisciplina);
		idDisciplina.setBounds(10,260,100,30);
		txtidDisciplina.setBounds(120,260,225,30);

		paine.add(btnSalvar);
		btnSalvar.setBounds(30, 320, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Professor prof = new Professor();
				prof.setNome(txtNome.getText());
				prof.setRg(txtRg.getText());
				prof.setCpf(txtCpf.getText());
				prof.setEndereco(txtEnd.getText());
				prof.setBairro(txtBairro.getText());
				prof.setCep(txtCep.getText());
				prof.setIdCurso(Integer.parseInt(txtidCurso.getText()));
				prof.setIdDisciplina(Integer.parseInt(txtidDisciplina.getText()));
				
				Connection connection = JdbUtil.getConnection();
				ProfessorJdbcDAO profJdbcDao = new ProfessorJdbcDAO(connection);
				
				for (int i=0; i < getContentPane().getComponentCount(); i++) {
					Component c = getContentPane().getComponent(i);
					
					if(c instanceof JTextField) {
						JTextField field = (JTextField) c;
						field.setText("");
					}	
				}
				
				
				
				profJdbcDao.salvar(prof);
				JOptionPane.showMessageDialog(new JFrame(), "Cadastro Efetuado com Sucesso!");
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(new JFrame(), "ERRO! Cadastro não realizado");
				}
				
			}
		});
		
		paine.add(btnVoltar);
		btnVoltar.setBounds(190, 320, 130, 30);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App voltarApp = new App();
				dispose();
			}
		});
		
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(380, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
    public static void main( String[] args )
    {
    	CadProfessor cadastrarProfessor = new CadProfessor();
    }

}

