package org.example.controller.action;

import org.example.Model.Model;
import org.example.Model.MyShape;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Observable;

public class ActionDraw extends  ActionInterface{
    MyShape sampleShape;
    MyShape shape;
    Point2D[] p;
    Model model;

    public void setSampleShape(MyShape sampleShape) {
        this.sampleShape = sampleShape;
    }
    void deleteShape(){
        ArrayList<MyShape> list = (ArrayList<MyShape>) model.getList();
        shape = list.remove(list.size() - 1);
        setChanged();
        notifyObservers();
    }
    @Override
    public void execute() {
        model.createCurrentShape(shape);
        setChanged();
        notifyObservers();
    }

    @Override
    public void unexecute() {
        deleteShape();
        setChanged();
        notifyObservers();
    }

    @Override
    public ActionInterface myclone() {
        ActionDraw ad  = new ActionDraw(model);
        ad.setSampleShape(sampleShape);   //.clone());
        ad.shape = this.shape;//.clone();
        ad.p = this.p;
        return ad;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public ActionDraw() {

        p = new Point2D[2];
        sampleShape = new MyShape(Color.BLUE, new Ellipse2D.Double());
    }

    public ActionDraw(  Model model) {
        shape = new MyShape();
        this.p = new Point2D[2];
        this.model = model;
        sampleShape = new MyShape(Color.BLUE, new Ellipse2D.Double());
    }

    public void setShape(MyShape shape) {
        this.shape = shape;
    }
    public void stretchShape(Point point){
        p[1] =(Point2D) point;
        shape.setFrame(p);
    }
    public void createShape(Point point){
        p[0] = (Point2D)point;
        shape = sampleShape.clone();
        model.createCurrentShape(shape);
    }


    @Override
    public void mousePressed(Point point) {
        createShape(point);
    }

    @Override
    public void mouseDragget(Point point) {
        stretchShape(point);
    }
}