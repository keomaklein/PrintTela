import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

public class Principal implements NativeMouseInputListener{

	private JFrame frame;
	private JButton btn_printar;
	private JtextFieldSomenteNumeros txf_posicao_X;
	private JtextFieldSomenteNumeros txf_posicao_Y;
	private JtextFieldSomenteNumeros txf_tamanho_X;
	private JtextFieldSomenteNumeros txf_tamanho_Y;
	private JtextFieldSomenteNumeros txf_tempo_repeticao;
	private JtextFieldSomenteNumeros txf_quantidade_print;
	private JRadioButton rbt_mouse;
	private JRadioButton rbt_edit_posicao;
	private static boolean CHECK = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
					window.capturarMouse();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal () {
		try {
			initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 244, 332);
		frame.getContentPane().setLayout(null);
	
		
		btn_printar = new JButton("Printar");
		btn_printar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!(txf_tempo_repeticao.getText().equals("") || txf_quantidade_print.getText().equals(""))){		
					frame.setExtendedState(JFrame.ICONIFIED);
	//				Thread t = new Thread(new Printador(0,0,300,300,10,10,"teste", "C:\\Users\\keoma\\Documents\\Pasta de Testes\\"));
	//				t.start();
					try {
						Thread.sleep(1000 * Integer.parseInt(txf_tempo_repeticao.getText()) * Integer.parseInt(txf_quantidade_print.getText()));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					frame.setExtendedState(JFrame.NORMAL);
				}
			}
		});
		btn_printar.setBounds(10, 269, 218, 23);
		frame.getContentPane().add(btn_printar);
		
        txf_posicao_X = new JtextFieldSomenteNumeros();
        txf_posicao_X.setMaximoCaracteres(4);
        txf_posicao_X.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		txf_posicao_X.selectAll();
        	}
        });
		txf_posicao_X.setHorizontalAlignment(SwingConstants.RIGHT);
		txf_posicao_X.setText("");
		txf_posicao_X.setEnabled(false);
		txf_posicao_X.setToolTipText("Posi\u00E7\u00E3o inicial em X");
		txf_posicao_X.setBounds(10, 72, 39, 20);
		frame.getContentPane().add(txf_posicao_X);
		txf_posicao_X.setColumns(10);

		

		txf_posicao_Y = new JtextFieldSomenteNumeros();
		txf_posicao_Y.setMaximoCaracteres(4);
		txf_posicao_Y.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txf_posicao_X.selectAll();
			}
		});
		txf_posicao_Y.setHorizontalAlignment(SwingConstants.RIGHT);
		txf_posicao_Y.setText("");
		txf_posicao_Y.setEnabled(false);
		txf_posicao_Y.setToolTipText("Posi\u00E7\u00E3o inicial em Y");
		txf_posicao_Y.setColumns(10);
		txf_posicao_Y.setBounds(10, 103, 39, 20);
		frame.getContentPane().add(txf_posicao_Y);
		
		txf_tamanho_X = new JtextFieldSomenteNumeros();
		txf_tamanho_X.setMaximoCaracteres(4);
		txf_tamanho_X.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txf_tamanho_X.selectAll();
			}
		});
		txf_tamanho_X.setHorizontalAlignment(SwingConstants.RIGHT);
		txf_tamanho_X.setText("");
		txf_tamanho_X.setEnabled(false);
		txf_tamanho_X.setToolTipText("Largura");
		txf_tamanho_X.setColumns(10);
		txf_tamanho_X.setBounds(10, 134, 39, 20);
		frame.getContentPane().add(txf_tamanho_X);
		
		txf_tamanho_Y = new JtextFieldSomenteNumeros();
		txf_tamanho_Y.setMaximoCaracteres(4);
		txf_tamanho_Y.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txf_tamanho_Y.selectAll();
			}
		});
		txf_tamanho_Y.setHorizontalAlignment(SwingConstants.RIGHT);
		txf_tamanho_Y.setText("");
		txf_tamanho_Y.setEnabled(false);
		txf_tamanho_Y.setToolTipText("Altura");
		txf_tamanho_Y.setColumns(10);
		txf_tamanho_Y.setBounds(10, 165, 39, 20);
		frame.getContentPane().add(txf_tamanho_Y);
		
		txf_tempo_repeticao = new JtextFieldSomenteNumeros();
		txf_tempo_repeticao.setMaximoCaracteres(4);
		txf_tempo_repeticao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txf_tempo_repeticao.selectAll();
			}
		});
		txf_tempo_repeticao.setHorizontalAlignment(SwingConstants.RIGHT);
		txf_tempo_repeticao.setText("");
		txf_tempo_repeticao.setToolTipText("Tempo de repeti\u00E7\u00F5es");
		txf_tempo_repeticao.setColumns(10);
		txf_tempo_repeticao.setBounds(10, 196, 39, 20);
		frame.getContentPane().add(txf_tempo_repeticao);
		
		txf_quantidade_print = new JtextFieldSomenteNumeros();
		txf_quantidade_print.setMaximoCaracteres(4);
		txf_quantidade_print.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txf_quantidade_print.selectAll();
			}
		});
		txf_quantidade_print.setHorizontalAlignment(SwingConstants.RIGHT);
		txf_quantidade_print.setText("");
		txf_quantidade_print.setToolTipText("Quantidade de prints");
		txf_quantidade_print.setColumns(10);
		txf_quantidade_print.setBounds(10, 226, 39, 20);
		frame.getContentPane().add(txf_quantidade_print);
		
		JLabel lblInicio = new JLabel("Ponto de inicio em X");
		lblInicio.setBounds(59, 75, 131, 14);
		frame.getContentPane().add(lblInicio);
		
		JLabel lblPontoDeInicio = new JLabel("Ponto de inicio em Y");
		lblPontoDeInicio.setBounds(59, 106, 131, 14);
		frame.getContentPane().add(lblPontoDeInicio);
		
		JLabel lblAlturaDaImagem = new JLabel("Altura da imagem");
		lblAlturaDaImagem.setBounds(59, 168, 132, 14);
		frame.getContentPane().add(lblAlturaDaImagem);
		
		JLabel lblTempoDeRepeties = new JLabel("Tempo do print (Segundos)");
		lblTempoDeRepeties.setBounds(59, 199, 172, 14);
		frame.getContentPane().add(lblTempoDeRepeties);
		
		JLabel lblQuantidadeDeRepeties = new JLabel("Quantidade de repeti\u00E7\u00F5es");
		lblQuantidadeDeRepeties.setBounds(59, 229, 170, 14);
		frame.getContentPane().add(lblQuantidadeDeRepeties);
		
		JLabel lblLarguraDaImagem = new JLabel("Largura da imagem");
		lblLarguraDaImagem.setBounds(59, 137, 131, 14);
		frame.getContentPane().add(lblLarguraDaImagem);
		
		rbt_mouse = new JRadioButton("Usar o mouse");
		rbt_mouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterarCheck();	
			}
		});
		rbt_mouse.setSelected(true);
		rbt_mouse.setToolTipText("Usar o mouse para definir a area do print");
		rbt_mouse.setBounds(10, 7, 180, 23);
		frame.getContentPane().add(rbt_mouse);
		
		rbt_edit_posicao = new JRadioButton("Editar posi\u00E7\u00E3o da imagem");
		rbt_edit_posicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarCheck();
			}
		});
		rbt_edit_posicao.setBounds(10, 33, 180, 23);
		frame.getContentPane().add(rbt_edit_posicao);
	}
	
	
	private void alterarCheck(){
		CHECK = !CHECK;
		rbt_edit_posicao.setSelected(CHECK);
		rbt_mouse.setSelected(!CHECK);
		
		habilitarEdit(rbt_edit_posicao.isSelected());
		
	}
	
	private void habilitarEdit(boolean condicao){
		txf_posicao_X.setEnabled(condicao);
		txf_posicao_Y.setEnabled(condicao);
		txf_tamanho_X.setEnabled(condicao);
		txf_tamanho_Y.setEnabled(condicao);
	}
	
	private void capturarMouse() {
		try {
			GlobalScreen.registerNativeHook();
			
		} catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());
			System.exit(1);
		}
