/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package other;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class CircleImage extends JLabel {
    private BufferedImage image;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = getWidth() / 2 - image.getWidth() / 2;
        int y = getHeight() / 2 - image.getHeight() / 2;
        Graphics2D g2 = (Graphics2D) g.create();
        Shape clip = new Ellipse2D.Float(x, y, image.getWidth(), image.getHeight());
        g2.setClip(clip);
        g2.drawImage(image, x, y, null);
        g2.dispose();
    }
}
