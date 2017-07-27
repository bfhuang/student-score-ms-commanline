package com.binfang.menu;

import com.binfang.common.PromptConstants;
import com.binfang.io.ConsoleIO;
import com.binfang.io.IOInterface;
import com.binfang.io.IORequest;

import java.util.regex.Pattern;

import static com.binfang.common.PromptConstants.INCORRECT_MENU_CHOICE;
import static com.binfang.common.PromptConstants.MAIN_MENU;

/**
 * Created by bfhuang on 7/27/17.
 */
public class MainMenu {
    private final IOInterface io;

    public MainMenu(IOInterface io) {
        this.io = io;
    }

    public String execute() {
        String response = io.handleOutputAndInput(new IORequest(MAIN_MENU, true));

        while(!Pattern.compile("^[123]$").matcher(response).matches()){
            response = io.handleOutputAndInput(new IORequest(
                    String.format("%s, %s", INCORRECT_MENU_CHOICE, MAIN_MENU), true));
        }

        return response;
    }

}
