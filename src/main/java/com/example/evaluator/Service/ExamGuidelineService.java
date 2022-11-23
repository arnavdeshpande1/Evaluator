package com.example.evaluator.Service;

import com.example.evaluator.Model.ExamGuideline;
import com.example.evaluator.Repository.ExamGuidelineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamGuidelineService
{
    @Autowired
    ExamGuidelineRepo examGuidelineRepo;

    public String addGuideline(ExamGuideline examGuideline)
    {
        System.out.println(examGuideline);
        examGuidelineRepo.save(examGuideline);
        return "Work is done";
    }
}
