package com.binfang.commands.addstudent;

import com.binfang.io.IOInterface;
import com.binfang.io.IORequest;
import com.binfang.service.StudentService;
import com.binfang.service.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.binfang.helper.StudentBuilder.buildStudent;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by bfhuang on 7/27/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class AddStudentCommandTest {

    @Mock
    IOInterface io;
    @Mock
    StudentService studentService;
    @Mock
    AddStudentInputValidator validator;
    @Mock
    StudentTranslator translator;

    @InjectMocks
    AddStudentCommand addStudentModule;

    private static final String INVALID_INPUT = "some invalid input";
    private static final String VALID_INPUT = "name1, 1, 数学:90.5, 语文:12, 英语:79, 编程:93";


    @Test
    public void should_add_student_successfully_if_the_input_student_is_correct() {
        when(io.handleOutputAndInput(any(IORequest.class))).thenReturn(VALID_INPUT);
        when(validator.validate(VALID_INPUT)).thenReturn(true);
        Student student = buildStudent("name1", "12");
        when(translator.buildStudent(VALID_INPUT)).thenReturn(student);

        addStudentModule.execute();

        verify(studentService, times(1)).addStudent(student);
        verify(io, times(2)).handleOutputAndInput(any(IORequest.class));
    }

    @Test
    public void should_add_student_successfully_even_if_the_first_input_student_is_incorrect() {
        when(io.handleOutputAndInput(any(IORequest.class))).thenReturn(INVALID_INPUT).thenReturn(VALID_INPUT);
        when(validator.validate(INVALID_INPUT)).thenReturn(false);
        when(validator.validate(VALID_INPUT)).thenReturn(true);
        Student student = buildStudent("name1", "12");
        when(translator.buildStudent(VALID_INPUT)).thenReturn(student);

        addStudentModule.execute();

        verify(studentService, times(1)).addStudent(student);
        verify(io, times(3)).handleOutputAndInput(any(IORequest.class));
    }
}
