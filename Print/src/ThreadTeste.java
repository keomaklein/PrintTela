import java.awt.MouseInfo;

public class ThreadTeste implements Runnable {
	CapturaMouse2 f;
	
	public ThreadTeste(CapturaMouse2 f){
		this.f = f;	
	}
	
	@Override
	public void run() {
		while(true){
			

			
			f.lblTeste.setText(MouseInfo.getPointerInfo().getLocation().toString());
			
			f.lblEvento2.setText(MouseInfo.getPointerInfo().getDevice() +"");
//			Toolkit.getDefaultToolkit().addAWTEventListener( new Listener(), AWTEvent.MOUSE_EVENT_MASK | AWTEvent.FOCUS_EVENT_MASK);
		}
	}

}
