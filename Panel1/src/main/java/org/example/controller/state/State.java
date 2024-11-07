/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.controller.state;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import org.example.Model.Model;
import org.example.controller.action.*;
import org.example.Model.FillBehavior;
import org.example.Model.MyShape;


/**
 *
 * @author Netbeans
 */
public class State {
    Model model;
    MyShape sampleShape;
    ActionInterface action;

    public State(Model model) {
        this.model = model;
        action = new ActionDraw(model) {
            @Override
            public void execute() {

            }

            @Override
            public void unexecute() {

            }

            @Override
            public ActionInterface myclone() {
                return null;
            }
        };
        sampleShape = new MyShape(Color.GRAY, new Rectangle2D.Double(), FillBehavior.NOFILL);
        action.setSampleShape(sampleShape);
    }

    public State() {
    }

    public void setAction(ActionInterface action) {

        this.action = action;
        action.setModel(model);
    }

    public ActionInterface getAction() {
        return action;
    }

    public MyShape getSampleShape() {
        return sampleShape;
    }

    public void setSampleShape(MyShape sampleShape) {

        this.sampleShape = sampleShape;
        action.setSampleShape(sampleShape);
    }


    public void setRectangularShape(RectangularShape rs) {
        sampleShape.setShape(rs);
        action.setSampleShape(sampleShape);
    }

    public void setColor(Color c) {
        sampleShape.setColor(c);
        action.setSampleShape(sampleShape);
    }

    public void setFb(FillBehavior fb) {
        sampleShape.setFillBehavior(fb);
        action.setSampleShape(sampleShape);
    }


}