package com.binfang.io;

import java.util.Scanner;

/**
 * Created by bfhuang on 7/27/17.
 */
public class IOModule {
    public String handleOutputAndInput(IORequest ioRequest) {
        System.out.print(ioRequest.getOutput());

        if (ioRequest.requireInput()) {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }

        return null;
    }
}
