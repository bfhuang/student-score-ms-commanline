package com.binfang.commands.exit;

import com.binfang.commands.CommandInterface;

/**
 * Created by bfhuang on 7/28/17.
 */
public class ExitCommand implements CommandInterface {
    @Override
    public void execute() {
        System.exit(0);
    }
}
