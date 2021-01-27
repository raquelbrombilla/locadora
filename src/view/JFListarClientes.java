package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class JFListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable jtClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarClientes frame = new JFListarClientes();
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
	public JFListarClientes() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				readJTable();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setTitle("Listar Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 24, 151, 21);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 549, 227);
		contentPane.add(scrollPane);
		
		jtClientes = new JTable();
		jtClientes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"idCliente", "Nome", "CPF", "Telefone"
			}
		));
		scrollPane.setViewportView(jtClientes);
		
		JButton btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastrarCliente cc = new JFCadastrarCliente();
				cc.setVisible(true);
			}
		});
		btnCadastrar.setBounds(10, 335, 138, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Cliente");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verificar se há cliente selecionado
				
				if(jtClientes.getSelectedRow() != -1) {
					JFAtualizarCliente ac = new JFAtualizarCliente((int)jtClientes.getValueAt(jtClientes.getSelectedRow(), 0));
					ac.setVisible(true);
						
				} else{
					JOptionPane.showMessageDialog(null, "Selecione um cliente!");
				}
				readJTable();
			}
		});
		btnAlterar.setBounds(158, 335, 127, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir Cliente");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(jtClientes.getSelectedColumn() != -1) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente selecionado?","Exclusão", JOptionPane.YES_NO_OPTION);
					
					if(opcao == 0) {
						ClienteDAO dao = new ClienteDAO();
						Cliente c = new Cliente();
						c.setIdCliente((int) jtClientes.getValueAt(jtClientes.getSelectedRow(), 0));
						dao.delete(c);
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente!");					
				}
				readJTable();	
			}
		});
		btnExcluir.setBounds(295, 335, 127, 23);
		contentPane.add(btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(432, 335, 127, 23);
		contentPane.add(btnCancelar);
		
		readJTable();
	}

	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtClientes.getModel();
		modelo.setNumRows(0);
		ClienteDAO cdao = new ClienteDAO();
		
		for(Cliente c : cdao.read()) {
			modelo.addRow(new Object[] {
					c.getIdCliente(),
					c.getNome(),
					c.getCpf(),
					c.getTelefone()
					
			});	
				
		}
	}
}
