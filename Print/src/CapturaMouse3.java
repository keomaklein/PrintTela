import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

public class CapturaMouse3 implements NativeMouseInputListener {
	
        public void nativeMouseClicked(NativeMouseEvent e) {
                System.out.println("Mosue Clicked: " + e.getClickCount());
        }

        public void nativeMousePressed(NativeMouseEvent e) {
                System.out.println("Mosue Pressed: " + e.getButton());
        }

        public void nativeMouseReleased(NativeMouseEvent e) {
                System.out.println("Mosue Released: " + e.getButton());
        }

        public void nativeMouseMoved(NativeMouseEvent e) {
                System.out.println("Mosue Moved: " + e.getX() + ", " + e.getY());
        }

        public void nativeMouseDragged(NativeMouseEvent e) {
                System.out.println("Mosue Dragged: " + e.getX() + ", " + e.getY());
        }

        public static void main(String[] args) {
                try {
                        GlobalScreen.registerNativeHook();
                }
                catch (NativeHookException ex) {
                        System.err.println("There was a problem registering the native hook.");
                        System.err.println(ex.getMessage());
                        System.exit(1);
                }
                CapturaMouse3 captureMouse = new CapturaMouse3();
                GlobalScreen.addNativeMouseListener(captureMouse);
                GlobalScreen.addNativeMouseMotionListener(captureMouse);
        }
}