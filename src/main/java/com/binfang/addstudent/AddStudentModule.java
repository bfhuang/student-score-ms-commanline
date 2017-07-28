package com.binfang.addstudent;

import com.binfang.common.ModuleInterface;
import com.binfang.common.PromptConstants;
import com.binfang.io.IOInterface;
import com.binfang.io.IORequest;
import com.binfang.service.StudentService;
import com.binfang.service.model.Student;


public class AddStudentModule implements ModuleInterface {

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

    @Override
    public void execute() {
        String response = io.handleOutputAndInput(new IORequest(PromptConstants.INPUT_STUDENT, true));

        while (!validator.validate(response)) {
            response = io.handleOutputAndInput(new IORequest(PromptConstants.INPUT_CORRECT_STUDENT, true));
        }

        Student student = builder.buildStudent(response);
        studentService.addStudent(student);

        io.handleOutputAndInput(
                new IORequest(String.format(PromptConstants.ADD_STUDENT_SUCCESS, student.getName()), false));
    }

}
