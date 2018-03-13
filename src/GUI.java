import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.*;

public class GUI extends JFrame {
    private int mouseX = 0;
    private int mouseY = 0;

    public GUI(){
        this.setTitle("Lakiaro");
        this.setSize(738, 761);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        Grid grid = new Grid();
        this.setContentPane(grid);

        MouseMotion mouseMotion = new MouseMotion();
        this.addMouseMotionListener(mouseMotion);
    }

    public class Grid extends JPanel{
        public void paintComponent(Graphics graphics){
            graphics.setColor(Color.black);
            graphics.fillRect(0, 0, 722, 722);

            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 12; j++){
                    graphics.setColor(Color.gray);

                    if(checkIfMouseInBox(i, j)){
                        graphics.setColor(Color.LIGHT_GRAY);
                    }

                    graphics.fillRect(2 + i * 60, 2 + j * 60,
                            58, 58);
                }
            }
        }

        private boolean checkIfMouseInBox(int i, int j){
            if(mouseX >= 10 + i * 60 && mouseX < 8 + (i + 1) * 60){
                if(mouseY >= 33 + j * 60 && mouseY < 31 + (j + 1) * 60){
                    return true;
                }
            }

            return false;
        }
    }

    public class MouseMotion implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
        }
    }
}
