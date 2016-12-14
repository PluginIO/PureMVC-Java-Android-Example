package puremvc.gary.puremvcexample.controller;

import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import puremvc.gary.puremvcexample.model.RandomNumberProxy;

/**
 * Created by Gary on 12/12/2016.
 */

public class RandomNumberCommand extends SimpleCommand {

    @Override
    public void execute(INotification notification) {
        RandomNumberProxy proxy = (RandomNumberProxy)facade.retrieveProxy(RandomNumberProxy.NAME);
        proxy.GetRandomData();
    }
}