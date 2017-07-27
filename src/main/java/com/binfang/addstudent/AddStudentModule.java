package com.binfang.addstudent;

import com.binfang.common.PromptConstants;
import com.binfang.io.IOInterface;
import com.binfang.io.IORequest;
import com.binfang.student.StudentService;


public class AddStudentModule {

    private final StudentService studentService;
    private final IOInterface io;
    private final AddStudentInputValidator validator;
    private final StudentTranslator builder;

    public AddStudentModule(IOInterface io, StudentService studentService,
                            AddStudentInputValidator validator, StudentTranslator builder) {
        this.io = io;
        this.studentService = studentService;
        this.validator = validator;
        this.builder = builder;
    }

    public void execute() {
        String response = io.handleOutputAndInput(new IORequest(PromptConstants.INPUT_STUDENT, true));

        while (!validator.validate(response)) {
            response = io.handleOutputAndInput(new IORequest(PromptConstants.INPUT_CORRECT_STUDENT, true));
        }

        studentService.addStudent(builder.buildStudent(response));
    }

}
