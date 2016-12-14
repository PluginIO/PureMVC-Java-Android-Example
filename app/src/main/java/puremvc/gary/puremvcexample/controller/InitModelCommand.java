package puremvc.gary.puremvcexample.controller;

import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import puremvc.gary.puremvcexample.model.RandomNumberProxy;

/**
 * Created by Gary on 09/12/2016.
 */

public class InitModelCommand extends SimpleCommand {

    @Override
    public void execute(INotification notification) {
        facade.registerProxy(new RandomNumberProxy());
    }
}