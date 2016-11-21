import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CapturaMouse  extends JFrame implements MouseListener, MouseMotionListener{

	JLabel mousePosition;
	
	@Override
	public void mouseClicked(MouseEvent e) {
	    System.out.print("Mouse clicked at coordinate : ["+e.getX()+","+e.getY()+"]");     
	} 
	@Override
	public void mouseEntered(MouseEvent e) {
	    System.out.print("Current mouse Coordinates : ["+e.getX()+","+e.getY()+"]");     
	} 
	@Override
	public void mouseExited(MouseEvent e) {
	    System.out.print("Mouse outside access window");     
	} 
	@Override
	public void mousePressed(MouseEvent e) {
	    System.out.print("Mouse pressed at coordinates : ["+e.getX()+","+e.getY()+"]");     
	} 
	@Override
	public void mouseReleased(MouseEvent e) {
	    System.out.print("Current mouse coordinates : ["+e.getX()+","+e.getY()+"]");     
	} 
	@Override
	public void mouseDragged(MouseEvent e) {
	    System.out.print("Mouse dragged at coordinates : ["+e.getX()+","+e.getY()+"]"); 
	} 
	@Override
	public void mouseMoved(MouseEvent e) {
	    System.out.print("Mouse moved to coordinates : ["+e.getX()+","+e.getY()+"]");     
	}
	
    public void start()
    {
        mousePosition=new JLabel();
         addMouseListener( this );        // listens for own mouse and
          addMouseMotionListener( this );  // mouse-motion events
          setLayout(new FlowLayout(1));
          add(mousePosition);
          Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
          setSize(size );
          setUndecorated(true);
          setVisible( true );
          setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String args[])
    {
        new CapturaMouse().start();
         
    }
}
