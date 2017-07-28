package com.binfang.controller;

import com.binfang.commands.CommandInterface;
import com.binfang.commands.addstudent.AddStudentCommand;
import com.binfang.commands.addstudent.AddStudentInputValidator;
import com.binfang.commands.addstudent.StudentTranslator;
import com.binfang.commands.exit.ExitCommand;
import com.binfang.commands.menu.MainMenu;
import com.binfang.commands.reports.ReportStudentCommand;
import com.binfang.commands.reports.ReportsCreator;
import com.binfang.commands.reports.ReportsOutputTranslator;
import com.binfang.io.ConsoleIO;
import com.binfang.io.IOInterface;
import com.binfang.service.StudentService;
import com.binfang.service.repo.StudentInMemoryRep;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bfhuang on 7/28/17.
 */
public class Controller {
    private Map<String, CommandInterface> commands = new HashMap<>();
    private MainMenu menu;

    public Controller() {
        IOInterface io = new ConsoleIO();
        StudentService studentService = new StudentService(new StudentInMemoryRep());
        menu = new MainMenu(io);
        commands.put("1", new AddStudentCommand(io, studentService,
                new AddStudentInputValidator(), new StudentTranslator()));
        commands.put("2", new ReportStudentCommand(io, new ReportsCreator(studentService),
                new ReportsOutputTranslator()));
        commands.put("3", new ExitCommand());
    }


    public void start() {
        String choice ;

        while (true) {
            choice = menu.execute();
            commands.get(choice).execute();
        }

    }
}
