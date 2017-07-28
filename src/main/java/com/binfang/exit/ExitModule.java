package com.binfang.exit;

import com.binfang.common.ModuleInterface;

/**
 * Created by bfhuang on 7/28/17.
 */
public class ExitModule implements ModuleInterface {
    @Override
    public void execute() {
        System.exit(0);
    }
}