//		CapturaMouse3 captureMouse = new CapturaMouse3();
		GlobalScreen.addNativeMouseListener(this);
		GlobalScreen.addNativeMouseMotionListener(this);
	}

	
	public void nativeMouseClicked(NativeMouseEvent e) {
	
		//System.out.println("Mosue Clicked: " + e.getClickCount());
	}

	public void nativeMousePressed(NativeMouseEvent e) {
		txf_posicao_X.setText(MouseInfo.getPointerInfo().getLocation().getX()+"");
		txf_posicao_Y.setText(MouseInfo.getPointerInfo().getLocation().getY()+"");
		//System.out.println("Mosue Pressed: " + e.getButton());
	}

	public void nativeMouseReleased(NativeMouseEvent e) {
		//System.out.println("Mosue Released: " + e.getButton());
	}

	public void nativeMouseMoved(NativeMouseEvent e) {
		//System.out.println("Mosue Moved: " + e.getX() + ", " + e.getY());
	}

	public void nativeMouseDragged(NativeMouseEvent e) {
		txf_tamanho_X.setText(MouseInfo.getPointerInfo().getLocation().getX()-Double.parseDouble(txf_posicao_X.getText())+"");
		txf_tamanho_Y.setText(MouseInfo.getPointerInfo().getLocation().getY()-Double.parseDouble(txf_posicao_Y.getText())+"");
		//System.out.println("Mosue Dragged: " + e.getX() + ", " + e.getY());
	}
	
	
}
