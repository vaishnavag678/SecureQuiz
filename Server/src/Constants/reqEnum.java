package Constants;


public enum reqEnum {
    LoginRequest("01"),
    SignupRequest("02"),
    SubjectAddRequestStudent("03"),
    SubjectAddRequestTeacher("04"),
    QuizAddRequest("05"),
    SubjectListFetchRequestStudent("06"),
    SubjectListFetchRequestTeacher("07"),
    QuizListFetchRequestTeacher("08"),
    QuizListFetchRequestStudent("09"),
    ScoreFetchRequest("10"),
    QuizResponseRequest("11"),
    RankFetchRequest("12"),
    QuestionFetchRequest("13"),
    QuestionAddRequest("14"),
    DeactivateQuizRequest("15");




    reqEnum(String s)
    {
        s.toString();
    }
}
