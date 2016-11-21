import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CapturaMouse2 {
	private static JFrame frame;
	static JLabel lblTeste;
	private static JButton btnNewButton;
	private static CapturaMouse2 c;
	private static JLabel lblNewLabel;
	private static JLabel lblEvento;
	static JLabel lblEvento2;

	public CapturaMouse2(){
		this.c = this;
	}
	
	public static void main(String[] args) {
        //Toolkit.getDefaultToolkit().addAWTEventListener( new Listener(), AWTEvent.MOUSE_EVENT_MASK | AWTEvent.FOCUS_EVENT_MASK);
        frame = new JFrame();
        frame.setBounds(100, 100, 244, 332);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblTeste = new JLabel("Teste");
        lblTeste.setBounds(10, 110, 188, 14);
        frame.getContentPane().add(lblTeste);
        
        btnNewButton = new JButton("New button");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Thread t = new Thread(new ThreadTeste(c));
        		t.start();
        	}
        });
        btnNewButton.setBounds(10, 25, 89, 23);
        frame.getContentPane().add(btnNewButton);
        
        lblNewLabel = new JLabel("Posi\u00E7\u00E3o do mouse");
        lblNewLabel.setBounds(10, 85, 149, 14);
        frame.getContentPane().add(lblNewLabel);
        
        lblEvento = new JLabel("Evento");
        lblEvento.setBounds(10, 155, 149, 14);
        frame.getContentPane().add(lblEvento);
        
        lblEvento2 = new JLabel("Evento");
        lblEvento2.setBounds(10, 180, 149, 14);
        frame.getContentPane().add(lblEvento2);
        frame.setVisible(true);

        
	}

	private static void atualiza(){
		}
}
