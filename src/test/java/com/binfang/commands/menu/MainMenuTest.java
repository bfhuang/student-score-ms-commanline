package com.binfang.commands.menu;

import com.binfang.io.IOInterface;
import com.binfang.io.IORequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by bfhuang on 7/27/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainMenuTest {
    @Mock
    IOInterface io;

    @InjectMocks
    MainMenu menu;


    @Test
    public void should_display_menu_and_return_correct_menu_choice() {
        when(io.handleOutputAndInput(any(IORequest.class))).thenReturn("1");

        String choice = menu.execute();

        assertThat(choice, is("1"));
        verify(io, times(1)).handleOutputAndInput(any(IORequest.class));
    }

    @Test
    public void should_display_menu_and_validate_incorrect_menu_choice_until_this_choice_is_right() {
        when(io.handleOutputAndInput(any(IORequest.class))).thenReturn("incorrect choice").thenReturn("2");


        String choice = menu.execute();

        assertThat(choice, is("2"));
        verify(io, times(2)).handleOutputAndInput(any(IORequest.class));
    }
}
