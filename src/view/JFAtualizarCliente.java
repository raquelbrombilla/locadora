package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

public class JFAtualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarCliente frame = new JFAtualizarCliente(id);
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
	public JFAtualizarCliente(int id) {
		setTitle("Atualizar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarCliente = new JLabel("Atualizar Cliente ");
		lblCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCadastrarCliente.setBounds(26, 24, 168, 22);
		contentPane.add(lblCadastrarCliente);
		
		JLabel lblNewLabel = new JLabel("ID do Cliente");
		lblNewLabel.setBounds(151, 57, 75, 14);
		contentPane.add(lblNewLabel);
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = cdao.read(id);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(225, 57, 46, 14);
		contentPane.add(lblId);	
		
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
		
		lblId.setText(String.valueOf(c.getIdCliente()));
		txtNome.setText(c.getNome());
		txtCpf.setText(c.getCpf());
		txtTelefone.setText(c.getTelefone());
		txtEndereco.setText(c.getEndereco());
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				
				c.setIdCliente(Integer.parseInt(lblId.getText()));
				c.setNome(txtNome.getText());
				c.setEndereco(txtEndereco.getText());
				c.setTelefone(txtTelefone.getText());
				c.setCpf(txtCpf.getText());
				
				dao.update(c);
				
			}
		});
		btnAlterar.setBounds(26, 242, 99, 23);
		contentPane.add(btnAlterar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(151, 242, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(267, 242, 89, 23);
		contentPane.add(btnExcluir);
		
	}

}
