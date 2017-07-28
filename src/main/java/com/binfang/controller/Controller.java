package com.binfang.controller;

import com.binfang.addstudent.AddStudentInputValidator;
import com.binfang.addstudent.AddStudentModule;
import com.binfang.addstudent.StudentTranslator;
import com.binfang.common.ModuleInterface;
import com.binfang.exit.ExitModule;
import com.binfang.io.ConsoleIO;
import com.binfang.io.IOInterface;
import com.binfang.menu.MainMenu;
import com.binfang.printstudent.ReportStudentModule;
import com.binfang.printstudent.ReportsCreator;
import com.binfang.printstudent.ReportsOutputTranslator;
import com.binfang.service.StudentService;
import com.binfang.service.repo.StudentInMemoryRep;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bfhuang on 7/28/17.
 */
public class Controller {
    private MainMenu menu;
    private Map<String, ModuleInterface> modules = new HashMap<>();

    public Controller() {
        IOInterface io = new ConsoleIO();
        StudentService studentService = new StudentService(new StudentInMemoryRep());

        menu = new MainMenu(io);

        modules.put("1", new AddStudentModule(io, studentService,
                new AddStudentInputValidator(), new StudentTranslator()));

        modules.put("2", new ReportStudentModule(io, new ReportsCreator(studentService),
                new ReportsOutputTranslator()));

        modules.put("3", new ExitModule());
    }


    public void start() {

        String choice;

        while (true) {
            choice = menu.execute();
            modules.get(choice).execute();
        }
    }
}
