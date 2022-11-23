package com.example.evaluator.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ExamGuideline
{
    @Id
    private int id;

    private int mcqPositive;
    private int mcqNegative;
    private int msqPositive;
    private int msqNegative;

    @OneToMany(mappedBy = "examGuideline")
    @JsonIgnore
    List<Exam> exams = new ArrayList<Exam>();

    public ExamGuideline()
    {

    }

    public ExamGuideline(int id, int mcqPositive, int mcqNegative, int msqPositive, int msqNegative, List<Exam> exams) {
        this.id = id;
        this.mcqPositive = mcqPositive;
        this.mcqNegative = mcqNegative;
        this.msqPositive = msqPositive;
        this.msqNegative = msqNegative;
        this.exams = exams;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMcqPositive() {
        return mcqPositive;
    }

    public void setMcqPositive(int mcqPositive) {
        this.mcqPositive = mcqPositive;
    }

    public int getMcqNegative() {
        return mcqNegative;
    }

    public void setMcqNegative(int mcqNegative) {
        this.mcqNegative = mcqNegative;
    }

    public int getMsqPositive() {
        return msqPositive;
    }

    public void setMsqPositive(int msqPositive) {
        this.msqPositive = msqPositive;
    }

    public int getMsqNegative() {
        return msqNegative;
    }

    public void setMsqNegative(int msqNegative) {
        this.msqNegative = msqNegative;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "ExamGuideline{" +
                "id=" + id +
                ", mcqPositive=" + mcqPositive +
                ", mcqNegative=" + mcqNegative +
                ", msqPositive=" + msqPositive +
                ", msqNegative=" + msqNegative +
                ", exams=" + exams +
                '}';
    }
}
