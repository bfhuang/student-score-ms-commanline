package com.binfang.commands.reports;

import com.binfang.helper.StudentBuilder;
import com.binfang.io.IOInterface;
import com.binfang.io.IORequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.binfang.helper.ReportBuilder.buildReport;
import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

/**
 * Created by bfhuang on 7/28/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ReportStudentCommandTest {

    @Mock
    IOInterface io;
    @Mock
    ReportsCreator reports;
    @Mock
    ReportsOutputTranslator translator;

    @InjectMocks
    ReportStudentCommand module;


    @Test
    public void should_print_report_successfully_if_there_is_no_input_error() {
        when(io.handleOutputAndInput(any(IORequest.class))).thenReturn("1, 2").thenReturn(null);
        List<Report> reports1 = asList(buildReport(asList(StudentBuilder.buildStudent("nam1", "1"))));
        when(this.reports.buildReports(anyList()))
                .thenReturn(reports1);
        when(translator.translateReportsToString(reports1)).thenReturn("out put");

        module.execute();

        verify(io, times(2)).handleOutputAndInput(any(IORequest.class));
        verify(reports, times(1)).buildReports(anyList());
        verify(translator, times(1)).translateReportsToString(reports1);
    }

    @Test
    public void should_print_report_successfully_if_there_is_invalid_input_until_the_input_is_correct() {
        when(io.handleOutputAndInput(any(IORequest.class))).thenReturn("invalid").thenReturn("1")
                .thenReturn(null);
        List<Report> reports1 = asList(buildReport(asList(StudentBuilder.buildStudent("nam1", "1"))));
        when(this.reports.buildReports(anyList()))
                .thenReturn(reports1);
        when(translator.translateReportsToString(reports1)).thenReturn("out put");

        module.execute();

        verify(io, times(3)).handleOutputAndInput(any(IORequest.class));
        verify(reports, times(1)).buildReports(anyList());
        verify(translator, times(1)).translateReportsToString(reports1);
    }
}
