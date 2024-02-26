import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SimpleEdition extends JFrame {
    static JFrame frame = new JFrame();
    static JLayeredPane pane = new JLayeredPane();
    static public void add(MouseEvent event){
        if (event.getButton()==1){
            JLabel label = new JLabel("X:" + event.getX() + "Y:" + event.getY());
            label.setBounds(event.getX(),event.getY(),200,40);
            pane.add(label);
        }
    }
    public static void main(String[] args) throws IOException{
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Простое добавление");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 800,height = 800;
        frame.setBounds(dimension.width/2-width/2,dimension.height/2-height/2,width,height);
        BufferedImage image = ImageIO.read(new URL("https://tgram.ru/wiki/stickers/img/annabellevk/png/1.png"));

        pane.setFocusable(true);
        frame.add(pane);
        pane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                add(e);
            }
        });
        frame.setVisible(true);

    }
}