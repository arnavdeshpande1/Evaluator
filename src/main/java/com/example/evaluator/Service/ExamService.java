package com.example.evaluator.Service;

import com.example.evaluator.Model.Exam;
import com.example.evaluator.Model.ExamGuideline;
import com.example.evaluator.Repository.ExamGuidelineRepo;
import com.example.evaluator.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExamService
{
    @Autowired
    ExamRepository examRepository;

    @Autowired
    ExamGuidelineRepo examGuidelineRepo;


//    public Iterable<Exam> listAll()
//    {
//        return this.examRepository.findAll();
//    }


    public String linkExamWithExamGuideline(int examid, int guideineLine)
    {
        Optional<ExamGuideline> examGuideline = examGuidelineRepo.findById(guideineLine);
        if (examGuideline.isEmpty())
        {
            return "guideline id not exist";
        }
        ExamGuideline obj = examGuideline.get();
        Exam exam = new Exam();
        exam.setTestid(examid);
        exam.setExamGuideline(obj);
        examRepository.save(exam);
        return "test linked";
    }

    public Exam getGuideline(int examid)
    {
        Optional<Exam> exam = examRepository.findById(examid);
        if (exam.isEmpty())
        {
//            return "ID dose not exist";
            return new Exam();

        }
        Exam obj = exam.get();
        return obj;
//        return "ID exist";
    }
}
