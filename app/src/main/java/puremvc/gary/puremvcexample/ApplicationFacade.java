package puremvc.gary.puremvcexample;

import org.puremvc.java.patterns.facade.Facade;
import puremvc.gary.puremvcexample.controller.StartupCommand;

import java.lang.*;

/**
 * Created by Gary on 09/12/2016.
 */

public class ApplicationFacade extends Facade {

    public static String STARTUP = "ApplicationFacade.Startup";

    private static ApplicationFacade instance = null;

    public static ApplicationFacade getInstance()
    {
        if(instance == null)
        {
            instance = new ApplicationFacade();
        }
        return instance;
    }

    @Override
    protected void initializeController() {
        super.initializeController();

        // startup
        registerCommand(STARTUP, new StartupCommand());
    }

    public void startup(MainActivity activity)
    {
        sendNotification(STARTUP, activity);
    }
}