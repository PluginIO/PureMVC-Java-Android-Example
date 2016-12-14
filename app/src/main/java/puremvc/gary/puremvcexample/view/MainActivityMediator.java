package puremvc.gary.puremvcexample.view;

import android.view.View;
import android.widget.Button;

import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import puremvc.gary.puremvcexample.MainActivity;
import puremvc.gary.puremvcexample.R;

/**
 * Created by Gary on 12/12/2016.
 */

public class MainActivityMediator extends Mediator {

    public static final String NAME = "MainActivityMediator";
    public static final String BUTTON_CLICKED = "MainActivityMediator.ButtonClicked";

    private Button mButtonView;

    public MainActivityMediator(MainActivity viewComponent)
    {
            super(NAME, viewComponent);
    }

    @Override
    public void onRegister() {
        mButtonView = (Button)mainActivity().findViewById(R.id.button);
        mButtonView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendNotification(BUTTON_CLICKED);
            }
        });
    }

    @Override
    public String[] listNotificationInterests() {
        return new String[]
                {
                        MainActivityMediator.BUTTON_CLICKED
                };
    }

    @Override
    public void handleNotification(INotification notification) {
        switch(notification.getName())
        {
            case MainActivityMediator.BUTTON_CLICKED:
                sendNotification(ApplicationMediator.UPDATE_VIEW, R.layout.random_screen);
                break;
        }
    }

    public MainActivity mainActivity()
    {
        return (MainActivity)viewComponent;
    }
}