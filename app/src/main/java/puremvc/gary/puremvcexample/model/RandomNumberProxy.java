package puremvc.gary.puremvcexample.model;

import org.puremvc.java.patterns.facade.Facade;
import org.puremvc.java.patterns.proxy.Proxy;

/**
 * Created by Gary on 12/12/2016.
 */

public class RandomNumberProxy extends Proxy {

    public static final String NAME = "RandomNumberProxy";

    public static final String DATA_RECIEVED = "RandomNumberProxy.DataRecieved";

    public RandomNumberProxy()
    {
        super(NAME);
    }

    public void GetRandomData()
    {
        super.sendNotification(DATA_RECIEVED, Math.random());
    }
}