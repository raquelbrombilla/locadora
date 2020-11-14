package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFCadastrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarCliente frame = new JFCadastrarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFCadastrarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarCliente = new JLabel("Cadastrar Cliente ");
		lblCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCadastrarCliente.setBounds(26, 24, 168, 22);
		contentPane.add(lblCadastrarCliente);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(26, 72, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(26, 91, 461, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(26, 122, 46, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(26, 140, 220, 20);
		contentPane.add(txtCpf);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(267, 122, 152, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(267, 140, 220, 20);
		contentPane.add(txtTelefone);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(26, 171, 152, 14);
		contentPane.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(26, 191, 461, 20);
		contentPane.add(txtEndereco);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				
				c.setNome(txtNome.getText());
				c.setEndereco(txtEndereco.getText());
				c.setTelefone(txtTelefone.getText());
				c.setCpf(txtCpf.getText());
				
				dao.create(c);
				
			}
		});
		btnCadastrar.setBounds(26, 242, 99, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(151, 242, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(267, 242, 89, 23);
		contentPane.add(btnExcluir);
	}

}
