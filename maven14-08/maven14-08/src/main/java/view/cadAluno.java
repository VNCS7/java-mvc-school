package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import com.google.protobuf.TextFormat.ParseException;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class cadAluno extends JFrame {
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
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnVoltar = new JButton("Voltar");


	public cadAluno(){
		super("Cadastro de Alunos");
		
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
		txtNome.setBounds(90, 15, 225, 30);
		/// /// ///
		paine.add(rg);
		paine.add(txtRg);
		rg.setBounds(10,50,70,30);
		txtRg.setBounds(90, 50, 225, 30);
		/// /// ///
		paine.add(cpf);
		paine.add(txtCpf);
		cpf.setBounds(10,85,70,30);
		txtCpf.setBounds(90, 85, 225, 30);
		/// /// ///
		paine.add(end);
		paine.add(txtEnd);	
		end.setBounds(10, 120, 70, 30);
		txtEnd.setBounds(90, 120, 225, 30);	
		/// /// ///
		paine.add(bairro);
		paine.add(txtBairro);	
		bairro.setBounds(10, 155, 70, 30);
		txtBairro.setBounds(90, 155, 225, 30);
		/// /// ///
		paine.add(cep);
		paine.add(txtCep);
		cep.setBounds(10, 190, 70, 30);
		txtCep.setBounds(90, 190, 225, 30);
		/// /// ///
		paine.add(idCurso);
		paine.add(txtidCurso);	
		idCurso.setBounds(10, 225, 70, 30);
		txtidCurso.setBounds(90, 225, 225, 30);

		paine.add(btnSalvar);
		btnSalvar.setBounds(20, 280, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Alunos alunos = new Alunos();
				alunos.setNome(txtNome.getText());
				alunos.setRg(txtRg.getText());
				alunos.setCpf(txtCpf.getText());
				alunos.setEndereco(txtEnd.getText());
				alunos.setBairro(txtBairro.getText());
				alunos.setCep(txtCep.getText());
				alunos.setIdCurso(Integer.parseInt(txtidCurso.getText()));
				
				Connection connection = JdbUtil.getConnection();
				AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
				
				alunosJdbcDao.salvar(alunos);
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
		btnVoltar.setBounds(170, 280, 130, 30);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App voltarApp = new App();
				dispose();
			}
		});
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(340, 360);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
    public static void main( String[] args )
    {
    	cadAluno app = new cadAluno();
    }

}