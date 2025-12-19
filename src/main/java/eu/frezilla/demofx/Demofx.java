/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package eu.frezilla.demofx;

import eu.frezilla.demofx.tablet.Line;
import eu.frezilla.demofx.tablet.MagicTablet;
import eu.frezilla.demofx.tablet.Size;

/**
 *
 * @author f.balme
 */
public class Demofx {

    public static void main(String[] args) {
        MagicTablet tablet = new MagicTablet("test", new Size(640, 480));
        tablet.addShape(new Line(50, 50, 100, 100));
        tablet.draw();
    }
}
