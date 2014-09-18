/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import ch.aplu.jgamegrid.GGBitmap;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author willian
 */
public class Robotfill {

    public static BufferedImage[] getFill() {
        try {
            File file0 = new File("sprite/robot_0.gif");
            File file1 = new File("sprite/robot_1.gif");
            Random random = new Random();

            int r = (int) (random.nextInt(200));
            int g = (int) (random.nextInt(200));
            int b = (int) (random.nextInt(200));
            Color color = new Color(r, g, b);

            BufferedImage image0 = ImageIO.read(file0);
            BufferedImage image1 = ImageIO.read(file1);

            List bufferes = new ArrayList<BufferedImage>();

            bufferes.add(GGBitmap.floodFill(image0, new Point(15, 15), Color.WHITE, color));
            bufferes.add(GGBitmap.floodFill(image1, new Point(15, 15), Color.WHITE, color));

            return (BufferedImage[]) bufferes.toArray(new BufferedImage[bufferes.size()]);
        } catch (IOException ex) {
            Logger.getLogger(Robotfill.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
