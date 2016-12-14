package puremvc.gary.puremvcexample.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import puremvc.gary.puremvcexample.MainActivity;
import puremvc.gary.puremvcexample.R;
import puremvc.gary.puremvcexample.model.RandomNumberProxy;

/**
 * Created by Gary on 12/12/2016.
 */

public class RandomScreenMediator extends Mediator {

    public static final String NAME = "TitleScreenMediator";

    public static final String RANDOM_BUTTON_CLICKED = "TitleScreenMediator.RandomButtonClicked";

    private Button mRandomButtonView;
    private Button mBackButtonView;

    public RandomScreenMediator(MainActivity activity)
    {
        super(NAME, activity);
    }

    @Override
    public void onRegister() {

        // register the random button
        mRandomButtonView = (Button)mainActivity().findViewById(R.id.random_button);
        mRandomButtonView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendNotification(RANDOM_BUTTON_CLICKED);
            }
        });

        // register the back button
        mBackButtonView = (Button)mainActivity().findViewById(R.id.back_button);
        mBackButtonView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendNotification(ApplicationMediator.UPDATE_VIEW, R.layout.main_screen);
            }
        });
    }

    @Override
    public String[] listNotificationInterests() {
        return new String[]
                {
                        RandomNumberProxy.DATA_RECIEVED
                };
    }

    public void handleNotification(INotification notification) {
        switch(notification.getName())
        {
            case RandomNumberProxy.DATA_RECIEVED:
                String randomNumber = notification.getBody().toString();
                TextView textView = (TextView)mainActivity().findViewById(R.id.hello_world);
                textView.setText(randomNumber);
                break;
        }
    }

    public MainActivity mainActivity()
    {
        return (MainActivity)viewComponent;
    }
}