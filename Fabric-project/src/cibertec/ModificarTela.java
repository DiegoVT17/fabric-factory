package cibertec;

import java.awt.EventQueue;
import java.awt.Font;

import static cibertec.Main.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarTela extends JFrame implements ActionListener {

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
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarTela frame = new ModificarTela();
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
	public ModificarTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 600, 250);
		setTitle("Modificar Tela");
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
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		btnGrabar.setBounds(369, 99, 110, 32);
		contentPane.add(btnGrabar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == cboCod) {
			actionPerformedCboCod(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	

	protected void actionPerformedCboCod(ActionEvent e) {
		int codInde = getCodIndex();
		setContent(codInde);
		
	}
	
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		int codInde = getCodIndex();
		replaceContent(codInde);
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
	
	void replaceContent(int codIndex) {
		switch (codIndex) {
		case 0:
			descripcion0 = txtDesc.getText();
			material0 = txtMaterial.getText();
			ancho0 = Double.parseDouble(txtAncho.getText());
			peso0 = Double.parseDouble(txtPeso.getText());
			precio0 = Double.parseDouble(txtPrecio.getText());
			break;
		case 1:
			descripcion1 = txtDesc.getText();
			material1 = txtMaterial.getText();
			ancho1 = Double.parseDouble(txtAncho.getText());
			peso1 = Double.parseDouble(txtPeso.getText());
			precio1 = Double.parseDouble(txtPrecio.getText());
			break;
		case 2:
			descripcion2 = txtDesc.getText();
			material2 = txtMaterial.getText();
			ancho2 = Double.parseDouble(txtAncho.getText());
			peso2 = Double.parseDouble(txtPeso.getText());
			precio2 = Double.parseDouble(txtPrecio.getText());
			break;
		case 3:
			descripcion3 = txtDesc.getText();
			material3 = txtMaterial.getText();
			ancho3 = Double.parseDouble(txtAncho.getText());
			peso3 = Double.parseDouble(txtPeso.getText());
			precio3 = Double.parseDouble(txtPrecio.getText());
			break;
		default:
			descripcion4 = txtDesc.getText();
			material4 = txtMaterial.getText();
			ancho4 = Double.parseDouble(txtAncho.getText());
			peso4 = Double.parseDouble(txtPeso.getText());
			precio4 = Double.parseDouble(txtPrecio.getText());
			break;
		}
	}
	

}
