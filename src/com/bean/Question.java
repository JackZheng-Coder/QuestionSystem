package com.bean;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class Question {
    private int questionId;
    private String questionName;
    private String questionBeizhu;
    private int questionDifficlty;

    public Question(){}

    public Question(int questionId, String questionName, String questionBeizhu, int questionDifficlty) {
        this.questionId = questionId;
        this.questionName = questionName;
        this.questionBeizhu = questionBeizhu;
        this.questionDifficlty = questionDifficlty;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public void setQuestionBeizhu(String questionBeizhu) {
        this.questionBeizhu = questionBeizhu;
    }

    public void setQuestionDifficlty(int questionDifficlty) {
        this.questionDifficlty = questionDifficlty;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public String getQuestionBeizhu() {
        return questionBeizhu;
    }

    public int getQuestionDifficlty() {
        return questionDifficlty;
    }
}
