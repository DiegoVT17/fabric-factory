package cibertec;

import java.awt.EventQueue;
import static cibertec.Main.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GenerarReportes extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTipoRep;
	private JComboBox<String> cboTipRep;
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
					GenerarReportes frame = new GenerarReportes();
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
	public GenerarReportes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 550, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTipoRep = new JLabel("Tipo de reporte:");
		lblTipoRep.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoRep.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 12));
		lblTipoRep.setBounds(10, 10, 115, 22);
		contentPane.add(lblTipoRep);
		
		String[] reportes = {"Ventas por tela", "Telas con venta óptima", "Telas mayores al 75% del precio máximo", "Telas menores al 75% del precio máximo", "Promedios, máximos y mínimos"};
		cboTipRep = new JComboBox<>(reportes);
		cboTipRep.addActionListener(this);
	
		cboTipRep.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 11));
		cboTipRep.setBounds(124, 12, 264, 21);
		contentPane.add(cboTipRep);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		btnCerrar.setBounds(408, 11, 118, 21);
		contentPane.add(btnCerrar);
		
		scpS = new JScrollPane();
		scpS.setBounds(10, 51, 516, 282);
		contentPane.add(scpS);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		scpS.setViewportView(txtS);
	
		cboTipRep.setSelectedIndex(0);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboTipRep) {
			actionPerformedCboTipRep(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedCboTipRep(ActionEvent e) {
		int tipoRep;
		
		tipoRep = getRepIndex();
		printRep(tipoRep);
	}
	
	int getRepIndex() {
		return cboTipRep.getSelectedIndex();
	}
	
	void print(String cad) {
		txtS.append(cad + "\n");
	}
	
	void printRep(int tipRep) {
		switch (tipRep) {
		case 0:
			printRepTelas();
			break;
		case 1:
			printRepOpt();
		default:
			break;
		}
	}
	
	void printRepTelas() {
		txtS.setText("Ventas por Telas\n\n");
		
		telasInfo(codigo0, descripcion0, ventas0, cantMetros0, impTotal0);
		telasInfo(codigo1, descripcion1, ventas1, cantMetros1, impTotal1);
		telasInfo(codigo2, descripcion2, ventas2, cantMetros2, impTotal2);
		telasInfo(codigo3, descripcion3, ventas3, cantMetros3, impTotal3);
		telasInfo(codigo4, descripcion4, ventas4, cantMetros4, impTotal4);
		
		print("\nImporte total acumulado general : " + impTotalGen);
	}
	
	void telasInfo(String cod, String desc, double cantVent, double cantMetVend, double totalAc) {
		print("Codigo \t\t\t: " + cod);
		print("Descripcion \t\t\t: " + desc);
		print("Cantidad total de ventas \t: " + cantVent);
		print("Cantidad total de metros vendidos :" + cantMetVend);
		print("Importe total acumulado \t: " + totalAc + "\n");
	}
	
	void printRepOpt() {
		txtS.setText("TELAS CON VENTA OPTIMA\n\n");
		
		ventOptInfo(codigo0, descripcion0, cantVentOpt0);
		ventOptInfo(codigo1, descripcion1, cantVentOpt1);
		ventOptInfo(codigo2, descripcion2, cantVentOpt2);
		ventOptInfo(codigo3, descripcion3, cantVentOpt3);
		ventOptInfo(codigo4, descripcion4, cantVentOpt4);
	}
	
	void ventOptInfo(String cod, String desc, double ventOpt) {
		print("Codigo \t\t\t: " + cod);
		print("Descripcion \t\t: " + desc);
		print("Cantidad total de metros vendidos : " + ventOpt + "\n");
	}
	
}
