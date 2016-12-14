package puremvc.gary.puremvcexample.controller;

import android.util.Log;

import org.puremvc.java.patterns.command.MacroCommand;

/**
 * Created by Gary on 09/12/2016.
 */

public class StartupCommand extends MacroCommand {

    @Override
    protected void initializeMacroCommand() {
        addSubCommand(new InitControllerCommand());
        addSubCommand(new InitModelCommand());
        addSubCommand(new InitViewCommand());
    }
}