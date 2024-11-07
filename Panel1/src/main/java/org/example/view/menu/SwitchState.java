package org.example.view.menu;;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;


/**
 *
 * @author Netbeans
 */
public class SwitchState extends AbstractAction{

    public SwitchState(String name, Icon icon, Command com) {
        super(name, icon);
        putValue("Command", com);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Command action = (Command) getValue("Command");
        action.execute();
    }


}