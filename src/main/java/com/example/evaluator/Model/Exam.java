package com.example.evaluator.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test")
public class Exam {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testid;

    private int examCheckStatus;


    @OneToMany(mappedBy = "exam")
    private List<Question> questions = new ArrayList<Question>();

    @ManyToOne
    private ExamGuideline examGuideline;

    public Exam()
    {

    }

    public Exam(int testid, int examCheckStatus, List<Question> questions, ExamGuideline examGuideline) {
        this.testid = testid;
        this.examCheckStatus = examCheckStatus;
        this.questions = questions;
        this.examGuideline = examGuideline;
    }

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public int getExamCheckStatus() {
        return examCheckStatus;
    }

    public void setExamCheckStatus(int examCheckStatus) {
        this.examCheckStatus = examCheckStatus;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public ExamGuideline getExamGuideline() {
        return examGuideline;
    }

    public void setExamGuideline(ExamGuideline examGuideline) {
        this.examGuideline = examGuideline;
    }


}