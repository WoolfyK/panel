package org.example.controller.action;

import org.example.Model.Model;
import org.example.Model.MyShape;

import java.awt.*;
import java.util.Observable;

public abstract class ActionInterface extends Observable {
    public abstract void mousePressed(Point point);
    public   abstract void mouseDragget(Point point);
    public abstract void setModel(Model m);
    public abstract void setSampleShape(MyShape myShape);
    public abstract void execute();
    public abstract void unexecute();
    public abstract ActionInterface myclone();
}