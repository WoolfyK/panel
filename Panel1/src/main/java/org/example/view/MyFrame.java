package org.example.view;

import org.example.controller.Controller;
import org.example.controller.action.ActionDraw;
import org.example.controller.action.ActionMove;
import org.example.controller.state.State;
import org.example.Model.FillBehavior;
import org.example.Model.undomachine.UndoMachine;
import org.example.view.menu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class MyFrame extends JFrame {
    MyPanel panel;
    State state;
    UndoMachine undoMachine;
    public MyFrame(MyPanel panel,State state,UndoMachine undoMachine) {
        /////////////////////////////// menu /////////////////////
        this.state = state;
        this.undoMachine = undoMachine;
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        ArrayList<Action> menuItems = new ArrayList<>();
//        menuItems.add(new SwitchEntity("открыть файл", new ImageIcon("rectangle.gif"),
//                new OpenFile(state)));
//        menuItems.add(new SwitchEntity("создать файл", new ImageIcon("rectangle.gif"),
//                new SaveFile(state)));
        menuItems.add(new SwitchState("rectangle", new ImageIcon("images/rectangle.gif"),
                new SwitchShape(new Rectangle2D.Double(),state)));
        menuItems.add(new SwitchState("ellipse", new ImageIcon("images/ellipse.gif"),
                new SwitchShape(new Ellipse2D.Double(),state)));
        menuItems.add(new SwitchState("nofill", new ImageIcon("images/nofill.gif"),
                new SwitchFill(FillBehavior.NOFILL,state)));
        menuItems.add(new SwitchState("fill", new ImageIcon("images/fill.gif"),
                new SwitchFill( FillBehavior.FILL,state)));
        menuItems.add(new SwitchState("draw", new ImageIcon("images/draw.gif"),
                new SwitchAction( new ActionDraw(),state)));
        menuItems.add(new SwitchState("move", new ImageIcon("images/move.gif"),
                new SwitchAction(new ActionMove(),state)));
        menuItems.add(new SwitchUndo("undo", new ImageIcon("images/undo.gif"), undoMachine));
        menuItems.add(new SwitchRedo("redo", new ImageIcon("images/redo.gif"), undoMachine));
        menuItems.add(new SwitchState("color", new ImageIcon("images/colors.gif"),
                new SwitchColor(state)));
        undoMachine.addObserver((SwitchUndo)menuItems.get(menuItems.size()-3));
        undoMachine.addObserver((SwitchRedo)menuItems.get(menuItems.size()-2));
        undoMachine.notifyMenu();
        ArrayList<JMenu> menus = new ArrayList<>();
        // menus.add(new JMenu("Файл"));
        menus.add(new JMenu("Shape"));
        menus.add(new JMenu("Fill"));
        menus.add(new JMenu("Action"));
        menus.add(new JMenu("Undo/redo"));
        menus.add(new JMenu("Color"));
        int i = 0;
        int k = menuItems.size()-2;
        for (JMenu m : menus) {
            menuBar.add(m);

            if (i < k) {
                m.add(menuItems.get(i));
                m.add(menuItems.get(i + 1));
                i += 2;
            } else {
                m.add(menuItems.get(i));
            }
        }
        JToolBar toolBar = new JToolBar();
        for (Action x : menuItems) {
            toolBar.add(x);
        }
        ((JButton)toolBar.getComponent(0)).setToolTipText("rectangle");
        ((JButton)toolBar.getComponent(1)).setToolTipText("ellipse");
        ((JButton)toolBar.getComponent(2)).setToolTipText("NOFILL");
        ((JButton)toolBar.getComponent(3)).setToolTipText("FILL");
        ((JButton)toolBar.getComponent(4)).setToolTipText("draw");
        ((JButton)toolBar.getComponent(5)).setToolTipText("move");
        ((JButton)toolBar.getComponent(6)).setToolTipText("color");
        ((JButton)toolBar.getComponent(7)).setToolTipText("undo");
        ((JButton)toolBar.getComponent(8)).setToolTipText("redo");
        add(toolBar, BorderLayout.NORTH);
//////////////////////////////////////////////// end menu /////////////////////////////


        this.panel = panel;
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);

    }
}