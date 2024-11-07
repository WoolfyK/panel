package org.example.view.menu;


import org.example.controller.action.ActionInterface;
import org.example.controller.state.State;

/**
 *
 * @author Netbeans
 */
public class SwitchAction implements Command{
    ActionInterface actionInterface;
    State state;

    public SwitchAction(ActionInterface actionInterface, State state) {
        this.actionInterface = actionInterface;
        this.state = state;
    }


    @Override
    public void execute() {
        state.setAction(actionInterface);
    }

}