package com.binfang.commands.menu;

import com.binfang.io.IOInterface;
import com.binfang.io.IORequest;

import java.util.regex.Pattern;

import static com.binfang.commands.contants.PromptConstants.INCORRECT_MENU_CHOICE;
import static com.binfang.commands.contants.PromptConstants.MAIN_MENU;


public class MainMenu {
    public static final String MENU_CHOICE_REGEX = "^[123]$";
    private final IOInterface io;

    public MainMenu(IOInterface io) {
        this.io = io;
    }

    public String execute() {
        String response = io.handleOutputAndInput(new IORequest(MAIN_MENU, true));

        while (!Pattern.compile(MENU_CHOICE_REGEX).matcher(response).matches()) {
            response = io.handleOutputAndInput(new IORequest(
                    String.format("%s %s", INCORRECT_MENU_CHOICE, MAIN_MENU), true));
        }

        return response;
    }

}
