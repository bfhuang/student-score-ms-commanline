package com.binfang.io;

/**
 * Created by bfhuang on 7/27/17.
 */
public class IORequest {
    private final boolean requireInput;
    private String output;

    public IORequest(String output, boolean requireInput) {
        this.output = output;
        this.requireInput = requireInput;
    }

    public boolean requireInput() {
        return requireInput;
    }

    public String getOutput() {
        return output;
    }
}
