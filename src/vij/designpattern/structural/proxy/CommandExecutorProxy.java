package vij.designpattern.structural.proxy;

/**
 * Created by Vijay on 2017, April 09.
 */
public class CommandExecutorProxy implements ICommandExecutor {

    private static final String ADMIN_USER = "Vijay";
    private static final String ADMIN_PASS = "HelloWorld";

    private boolean isAdmin;
    private ICommandExecutor iExecutor;

    public CommandExecutorProxy(String user, String pwd) {
        if (ADMIN_USER.equals(user) && ADMIN_PASS.equals(pwd)) {
            isAdmin=true;
        }
        iExecutor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if(isAdmin){
            iExecutor.runCommand(cmd);
        }else{
            if(cmd.trim().startsWith("rm")){
                throw new Exception("rm command is not allowed for non-admin users.");
            }else{
                iExecutor.runCommand(cmd);
            }
        }
    }

}