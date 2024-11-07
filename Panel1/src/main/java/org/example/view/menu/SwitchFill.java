package org.example.view.menu;;

import org.example.Model.FillBehavior;
import org.example.controller.state.State;

/**
 *
 * @author Netbeans
 */
public class SwitchFill implements Command{

    State state;
    FillBehavior fb;

    public SwitchFill(FillBehavior fb,State state) {
        this.state = state;
        this.fb = fb;
    }

    @Override
    public void execute() {
        state.setFb(fb);
    }
}