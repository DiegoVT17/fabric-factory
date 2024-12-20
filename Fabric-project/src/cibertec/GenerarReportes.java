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
	}
	protected void actionPerformedCboTipRep(ActionEvent e) {
	}
}
