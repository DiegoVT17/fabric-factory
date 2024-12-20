package cibertec;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static cibertec.Main.*;


public class ListarTela extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scpS;
	private JTextArea txtS;
	private JButton btnCerrar;
	private JButton btnListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarTela frame = new ListarTela();
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
	public ListarTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scpS = new JScrollPane();
		scpS.setBounds(10, 10, 516, 232);
		contentPane.add(scpS);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		scpS.setViewportView(txtS);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		btnCerrar.setBounds(140, 267, 112, 36);
		contentPane.add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setFont(new Font("Victor Mono SemiBold", Font.PLAIN, 13));
		btnListar.setBounds(299, 267, 112, 36);
		contentPane.add(btnListar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnListar(ActionEvent e) {
		txtS.setText("Listado de Telas\n\n");

		printList(codigo0, material0, descripcion0, ancho0, peso0, precio0);
		printList(codigo1, material1, descripcion1, ancho1, peso1, precio1);
		printList(codigo2, material2, descripcion2, ancho2, peso2, precio2);
		printList(codigo3, material3, descripcion3, ancho3, peso3, precio3);
		printList(codigo4, material4, descripcion4, ancho4, peso4, precio4);
		
	}
	
	void print(String cad) {
		txtS.append(cad + "\n");
	}
	
	void printList(String cod, String material, String descrip, double ancho, double peso, double precio) {
		print("Código \t\t: " + cod);
		print("Descripcion \t: " + descrip);
		print("Material \t: " + material);
		print("Ancho \t\t: " + ancho);
		print("Peso \t\t: " + peso);
		print("Precio \t\t: " + precio + "\n");
	}
}
