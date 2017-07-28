package com.binfang.controller;

import com.binfang.addstudent.AddStudentModule;
import com.binfang.exit.ExitModule;
import com.binfang.menu.MainMenu;
import com.binfang.printstudent.ReportStudentModule;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * Created by bfhuang on 7/28/17.
 */
public class ControllerTest {
    @Mock
    MainMenu menu;
    @Mock
    AddStudentModule addStudentModule;
    @Mock
    ReportStudentModule reportStudentModule;
    @Mock
    ExitModule exitModule;
    @InjectMocks
    Controller controller;
//
//    @Before
//    public void setUp() throws Exception {
//        controller.setAddStudentModule(addStudentModule);
//        controller.setReportStudentModule(reportStudentModule);
//        controller.setMenu(menu);
//    }

//    @Test
//    public void should_call_each_module_accordingly_based_on_the_menu_choice() {
//       try {
//           when(menu.execute()).thenReturn("1").thenReturn("2").thenThrow(NullPointerException.class);
//
//           controller.start();
//
//           verify(menu, times(3)).execute();
//           verify(addStudentModule, times(1)).execute();
//           verify(reportStudentModule, times(1)).execute();
//           System.out.println("dddd");
//       }catch (NullPointerException e){
//           System.out.println("dddd");
//
//       }
//    }
}
