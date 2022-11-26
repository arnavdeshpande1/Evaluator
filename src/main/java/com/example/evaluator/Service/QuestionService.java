package com.example.evaluator.Service;

import com.example.evaluator.Model.Question;
import com.example.evaluator.Repository.ExamRepository;
import com.example.evaluator.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class QuestionService
{
    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    ExamRepository examRepository;

    public boolean addQuestion(Question question, int examid)
    {
        question.setExam(examRepository.findById(examid).get());
        questionRepo.save(question);
        return true;
    }
}
