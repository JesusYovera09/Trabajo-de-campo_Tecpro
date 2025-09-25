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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class gui extends JFrame implements ActionListener, ItemListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JTextField txtCod;
    private JTextField txtPrecio;
    private JTextField txtSto;
    private JScrollPane scrollPane;
    private JTextArea txtS;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnBusCar;
    private JButton btnEliminar;
    private JButton btnModificar;

    // 🔹 Nuevo: txtCat ahora es JComboBox y declarado como atributo
    private JComboBox<String> txtCat;

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
        setBounds(100, 100, 628, 494);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Codigo");
        lblNewLabel.setBounds(40, 38, 46, 14);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Categoria");
        lblNewLabel_1.setBounds(40, 70, 61, 14);
        contentPane.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("Precio");
        lblNewLabel_2.setBounds(55, 98, 46, 14);
        contentPane.add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("Stock");
        lblNewLabel_3.setBounds(55, 135, 46, 14);
        contentPane.add(lblNewLabel_3);

        txtCod = new JTextField();
        txtCod.setBounds(120, 35, 86, 20);
        contentPane.add(txtCod);
        txtCod.setColumns(10);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(120, 95, 86, 20);
        contentPane.add(txtPrecio);
        txtPrecio.setColumns(10);

        txtSto = new JTextField();
        txtSto.setBounds(120, 132, 86, 20);
        contentPane.add(txtSto);
        txtSto.setColumns(10);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 234, 501, 210);
        contentPane.add(scrollPane);
        
                txtS = new JTextArea();
                scrollPane.setViewportView(txtS);

        btnNewButton = new JButton("Reportar");
        btnNewButton.addActionListener(this);
        btnNewButton.setBounds(39, 195, 89, 23);
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("Adicionar");
        btnNewButton_1.addActionListener(this);
        btnNewButton_1.setBounds(157, 195, 89, 23);
        contentPane.add(btnNewButton_1);

        btnBusCar = new JButton("Buscar");
        btnBusCar.addActionListener(this);
        btnBusCar.setBounds(256, 195, 89, 23);
        contentPane.add(btnBusCar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this);
        btnEliminar.setBounds(348, 195, 89, 23);
        contentPane.add(btnEliminar);

        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(this);
        btnModificar.setBounds(471, 195, 89, 23);
        contentPane.add(btnModificar);

        // 🔹 JComboBox ahora inicializado correctamente
        txtCat = new JComboBox<>();
        txtCat.addItemListener(this);
        txtCat.setModel(new DefaultComboBoxModel<>(new String[] {
            "Componentes", "Laptops", "Perifericos", "Redes", "Licencias"
        }));
        txtCat.setBounds(118, 66, 107, 22);
        contentPane.add(txtCat);
        
        lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_4.setIcon(new ImageIcon(gui.class.getResource("/imagen/componentes.png")));
        lblNewLabel_4.setBounds(282, 11, 254, 163);
        contentPane.add(lblNewLabel_4);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnModificar) {
            do_btnModificar_actionPerformed(e);
        }
        if (e.getSource() == btnEliminar) {
            do_btnEliminar_actionPerformed(e);
        }
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
        return txtCat.getSelectedItem().toString();
    }

    double LeerPrecio() {
        return Double.parseDouble(txtPrecio.getText());
    }

    int LeerStock() {
        return Integer.parseInt(txtSto.getText());
    }

    void Imprimir(String s) {
        txtS.append(s + "\n");
    }

    ArregloProductos ap = new ArregloProductos();
    private JLabel lblNewLabel_4;

    void Listado() {
        Imprimir("Codigo\tCategoria\tPrecio\tStock");
        for (int i = 0; i < ap.Tamaño(); i++) {
            Imprimir("" + ap.Obtener(i).getCod()
                    + "\t" + ap.Obtener(i).getCategoria()
                    + "\t" + ap.Obtener(i).getPrecio()
                    + "\t" + ap.Obtener(i).getStock());
        }
    }

    protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
    	    try {
    	        int codigo = Integer.parseInt(txtCod.getText());
    	        Producto p = ap.Buscar(codigo);

    	        if (p == null) {
    	            Producto nuevo = new Producto(
    	                codigo,
    	                txtCat.getSelectedItem().toString(),
    	                Double.parseDouble(txtPrecio.getText()),
    	                Integer.parseInt(txtSto.getText())
    	            );
    	            ap.Adicionar(nuevo);
    	            JOptionPane.showMessageDialog(this, "Producto agregado correctamente");
    	        } else {
    	            JOptionPane.showMessageDialog(this, "Ya existe un producto con ese código");
    	        }
    	    } catch (NumberFormatException ex) {
    	        JOptionPane.showMessageDialog(this, "Error: Asegúrate de ingresar valores numéricos válidos.");
    	    } catch (Exception ex) {
    	        JOptionPane.showMessageDialog(this, "Error: Algo salió mal. Verifica los valores ingresados.");
    	    }
    	}

    protected void do_btnBusCar_actionPerformed(ActionEvent e) {
        if (!txtCod.getText().trim().isEmpty()) {
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

        if (txtCat.getSelectedItem() != null) {
            ArregloProductos listacate = new ArregloProductos();
            listacate.limpiar();

            for (int i = 0; i < ap.Tamaño(); i++) {
                Producto p = ap.Obtener(i);
                if (p.getCategoria().equalsIgnoreCase(LeerCategoria().trim())) {
                    listacate.Adicionar(p);
                }
            }

            if (listacate.Tamaño() > 0) {
                Imprimir("Codigo\tCategoria\tPrecio\tStock");

                for (int l = 0; l < listacate.Tamaño(); l++) {
                    Producto pcod = listacate.Obtener(l);
                    Imprimir("" + pcod.getCod() + "\t" + pcod.getCategoria()
                            + "\t" + pcod.getPrecio() + "\t" + pcod.getStock());
                }
            } else {
                JOptionPane.showMessageDialog(this, "No existe la categoria");
            }
        }
    }

    protected void do_btnEliminar_actionPerformed(ActionEvent e) {
        Producto pro = ap.Buscar(LeerCodigo());
        if (pro != null) {
            ap.Eliminar(pro);
            JOptionPane.showMessageDialog(this, "Codigo eliminado");
        } else
            JOptionPane.showMessageDialog(this, "No existe el codigo");
    }

    protected void do_btnModificar_actionPerformed(ActionEvent e) {
        Producto p = ap.Buscar(LeerCodigo());
        if (p != null) {
            p.setCategoria(LeerCategoria());
            p.setStock(LeerStock());
            p.setPrecio(LeerPrecio());

            JOptionPane.showMessageDialog(this, "Producto modificado correctamente");

            txtCod.setText("");
            txtCat.setSelectedIndex(0); // 🔹 limpiar combo
            txtPrecio.setText("");
            txtSto.setText("");
        }
    }
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == txtCat) {
			do_txtCat_itemStateChanged(e);
		}
	}
	protected void do_txtCat_itemStateChanged(ItemEvent e) {
		    int posi = txtCat.getSelectedIndex();
		    switch(posi) {
		        case 0:
		            lblNewLabel_4.setIcon(new ImageIcon(gui.class.getResource("/imagen/componentes.png")));
		            break;
		        case 1:
		            lblNewLabel_4.setIcon(new ImageIcon(gui.class.getResource("/imagen/laptop2.png")));
		            break;
		        case 2:
		            lblNewLabel_4.setIcon(new ImageIcon(gui.class.getResource("/imagen/perifericos.png")));
		            break;
		        case 3:
		        	 lblNewLabel_4.setIcon(new ImageIcon(gui.class.getResource("/imagen/redes.png")));
		        	 break;
		        default:
		        	 lblNewLabel_4.setIcon(new ImageIcon(gui.class.getResource("/imagen/licencia2.png")));
		        	 break;

	}
}
}
