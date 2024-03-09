package myjava.mystreams.OpenClose;

public class RunInterview {
    public static void main(String[] args) {
        new RunInterview();
    }

    RunInterview(){
        InterviewQuestionProcessor interviewQuestionProcessor = new InterviewQuestionProcessor();

        interviewQuestionProcessor.conductInterview(new AIInterview());
        interviewQuestionProcessor.conductInterview(new FinanceInterview());
        interviewQuestionProcessor.conductInterview(new DSInterview());
    }
}
