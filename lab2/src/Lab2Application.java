import javax.swing.*;

import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

@SuppressWarnings("serial")
public class Lab2Application extends JPanel implements ActionListener {

    private static int maxWidth;
    private static int maxHeight;

    Timer timer;
    
    private double rotateAngle = 0;
    
    private int radius = 45;
    private double tx = 0;
    private double ty = 0;
    private double angle = 1;
    
    public Lab2Application() {
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        g2d.setBackground(new Color(10,25,4));
        g2d.clearRect(0, 0, maxWidth, maxHeight);
        
        // draw from lab1
    	int width = 300;
    	int height = 250;
        
        g2d.setColor(new Color(240,15,0));
        g2d.fillRect((width/2)-75, ((height/2)+50)-50, 150, 50);
    
        g2d.setColor(Color.blue);
        g2d.fillOval((width/2)-75, (height/2)-100, 50, 150);
        
    	g2d.setColor(new Color(0,128,0));
        g2d.fillRect((width/2)-75, ((height/2)-25)-75, 150, 50);
        
        g2d.setColor(Color.yellow);
        g2d.fillOval((width/2)+25, (height/2)-100, 50, 150);
       
        g2d.setColor(new Color(240,15,0));
        g2d.fillRect((width/2), ((height/2)+50)-50, 75, 50);
       
        // animated star with gradient
        double starPoints[][] = {
                { -100, -15 }, { -25, -25 }, { 0, -90 }, { 25, -25 },
                { 100, -15 }, { 50, 25 }, { 60, 100 }, { 0, 50 },
                { -60, 100 }, { -50, 25 }, { -100, -15 }
        };
        
        
        // JOIN_BEVEL
        BasicStroke bs1 = new BasicStroke(16, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs1);
        g2d.setColor(new Color(148,208,204));
        g2d.drawRect(100, 250, 400, 300);

        g2d.translate(100+200, 250+150);
        GeneralPath star = drawForm(starPoints);
        star.closePath();
        
        // animations
        g2d.translate(tx, ty);        
        g2d.rotate(rotateAngle, star.getBounds2D().getCenterX(), star.getBounds2D().getCenterY());
        
        // gradient
        GradientPaint gp = new GradientPaint(1, 115, new Color(236, 196, 196), 20, 4, new Color(242, 145, 145), true);
        g2d.setPaint(gp);

        g2d.fill(star);
    }

    public void actionPerformed(ActionEvent e) {    
    	rotateAngle += 0.01;
    	
        tx = radius * Math.cos(Math.toRadians(angle));
        ty = - radius * Math.sin(Math.toRadians(angle));
        angle++;
        
        repaint();
    }

    private GeneralPath drawForm(double[][] points){
        GeneralPath form = new GeneralPath();
        form.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++){
            form.lineTo(points[k][0], points[k][1]);
        }
        form.closePath();
        return form;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab2 Java2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new Lab2Application());
        frame.setVisible(true);

        Dimension size = frame.getSize();

        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }
}