package puremvc.gary.puremvcexample.view;

import android.app.Application;
import android.util.Log;

import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import puremvc.gary.puremvcexample.MainActivity;
import puremvc.gary.puremvcexample.R;

/**
 * Created by Gary on 13/12/2016.
 */

public class ApplicationMediator extends Mediator {
    public static final String NAME = "ApplicationMediator";

    public static final String UPDATE_VIEW = "ApplicationMediator.UpdateView";

    private MainActivity mMainActivity;
    private Mediator mCurrentMediator;

    public ApplicationMediator(MainActivity mainActivity)
    {
        super(NAME, mainActivity.getApplication());

        mMainActivity = mainActivity;
    }

    @Override
    public void onRegister() {
        // lets update the view to the title screen
        sendNotification(ApplicationMediator.UPDATE_VIEW, R.layout.main_screen);
    }

    @Override
    public String[] listNotificationInterests() {
        return new String[]
                {
                        ApplicationMediator.UPDATE_VIEW
                };
    }

    @Override
    public void handleNotification(INotification notification) {
        switch(notification.getName()) {

            case ApplicationMediator.UPDATE_VIEW:
                if (mCurrentMediator != null) {
                    facade.removeMediator(mCurrentMediator.getMediatorName());
                }

                int viewId = (int) notification.getBody();
                mMainActivity.setContentView(viewId);

                switch (viewId) {
                    case R.layout.main_screen:
                        mCurrentMediator = new MainActivityMediator(mMainActivity);
                        break;
                    case R.layout.random_screen:
                        mCurrentMediator = new RandomScreenMediator(mMainActivity);
                        break;
                }

                // setup mediators
                facade.registerMediator(mCurrentMediator);

                break;
        }
    }

    public MainActivity mainActivity()
    {
        return mMainActivity;
    }

    public Application application()
    {
        return (Application)viewComponent;
    }
}