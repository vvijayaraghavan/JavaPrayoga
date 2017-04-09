package vij.designpattern.structural.proxy;

import java.io.IOException;

/**
 * Created by Vijay on 2017, April 09.
 */
public class CommandExecutorImpl implements ICommandExecutor {

    @Override
    public void runCommand(String cmd) throws IOException {

        //Execute the command
//        Runtime.getRuntime().exec(cmd);
        System.out.println("'" + cmd + "' command executed.");
    }

}