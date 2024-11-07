package org.example.Model;

import java.awt.*;
import java.awt.geom.RectangularShape;

public enum FillBehavior {
    FILL(){
        void draw(Graphics2D g,RectangularShape s){
            g.fill(s);
        }
    },
    NOFILL(){
        void draw(Graphics2D g,RectangularShape s){
            g.draw(s);
        }
    };
    abstract void draw(Graphics2D g, RectangularShape s);
}