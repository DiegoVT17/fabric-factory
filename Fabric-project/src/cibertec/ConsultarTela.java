package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import static cibertec.Main.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarTela extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JComboBox<String> cboCod;
	private JLabel lblDesc;
	private JTextField txtDesc;
	private JLabel lblMaterial;
	private JTextField txtMaterial;
	private JLabel lblAncho;
	private JTextField txtAncho;
	private JLabel lblPeso;
	private JTextField txtPeso;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JButton btnCerrar;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarTela frame = new ConsultarTela();
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
	public ConsultarTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 600, 250);
		setTitle("Consultar Tela");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		lblCodigo.setBounds(10, 10, 104, 19);
		contentPane.add(lblCodigo);
		
		String [] codes = {"TF0", "TF1", "TF2", "TF3", "TF4"};
		cboCod = new JComboBox<>(codes);
		cboCod.addActionListener(this);
		cboCod.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		cboCod.setBounds(124, 9, 171, 21);
		contentPane.add(cboCod);
		
		lblDesc = new JLabel("Descripcion:");
		lblDesc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesc.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		lblDesc.setBounds(10, 42, 104, 19);
		contentPane.add(lblDesc);
		
		txtDesc = new JTextField();
		txtDesc.setEditable(false);
		txtDesc.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		txtDesc.setBounds(124, 40, 171, 19);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);
		
		lblMaterial = new JLabel("Material:");
		lblMaterial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaterial.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		lblMaterial.setBounds(10, 71, 104, 19);
		contentPane.add(lblMaterial);
		
		txtMaterial = new JTextField();
		txtMaterial.setEditable(false);
		txtMaterial.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		txtMaterial.setColumns(10);
		txtMaterial.setBounds(124, 69, 171, 19);
		contentPane.add(txtMaterial);
		
		lblAncho = new JLabel("Ancho:");
		lblAncho.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAncho.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		lblAncho.setBounds(10, 100, 104, 19);
		contentPane.add(lblAncho);
		
		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		txtAncho.setColumns(10);
		txtAncho.setBounds(124, 98, 171, 19);
		contentPane.add(txtAncho);
		
		lblPeso = new JLabel("Peso:");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		lblPeso.setBounds(10, 129, 104, 19);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setEditable(false);
		txtPeso.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		txtPeso.setColumns(10);
		txtPeso.setBounds(124, 129, 171, 19);
		contentPane.add(txtPeso);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		lblPrecio.setBounds(10, 158, 104, 19);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(124, 158, 171, 19);
		contentPane.add(txtPrecio);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		btnCerrar.setBounds(369, 41, 110, 32);
		contentPane.add(btnCerrar);
		
		cboCod.setSelectedIndex(0);
		txtDesc.setText(descripcion0);
		txtMaterial.setText(material0);
		txtAncho.setText(ancho0 + "");
		txtPeso.setText(peso0 + "");
		txtPrecio.setText(precio0 + "");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboCod) {
			actionPerformedCboCod(e);
		}
	}
	protected void actionPerformedCboCod(ActionEvent e) {
		int codIndex = getCodIndex();
		setContent(codIndex);
	}
	
	int getCodIndex() {
		return cboCod.getSelectedIndex();
	}
	
	void setContent(int codIndex) {
		switch (codIndex) {
		case 0:
			txtDesc.setText(descripcion0);
			txtMaterial.setText(material0);
			txtAncho.setText(ancho0 + "");
			txtPeso.setText(peso0 + "");
			txtPrecio.setText(precio0 + "");
			break;
		case 1:
			txtDesc.setText(descripcion1);
			txtMaterial.setText(material1);
			txtAncho.setText(ancho1 + "");
			txtPeso.setText(peso1 + "");
			txtPrecio.setText(precio1 + "");
			break;
		case 2:
			txtDesc.setText(descripcion2);
			txtMaterial.setText(material2);
			txtAncho.setText(ancho2 + "");
			txtPeso.setText(peso2 + "");
			txtPrecio.setText(precio2 + "");
			break;
		case 3:
			txtDesc.setText(descripcion3);
			txtMaterial.setText(material3);
			txtAncho.setText(ancho3 + "");
			txtPeso.setText(peso3 + "");
			txtPrecio.setText(precio3 + "");
			break;
		default:
			txtDesc.setText(descripcion4);
			txtMaterial.setText(material4);
			txtAncho.setText(ancho4 + "");
			txtPeso.setText(peso4 + "");
			txtPrecio.setText(precio4 + "");
			break;
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
