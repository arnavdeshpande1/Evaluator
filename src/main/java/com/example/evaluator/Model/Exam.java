package com.example.evaluator.Model;

import javax.persistence.*;

@Entity
@Table(name = "test")
public class Exam {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testid;

    @ManyToOne
    private ExamGuideline examGuideline;

    public Exam()
    {

    }

    public Exam(int testid, ExamGuideline examGuideline) {
        this.testid = testid;
        this.examGuideline = examGuideline;
    }

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public ExamGuideline getExamGuideline() {
        return examGuideline;
    }

    public void setExamGuideline(ExamGuideline examGuideline) {
        this.examGuideline = examGuideline;
    }
}