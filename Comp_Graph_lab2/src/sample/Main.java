package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

@SuppressWarnings("serial")
public class Main extends JPanel implements ActionListener {
    private static int maxWidth;
    private static int maxHeight;

    double points[][] = {
            { -80, -320 }, { -80, -115 }, { -30, -115 },{ -30, -320 }
    };

    Timer timer;

    private static double scale = 1;
    private static double delta = 0.01;

    // for movement animation
    private static double dx = 1;
    private static double tx = 0;
    private static double dy = 1;
    private static double ty = 0;
    private static int direction = 1;
    private static int radius = 245;
    private static int radiusExtension = 110;

    public Main() {
        timer = new Timer(10, this);
        timer.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new Main());

        frame.setVisible(true);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }


    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering params.
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        // Set background color.
        g2d.setBackground(new Color(128, 128, 0));
        g2d.clearRect(0, 0, maxWidth, maxHeight);


        g2d.translate(maxWidth/2, maxHeight/2);
        // Draw the main Frame.
       BasicStroke bs2 = new BasicStroke(16, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs2);
        g2d.drawRect(
                -(radius + radiusExtension),
                -(radius + radiusExtension),
                (radius + radiusExtension)*2,
                (radius + radiusExtension)*2
        );

        g2d.translate(tx, ty);
        g2d.scale(scale, scale);


        GeneralPath additionalFigure = new GeneralPath();
        additionalFigure.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++)
            additionalFigure.lineTo(points[k][0], points[k][1]);
        additionalFigure.closePath();

        GradientPaint gp = new GradientPaint(
                25, 50,
                new Color(202, 0, 66),
                60, 5,
                new Color(252, 163, 205),
                true
        );
        g2d.setPaint(gp);
        g2d.fill(additionalFigure);

        printBlocks(g2d);

    }

    private void printBlocks(Graphics2D g2d){
        Color rectColor = new Color(128, 0, 0);
        g2d.setColor(rectColor);

        g2d.fillRect(25 - maxWidth/2 + 20, 20 - maxHeight/2 + 20, 120, 60);
        g2d.fillRect(150 - maxWidth/2 + 20, 20 - maxHeight/2 + 20, 120, 60);
        g2d.fillRect(25 - maxWidth/2 + 20, 85 - maxHeight/2 + 20, 60, 75);
        g2d.fillRect(90 - maxWidth/2 + 20, 85 - maxHeight/2 + 20, 115, 75);
        g2d.fillRect(210 - maxWidth/2 + 20, 85 - maxHeight/2 + 20, 60, 75);
        g2d.fillRect(25 - maxWidth/2 + 20, 165 - maxHeight/2 + 20, 120, 60);
        g2d.fillRect(150 - maxWidth/2 + 20, 165 - maxHeight/2 + 20, 120, 60);
    }


    public void actionPerformed(ActionEvent e) {
        if(maxHeight != 0){
            if ( scale < 0.01 ) {
                delta = -delta;
            } else if (scale > 0.99) {
                delta = -delta;
            }
            scale += delta;

            if (direction == 4 && tx < 0) {
                direction = 1;
            }else if (direction == 2 && tx > maxWidth - 400 ) {
                direction = 3;
            }else if (direction == 3 &&  ty < 0 ) {
                direction = 4;
            }else if (direction == 1 && ty > maxHeight - 370 ) {
                direction = 2;
            }

            switch (direction){
                case 1: ty += dy; break;
                case 2: tx += dx;break;
                case 3: ty -= dy;break;
                case 4: tx -= dx;break;
            }

        }

        repaint();
    }
}
