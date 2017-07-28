package com.binfang.exit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.junit.Assert.*;

/**
 * Created by bfhuang on 7/28/17.
 */
public class ExitModuleTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void noSystemExit() {
        exit.expectSystemExit();

        ExitModule exitModule = new ExitModule();

        exitModule.execute();
    }


}