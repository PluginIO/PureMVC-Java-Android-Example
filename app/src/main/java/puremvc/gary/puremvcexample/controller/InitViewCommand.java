package puremvc.gary.puremvcexample.controller;

import android.app.Application;
import android.util.Log;

import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;
import org.puremvc.java.patterns.facade.Facade;

import puremvc.gary.puremvcexample.MainActivity;
import puremvc.gary.puremvcexample.view.ApplicationMediator;
import puremvc.gary.puremvcexample.view.MainActivityMediator;

/**
 * Created by Gary on 09/12/2016.
 */

public class InitViewCommand extends SimpleCommand {

    @Override
    public void execute(INotification notification)
    {
        MainActivity mainActivity = (MainActivity) notification.getBody();
        facade.registerMediator(new ApplicationMediator(mainActivity));
    }
}