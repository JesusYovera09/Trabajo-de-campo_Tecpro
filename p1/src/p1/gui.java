package p1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglo.ArregloProductos;
import Clase.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtCod;
	private JTextField txtCat;
	private JTextField txtPrecio;
	private JTextField txtSto;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnBusCar;
	private JButton button_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
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
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(22, 24, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Categoria");
		lblNewLabel_1.setBounds(10, 55, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(223, 24, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Stock");
		lblNewLabel_3.setBounds(223, 55, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtCod = new JTextField();
		txtCod.setBounds(78, 21, 86, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		txtCat = new JTextField();
		txtCat.setBounds(78, 52, 86, 20);
		contentPane.add(txtCat);
		txtCat.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(274, 21, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtSto = new JTextField();
		txtSto.setBounds(274, 52, 86, 20);
		contentPane.add(txtSto);
		txtSto.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 141, 384, 109);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnNewButton = new JButton("Reportar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(0, 107, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(90, 107, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnBusCar = new JButton("Buscar");
		btnBusCar.addActionListener(this);
		btnBusCar.setBounds(180, 107, 89, 23);
		contentPane.add(btnBusCar);
		
		button_1 = new JButton("New button");
		button_1.setBounds(271, 107, 89, 23);
		contentPane.add(button_1);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(362, 107, 89, 23);
		contentPane.add(btnNewButton_2);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBusCar) {
			do_btnBusCar_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
	txtS.setText("");
	Listado();
	}
	int LeerCodigo() {
		return Integer.parseInt(txtCod.getText());
	}
	String LeerCategoria() {
		return txtCat.getText();
	}
	double LeerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	int LeerStock() {
		return Integer.parseInt(txtSto.getText());
	}
	void Imprimir (String s) {
		txtS.append(s+"\n");
	}
	ArregloProductos ap = new ArregloProductos();
	void Listado() {
	    Imprimir("Codigo\tCategoria\tPrecio\tStock");
	    for (int i = 0; i <ap.Tamaño() ; i++) {
	    	Imprimir(""+ap.Obtener(i).getCod()
	    			+"\t"+ap.Obtener(i).getCategoria()
	    			+"\t"+ap.Obtener(i).getPrecio()
	    			+"\t"+ap.Obtener(i).getStock());
	    			
	    	}
	}

	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
	    Producto p = ap.Buscar(LeerCodigo());
	    
	    if (p == null) { 
	        Producto nuevo = new Producto(
	            LeerCodigo(),
	            LeerCategoria(),
	            LeerPrecio(),
	            LeerStock()
	        );
	        ap.Adicionar(nuevo);
	        JOptionPane.showMessageDialog(this, "Producto agregado correctamente");
	    } else {
	        JOptionPane.showMessageDialog(this, "Ya existe un producto con ese código");
	    }
	}
	protected void do_btnBusCar_actionPerformed(ActionEvent e) {
		Producto p = ap.Buscar(LeerCodigo()); 

	    if (p != null) {
	        Imprimir("Codigo\tCategoria\tPrecio\tStock");
	        Imprimir("" + p.getCod() + "\t" 
	                     + p.getCategoria() + "\t" 
	                     + p.getPrecio() + "\t" 
	                     + p.getStock());
	        } else 
	        JOptionPane.showMessageDialog(this, "No existe el código");
	}
}
	

