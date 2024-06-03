import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import java.awt.event.MouseMotionListener; 
import javax.swing.JFrame;  
 
public class MyWindow extends JFrame implements MouseListener {    
    public MyWindow() {   
        setSize(400,400);   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        setVisible(true);      //addMouseListener(this);  
        addMouseListener(this);
    }
 
    public static void main(String[] args) {
        MyWindow window = new MyWindow();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited.");
    } 
}
 //todo: add MouseListener methods (see outline below)