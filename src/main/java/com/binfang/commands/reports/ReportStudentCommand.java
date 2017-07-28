package com.binfang.commands.reports;

import com.binfang.commands.CommandInterface;
import com.binfang.io.IOInterface;
import com.binfang.io.IORequest;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static com.binfang.commands.contants.PromptConstants.INPUT_CORRECT_STUDENT;
import static com.binfang.commands.contants.PromptConstants.INPUT_IDS;

/**
 * Created by bfhuang on 7/28/17.
 */
public class ReportStudentCommand implements CommandInterface {

    private final IOInterface io;
    private final ReportsCreator reportsCreator;
    private final ReportsOutputTranslator outputTranslator;

    public ReportStudentCommand(IOInterface io, ReportsCreator reports, ReportsOutputTranslator outputTranslator) {
        this.io = io;
        this.reportsCreator = reports;
        this.outputTranslator = outputTranslator;
    }

    @Override
    public void execute() {
        String input = io.handleOutputAndInput(new IORequest(INPUT_IDS, true));

        while (!Pattern.compile("^(\\d+,\\s)*\\d+$").matcher(input).matches()) {
            input = io.handleOutputAndInput(new IORequest(INPUT_CORRECT_STUDENT, true));
        }

        List<Report> reports = reportsCreator.buildReports(Arrays.asList(input.split(",\\s")));
        String output = outputTranslator.translateReportsToString(reports);

        io.handleOutputAndInput(new IORequest(output, false));

    }
}
