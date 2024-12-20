package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	public static String codigo0 = "TF0";
	public static String descripcion0 = "Pinstripe Suit 1";
	public static String material0 = "98%Algodón, 2%Elastán";
	public static double ancho0 = 160.0;
	public static double peso0 = 220.0;
	public static double precio0 = 9.4;

	public static String codigo1 = "TF1";
	public static String descripcion1 = "Gabardina Oslo 5";
	public static String material1 = "60%Algodón, 37%Poliéster";
	public static double ancho1 = 145.0;
	public static double peso1 = 300.0;
	public static double precio1 = 11.3;

	public static String codigo2 = "TF2";
	public static String descripcion2 = "Sarga 2";
	public static String material2 = "50%Poliéster, 50%Poliacril";
	public static double ancho2 = 145.0;
	public static double peso2 = 425.0;
	public static double precio2 = 31.8;

	public static String codigo3 = "TF3";
	public static String descripcion3 = "Leni 1";
	public static String material3 = "50%Poliéster, 50%Poliacril";
	public static double ancho3 = 145.0;
	public static double peso3 = 410.0;
	public static double precio3 = 37.2;
	
	public static String codigo4 = "TF4";
	public static String descripcion4 = "Laurent 3";
	public static String material4 = "100%Poliamida";
	public static double ancho4 = 150.0;
	public static double peso4 = 140.0;
	public static double precio4 = 18.8;
	
	public static double porcentaje1 = 4.0;
	public static double porcentaje2 = 5.5;
	public static double porcentaje3 = 7.0;
	public static double porcentaje4 = 8.5;
	
	public static int cantidadTotalOptima = 50;
	
	public static int cantidadObsequiable = 20;
	
	public static String obsequio = "USB";

	public static int numeroClienteSorpresa = 5;

	public static String premioSorpresa = "Una agenda";
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnManten;
	private JMenu mnVentas;
	private JMenu mnConfig;
	private JMenu mnAyuda;
	private JMenuItem mntmConTela;
	private JMenuItem mntmModTela;
	private JMenuItem mntmListTela;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenReport;
	private JMenuItem mntmConfDscto;
	private JMenuItem mntmConfigObs;
	private JMenuItem mntmVentOpt;
	private JMenuItem mntmConfPreSor;
	private JMenuItem mntmAcercaDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 700, 500);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnManten = new JMenu("Mantenimiento");
		menuBar.add(mnManten);
		
		mntmConTela = new JMenuItem("Consultar Tela");
		mntmConTela.addActionListener(this);
		mnManten.add(mntmConTela);
		
		mntmModTela = new JMenuItem("Modificar Tela");
		mnManten.add(mntmModTela);
		
		mntmListTela = new JMenuItem("Listar Tela");
		mnManten.add(mntmListTela);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mnVentas.add(mntmVender);
		
		mntmGenReport = new JMenuItem("Generar Reporte");
		mnVentas.add(mntmGenReport);
		
		mnConfig = new JMenu("Configuracion");
		menuBar.add(mnConfig);
		
		mntmConfDscto = new JMenuItem("Configurar Descuentos");
		mnConfig.add(mntmConfDscto);
		
		mntmConfigObs = new JMenuItem("Configurar Obsequio");
		mnConfig.add(mntmConfigObs);
		
		mntmVentOpt = new JMenuItem("Configurar cantidad optima de metros vendidos");
		mnConfig.add(mntmVentOpt);
		
		mntmConfPreSor = new JMenuItem("Configurar Premio Sorpresa");
		mnConfig.add(mntmConfPreSor);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercaDe = new JMenuItem("Acerca de Tienda");
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmConTela) {
			actionPerformedMntmConTela(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	
	
	protected void actionPerformedMntmConTela(ActionEvent e) {
		ConsultarTela ct = new ConsultarTela();
		ct.setLocationRelativeTo(this);
		ct.setVisible(true);
	}
}
