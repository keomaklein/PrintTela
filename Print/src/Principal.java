import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
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
	private JTextField txfCaminhoArquivo;
	private static boolean mouseDentro;
	private JTextField textField;
	private JLabel lblInicio;
	private JLabel lblPontoDeInicio;
	private JLabel lblAlturaDaImagem;
	private JLabel lblTempoDeRepeties;
	private JLabel lblQuantidadeDeRepeties;
	private JLabel lblLarguraDaImagem;
	private JButton btnCaminhoArquivo;
	private JLabel lblCaminhoParaSalvar;
	private JLabel lblNomeDoArquivo;

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
		frame.setBounds(100, 100, 244, 387);
		frame.getContentPane().setLayout(null);
		
		btn_printar = new JButton("Printar");
		txf_posicao_X = new JtextFieldSomenteNumeros();
		txf_posicao_Y = new JtextFieldSomenteNumeros();
		txf_tamanho_X = new JtextFieldSomenteNumeros();
		txf_tamanho_Y = new JtextFieldSomenteNumeros();
		txf_tempo_repeticao = new JtextFieldSomenteNumeros();
		txf_quantidade_print = new JtextFieldSomenteNumeros();
		lblInicio = new JLabel("Ponto de inicio em X");
		lblPontoDeInicio = new JLabel("Ponto de inicio em Y");
		lblAlturaDaImagem = new JLabel("Altura da imagem");
		lblTempoDeRepeties = new JLabel("Tempo do print (Segundos)");
		lblQuantidadeDeRepeties = new JLabel("Quantidade de repeti\u00E7\u00F5es");
		lblLarguraDaImagem = new JLabel("Largura da imagem");
		rbt_mouse = new JRadioButton("Usar o mouse");
		rbt_edit_posicao = new JRadioButton("Editar posi\u00E7\u00E3o da imagem");
		txfCaminhoArquivo = new JTextField();
		btnCaminhoArquivo = new JButton("...");
		lblCaminhoParaSalvar = new JLabel("Caminho para salvar as imagens");
		lblNomeDoArquivo = new JLabel("Nome do arquivo:");
		textField = new JTextField();
		
		txf_posicao_X.setMaximoCaracteres(4);
		txf_posicao_Y.setMaximoCaracteres(4);
		txf_tamanho_X.setMaximoCaracteres(4);
		txf_tamanho_Y.setMaximoCaracteres(4);
		txf_tempo_repeticao.setMaximoCaracteres(4);
		txf_quantidade_print.setMaximoCaracteres(4);

		btn_printar.setBounds(13, 324, 218, 23);
		txf_posicao_X.setBounds(10, 72, 39, 20);
		txf_posicao_Y.setBounds(10, 103, 39, 20);
		txf_tamanho_X.setBounds(10, 134, 39, 20);
		txf_tamanho_Y.setBounds(10, 165, 39, 20);
		txf_tempo_repeticao.setBounds(10, 196, 39, 20);
		txf_quantidade_print.setBounds(10, 226, 39, 20);
		lblInicio.setBounds(59, 75, 131, 14);
		lblPontoDeInicio.setBounds(59, 106, 131, 14);
		lblAlturaDaImagem.setBounds(59, 168, 132, 14);
		lblTempoDeRepeties.setBounds(59, 199, 172, 14);
		lblQuantidadeDeRepeties.setBounds(59, 229, 170, 14);
		lblLarguraDaImagem.setBounds(59, 137, 131, 14);
		rbt_mouse.setBounds(10, 7, 180, 23);
		rbt_edit_posicao.setBounds(10, 33, 180, 23);
		txfCaminhoArquivo.setBounds(13, 292, 196, 20);
		btnCaminhoArquivo.setBounds(210, 290, 23, 23);
		lblCaminhoParaSalvar.setBounds(13, 278, 170, 14);
		lblNomeDoArquivo.setBounds(13, 253, 98, 14);
		textField.setBounds(109, 250, 122, 20);

		txf_posicao_X.setHorizontalAlignment(SwingConstants.RIGHT);
		txf_posicao_Y.setHorizontalAlignment(SwingConstants.RIGHT);
		txf_tamanho_X.setHorizontalAlignment(SwingConstants.RIGHT);
		txf_tamanho_Y.setHorizontalAlignment(SwingConstants.RIGHT);
		txf_tempo_repeticao.setHorizontalAlignment(SwingConstants.RIGHT);
		txf_quantidade_print.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txf_posicao_X.setText("");
		txf_posicao_Y.setText("");
		txf_tamanho_X.setText("");
		txf_tamanho_Y.setText("");
		txf_tempo_repeticao.setText("");
		txf_quantidade_print.setText("");

		txf_posicao_X.setToolTipText("Posi\u00E7\u00E3o inicial em X");
		txf_posicao_Y.setToolTipText("Posi\u00E7\u00E3o inicial em Y");
		txf_tamanho_X.setToolTipText("Largura");
		txf_tamanho_Y.setToolTipText("Altura");
		txf_tempo_repeticao.setToolTipText("Tempo de repeti\u00E7\u00F5es");
		txf_quantidade_print.setToolTipText("Quantidade de prints");
		rbt_mouse.setToolTipText("Usar o mouse para definir a area do print");

		txf_posicao_X.setColumns(10);
		txf_posicao_Y.setColumns(10);
		txf_tamanho_X.setColumns(10);
		txf_tamanho_Y.setColumns(10);
		txf_tempo_repeticao.setColumns(10);
		txf_quantidade_print.setColumns(10);
		txfCaminhoArquivo.setColumns(10);
		textField.setColumns(10);

		rbt_edit_posicao.setSelected(true);
		
		frame.getContentPane().add(btn_printar);
		frame.getContentPane().add(txf_posicao_X);
		frame.getContentPane().add(txf_posicao_Y);
		frame.getContentPane().add(txf_tamanho_X);
		frame.getContentPane().add(txf_tamanho_Y);
		frame.getContentPane().add(txf_tempo_repeticao);
		frame.getContentPane().add(txf_quantidade_print);
		frame.getContentPane().add(lblInicio);
		frame.getContentPane().add(lblPontoDeInicio);
		frame.getContentPane().add(lblAlturaDaImagem);
		frame.getContentPane().add(lblTempoDeRepeties);
		frame.getContentPane().add(lblQuantidadeDeRepeties);
		frame.getContentPane().add(lblLarguraDaImagem);
		frame.getContentPane().add(rbt_mouse);
		frame.getContentPane().add(rbt_edit_posicao);
		frame.getContentPane().add(txfCaminhoArquivo);
		frame.getContentPane().add(btnCaminhoArquivo);
		frame.getContentPane().add(lblCaminhoParaSalvar);
		frame.getContentPane().add(lblNomeDoArquivo);
		frame.getContentPane().add(textField);
		
		// Actions
		btn_printar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!(txf_tempo_repeticao.getText().equals("") || txf_quantidade_print.getText().equals(""))){		
					frame.setExtendedState(JFrame.ICONIFIED);
					Thread t = new Thread(new Printador(Double.parseDouble(txf_posicao_X.getText()),Double.parseDouble(txf_posicao_Y.getText()),
														Double.parseDouble(txf_tamanho_X.getText()),Double.parseDouble(txf_tamanho_X.getText()),
														Double.parseDouble(txf_quantidade_print.getText()),Double.parseDouble(txf_tempo_repeticao.getText()),
														"teste", txfCaminhoArquivo.getText() + "\\"));
					t.start();
					try {
						Thread.sleep(1000 * Integer.parseInt(txf_tempo_repeticao.getText()) * Integer.parseInt(txf_quantidade_print.getText()));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					frame.setExtendedState(JFrame.NORMAL);
				}
			}
		});
		
		 txf_posicao_X.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent arg0) {
	        		txf_posicao_X.selectAll();
	        	}
	        	@Override
				public void mouseEntered(MouseEvent arg0) {
					mouseDentro = true;
				}
				@Override
				public void mouseExited(MouseEvent e) {
					mouseDentro = false;
				}
	        });
		 txf_posicao_Y.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txf_posicao_X.selectAll();
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					mouseDentro = true;
				}
				@Override
				public void mouseExited(MouseEvent e) {
					mouseDentro = false;
				}
			});
			txf_tamanho_X.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txf_tamanho_X.selectAll();
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					mouseDentro = true;
				}
				@Override
				public void mouseExited(MouseEvent e) {
					mouseDentro = false;
				}
			});
			txf_tamanho_Y.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txf_tamanho_Y.selectAll();
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					mouseDentro = true;
				}
				@Override
				public void mouseExited(MouseEvent e) {
					mouseDentro = false;
				}
			});
			txf_tempo_repeticao.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txf_tempo_repeticao.selectAll();
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					mouseDentro = true;
				}
				@Override
				public void mouseExited(MouseEvent e) {
					mouseDentro = false;
				}
			});
			txf_quantidade_print.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txf_quantidade_print.selectAll();
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					mouseDentro = true;
				}
				@Override
				public void mouseExited(MouseEvent e) {
					mouseDentro = false;
				}
			});
			btnCaminhoArquivo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					mouseDentro = true;
				}
				@Override
				public void mouseExited(MouseEvent e) {
					mouseDentro = false;
				}
			});
			rbt_mouse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					alterarCheck();	
				}
			});
			rbt_edit_posicao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					alterarCheck();
				}
			});
			btnCaminhoArquivo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {


				    JFileChooser chooser = new JFileChooser();
				    chooser.setCurrentDirectory(new java.io.File("."));
				    chooser.setDialogTitle("choosertitle");
				    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				    chooser.setAcceptAllFileFilterUsed(false);

				    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				    	txfCaminhoArquivo.setText(chooser.getCurrentDirectory().getAbsolutePath());

				    } else {
				      System.out.println("No Selection ");
				    }
				    
				}
			});
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
		GlobalScreen.addNativeMouseListener(this);
		GlobalScreen.addNativeMouseMotionListener(this);
	}

	
	public void nativeMouseClicked(NativeMouseEvent e) {
	
		//System.out.println("Mosue Clicked: " + e.getClickCount());
	}

	public void nativeMousePressed(NativeMouseEvent e) {
		if(rbt_mouse.isSelected() && !mouseDentro){
			txf_posicao_X.setText(MouseInfo.getPointerInfo().getLocation().getX()+"");
			txf_posicao_Y.setText(MouseInfo.getPointerInfo().getLocation().getY()+"");
		}
	}

	public void nativeMouseReleased(NativeMouseEvent e) {
		if(rbt_mouse.isSelected() && !mouseDentro){
			if(MouseInfo.getPointerInfo().getLocation().getX() == Double.parseDouble(txf_posicao_X.getText()) &&
					MouseInfo.getPointerInfo().getLocation().getY() == Double.parseDouble(txf_posicao_Y.getText())){
				txf_tamanho_X.setText("0");
				txf_tamanho_Y.setText("0");	
			}
			alterarCheck();
		}
	}

	public void nativeMouseMoved(NativeMouseEvent e) {
	}

	public void nativeMouseDragged(NativeMouseEvent e) {
		if(rbt_mouse.isSelected() && !mouseDentro){
			txf_tamanho_X.setText(MouseInfo.getPointerInfo().getLocation().getX()+"");
			txf_tamanho_Y.setText(MouseInfo.getPointerInfo().getLocation().getY()+"");

		}
	}
}
