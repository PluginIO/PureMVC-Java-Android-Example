package puremvc.gary.puremvcexample.controller;

import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;
import puremvc.gary.puremvcexample.view.RandomScreenMediator;

/**
 * Created by Gary on 09/12/2016.
 */

public class InitControllerCommand extends SimpleCommand {

    @Override
    public void execute(INotification notification) {
        facade.registerCommand(RandomScreenMediator.RANDOM_BUTTON_CLICKED, new RandomNumberCommand());
    }
}