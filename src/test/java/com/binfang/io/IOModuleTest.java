package com.binfang.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by bfhuang on 7/27/17.
 */
public class IOModuleTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inputContent = new ByteArrayInputStream("some input".getBytes());
    private ConsoleIO ioModule;

    @Before
    public void setUpStreams() {
        ioModule = new ConsoleIO();

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(inputContent);
    }

    @Test
    public void should_get_input_when_request_require_input() {
        IORequest ioRequest = new IORequest("some output", true);

        String response = ioModule.handleOutputAndInput(ioRequest);

        assertThat(outContent.toString(), is("some output"));
        assertThat(response, is("some input"));

    }

    @Test
    public void should_not_get_input_when_request_require_no_input() {
        IORequest ioRequest = new IORequest("output string", false);

        String response = ioModule.handleOutputAndInput(ioRequest);

        assertThat(outContent.toString(), is("output string"));
        assertNull(response);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
        System.setIn(null);
    }

}
