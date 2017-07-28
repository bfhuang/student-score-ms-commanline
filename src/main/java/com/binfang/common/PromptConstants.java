package com.binfang.common;

/**
 * Created by bfhuang on 7/27/17.
 */
public interface PromptConstants {

    String MAIN_MENU = "1. 添加学生\n" +
            "2. 生成成绩单\n" +
            "3. 退出\n" +
            "请输入你的选择（1～3）：";
    String ADD_STUDENT_SUCCESS = "学生%s的成绩被添加\n";

    String INCORRECT_MENU_CHOICE = "你的输入不正确,请输入正确的选项:\n";

    String INPUT_STUDENT = "请输入学生信息（格式：姓名, 学号, 班级, 数学:分数, " +
            "语文:分数, 英语:分数, 编程:分数）, 按回车提交：";

    String INPUT_CORRECT_STUDENT = "请按正确的格式输入（格式：姓名, 学号, 班级, 数学:分数," +
            " 语文:分数, 英语:分数, 编程:分数）：";

    String REPORT = "成绩单\n" +
            "姓名|数学|语文|英语|编程|平均分|总分 \n" +
            "========================\n" +
            "%s\n" +
            "========================\n" +
            "全班总分平均数：%s\n" +
            "全班总分中位数：%s\n";
    String INPUT_IDS = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
    String INPUT_CORRECT_IDS = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
}
