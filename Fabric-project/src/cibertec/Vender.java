package cibertec;

import java.awt.EventQueue;
import static cibertec.Main.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vender extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JComboBox<String> cboCodigo;
	private JLabel lblDescripcion;
	private JTextField txtDescripcion;
	private JLabel lblCantMet;
	private JTextField txtCantMet;
	private JButton btnVender;
	private JButton btnCerrar;
	private JScrollPane scpS;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender frame = new Vender();
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
	public Vender() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 600, 350);
		setTitle("Vender");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(38, 10, 145, 20);
		contentPane.add(lblCodigo);
		
		String[] codes = {"TF0", "TF1", "TF2", "TF3", "TF4"};
		cboCodigo = new JComboBox<>(codes);
		cboCodigo.addActionListener(this);
		cboCodigo.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		cboCodigo.setBounds(193, 10, 171, 21);
		contentPane.add(cboCodigo);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcion.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		lblDescripcion.setBounds(48, 40, 135, 20);
		contentPane.add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		txtDescripcion.setBounds(193, 41, 171, 19);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		lblCantMet = new JLabel("Cantidad de metros:");
		lblCantMet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantMet.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		lblCantMet.setBounds(38, 70, 145, 20);
		contentPane.add(lblCantMet);
		
		txtCantMet = new JTextField();
		txtCantMet.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		txtCantMet.setBounds(193, 70, 171, 19);
		contentPane.add(txtCantMet);
		txtCantMet.setColumns(10);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		btnVender.setBounds(427, 21, 105, 27);
		contentPane.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		btnCerrar.setBounds(427, 58, 105, 27);
		contentPane.add(btnCerrar);
		
		scpS = new JScrollPane();
		scpS.setBounds(10, 100, 566, 203);
		contentPane.add(scpS);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		scpS.setViewportView(txtS);
		
		cboCodigo.setSelectedIndex(0);
		txtDescripcion.setText(descripcion0);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboCodigo) {
			actionPerformedCboCodigo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedCboCodigo(ActionEvent e) {
		int codIndex = cboCodigo.getSelectedIndex();
		
		setDescText(codIndex);
	}
	
	protected void actionPerformedBtnVender(ActionEvent e) {
		int codIndex;
		double cantMet, partPay, salePay, totalPay;
		
		codIndex = getCodeIndex();
		cantMet = getCantMet();
		
		partPay = calcPartialPay(codIndex, cantMet);
		salePay = calcSaleOff(cantMet, partPay);
		totalPay = calcTotalPay(partPay, salePay);
		
		// cuenta la cantidad de clientes
		clienteCont++;
		
		// ejecutar contadores para reporte
		execCounters(codIndex, cantMet, totalPay);
		impTotalGen += totalPay;
		
		printVoucher(codIndex, cantMet, partPay, salePay, totalPay);
	}
	
	int getCodeIndex() {
		return cboCodigo.getSelectedIndex();
	}
	
	double getCantMet() {
		return Double.parseDouble(txtCantMet.getText());
	}
	
	double calcPartialPay(int codIndex, double cantMet) {
		switch (codIndex) {
		case 0:
			return cantMet * precio0;
		case 1:
			return cantMet * precio1;
		case 2:
			return cantMet * precio2;
		case 3:
			return cantMet * precio3;
		default:
			return cantMet * precio4;
		}
	}
	
	void execCounters(int codIndex, double cantMet, double totalPay) {
		switch (codIndex) {
		case 0:
			ventas0++;
			cantMetros0 += cantMet;
			impTotal0 += totalPay;
			if (cantMet > cantidadTotalOptima) {
				cantVentOpt0 += cantMet;
			}
			break;
		case 1:
			ventas1++;
			cantMetros1 += cantMet;
			impTotal1 += totalPay;
			if (cantMet > cantidadTotalOptima) {
				cantVentOpt1 += cantMet;
			}
			break;
		case 2:
			ventas2++;
			cantMetros2 += cantMet;
			impTotal2 += totalPay;
			if (cantMet > cantidadTotalOptima) {
				cantVentOpt2 += cantMet;
			}
			break;
		case 3:
			ventas3++;
			cantMetros3 += cantMet;
			impTotal3 += totalPay;
			if (cantMet > cantidadTotalOptima) {
				cantVentOpt3 += cantMet;
			}
			break;
		default:
			ventas4++;
			cantMetros4 += cantMet;
			impTotal4 += totalPay;
			if (cantMet > cantidadTotalOptima) {
				cantVentOpt4 += cantMet;
			}
			break;
		}
	}
	
	void setDescText(int codIndex) {
		switch (codIndex) {
		case 0:
			txtDescripcion.setText(material0);
			break;
		case 1:
			txtDescripcion.setText(material1);
			break;
		case 2:
			txtDescripcion.setText(material2);
			break;
		case 3:
			txtDescripcion.setText(material3);
			break;
		default:
			txtDescripcion.setText(material4);
			break;
		}
	}
	
	void printObsequio(double cantMet) {
		if (cantMet > cantidadObsequiable) print("Obsequio\t\t : " + obsequio);
	}
	
	void printPremioSorp() {
		if (clienteCont == 5) print("Premio sopresa \t\t: " + premioSorpresa);
	}
	
	double calcSaleOff(double cantMet, double partPay) {
		if (cantMet <= 5) return partPay * (porcentaje1 / 100);
		else if (cantMet <= 10) return partPay * (porcentaje2 / 100);
		else if (cantMet <= 15) return partPay * (porcentaje3 / 100);
		else return partPay * (porcentaje4 / 100);
	}
	
	double calcTotalPay(double partPay, double salePay) {
		return partPay - salePay;
	}
	
	void print(String cad) {
		txtS.append(cad + "\n");
	}
	
	void printVoucher(int codIndex, double cantMet, double partPay, double salePay, double totalPay) {
		txtS.setText("Boleta de Compra\n\n");
		switch (codIndex) {
		case 0:
			voucherInfo(codigo0, descripcion0, precio0, cantMet, partPay, salePay, totalPay);
			break;
		case 1:
			voucherInfo(codigo1, descripcion1, precio1, cantMet, partPay, salePay, totalPay);
			break;
		case 2:
			voucherInfo(codigo2, descripcion2, precio2, cantMet, partPay, salePay, totalPay);
			break;
		case 3:
			voucherInfo(codigo3, descripcion3, precio3, cantMet, partPay, salePay, totalPay);
			break;
		default:
			voucherInfo(codigo4, descripcion4, precio4, cantMet, partPay, salePay, totalPay);
			break;
		}
	}

	void voucherInfo(String cod, String desc, double precio, double cantMet, double partPay, double salePay, double totalPay) {
		print("Codigo de Tela \t\t: " + cod);
		print("Descripcion \t\t: " + desc);
		print("Precio de Tela \t\t: S/. " + precio);
		print("Cantidad de metros \t: " + cantMet);
		print("Importe de Compra \t: " + String.format("S/. %.2f", partPay));
		print("Importe Descuento \t: " + String.format("S/. %.2f", salePay));
		printObsequio(cantMet);
		printPremioSorp();
		print("\nImporte a Pagar \t\t: " + String.format("S/. %.2f", totalPay));
		
	}
	
}
