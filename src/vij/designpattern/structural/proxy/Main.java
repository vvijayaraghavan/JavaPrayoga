package vij.designpattern.structural.proxy;

/**
 * Created by Vijay on 2017, April 09.
 *
 * When we want to provide controlled access of a functionality.
 */
public class Main {

    public static void main(String[] args) {
        ICommandExecutor executor = new CommandExecutorProxy("Vijay1", "HelloWorld");
        try {
            executor.runCommand("ls -ltr");
            executor.runCommand("rm -rf abc.pdf");
        } catch (Exception e) {
            System.err.println("Exception Message::" + e);
        }
    }

}