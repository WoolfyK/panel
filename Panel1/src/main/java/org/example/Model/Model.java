package org.example.Model;

import java.util.ArrayList;
import java.util.Collection;

public class Model {
    MyShape currentShape;
    Collection<MyShape> list;

    public Model() {
        list = new ArrayList<>();
    }

    public void setCurrentShape(MyShape currentShape) {
        this.currentShape = currentShape;
    }

    public void createCurrentShape(MyShape shape) {
        currentShape = shape;
        list.add(currentShape);
    }

    public MyShape getCurrentShape() {
        return currentShape;
    }

    public Collection<MyShape> getList() {
        return list;
    }
}