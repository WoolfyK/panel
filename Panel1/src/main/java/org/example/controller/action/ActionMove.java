package org.example.controller.action;

import org.example.Model.Model;
import org.example.Model.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;

public class ActionMove extends ActionInterface{
    MyShape shape;
    MyShape shapeNew;
    MyShape shapeOld;
    Point2D[] p;
    Model model;

    public ActionMove(Model model) {
        this.model = model;
        p = new Point2D[2];
    }

    public ActionMove() {
        p = new Point2D[2];
    }

    public void setModel(Model model) {
        this.model = model;
    }

    void findShape(Point point){
        Point2D p1 = (Point2D) point;
        p[0] = p1;
        Collection<MyShape> list = model.getList();
        for (MyShape x:list) {
            if(x.getShape().contains(p1)) shape = x;
        }
        shapeOld = shape.clone();
        shapeNew=shape;
    }

    @Override
    public void mousePressed(Point point) {
        findShape(point);
    }
    public void moveShape(Point point) {
        p[1] = (Point2D) point;
        if(shape!=null){
            double deltaX = p[1].getX()-p[0].getX();
            double deltaY = p[1].getY()-p[0].getY();
            double maxX=shape.getShape().getMaxX()+deltaX;
            double maxY=shape.getShape().getMaxY()+ deltaY;
            double minX = shape.getShape().getMinX()+deltaX;
            double minY = shape.getShape().getMinY()+deltaY;
            shape.getShape().setFrameFromDiagonal(minX, minY, maxX, maxY);
            p[0]=p[1];
        }
    }

    @Override
    public void mouseDragget(Point point) {
        moveShape(point);

    }

    @Override
    public void setSampleShape(MyShape myShape) {

    }
    void changeShape(MyShape shape,MyShape shape1){
        ArrayList<MyShape> list = (ArrayList<MyShape>) model.getList();
        int index = list.indexOf(shape);
        list.remove(index);
        list.add(index,shape1);
        setChanged();
        notifyObservers();
    }
    @Override
    public void execute() {
        changeShape(shapeOld,shapeNew);

    }

    @Override
    public void unexecute() {
        changeShape(shapeNew,shapeOld);

    }

    @Override
    public ActionInterface myclone() {
        ActionMove ad  = new ActionMove(model);
        ad.shape = this.shape;//.clone();
        ad.shapeNew = this.shapeNew;//.clone();
        ad.shapeOld = this.shapeOld;
        ad.p = this.p;
        return ad;

    }
}