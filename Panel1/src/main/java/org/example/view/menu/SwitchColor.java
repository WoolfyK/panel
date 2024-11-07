package org.example.view.menu;

import java.awt.Color;
import javax.swing.JColorChooser;
import org.example.controller.state.State;

/**
 *
 * @author Netbeans
 */
public class SwitchColor implements Command {

    Color c;
    State state;

    public SwitchColor(State state) {
        this.state = state;
    }

    @Override
    public void execute() {
        Color c = JColorChooser.showDialog(null, "choose color", Color.BLACK);
        state.setColor(c);
    }
}