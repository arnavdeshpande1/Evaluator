package com.example.evaluator.Controller;


import com.example.evaluator.Model.Exam;
import com.example.evaluator.Model.ExamGuideline;
import com.example.evaluator.Repository.ExamRepository;
import com.example.evaluator.Service.ExamGuidelineService;
import com.example.evaluator.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
public class AppController {

    @Autowired
    ExamService examService;

    @Autowired
    ExamGuidelineService examGuidelineService;


    @RequestMapping(method = RequestMethod.POST, value = "/guideline/add")
    public String createGuideLine(@RequestBody ExamGuideline examGuideline)
    {
        return examGuidelineService.addGuideline(examGuideline);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add/{examid}/{guidelineid}")
    public String createExam(@PathVariable int examid, @PathVariable int guidelineid)
    {
        return examService.linkExamWithExamGuideline(examid, guidelineid);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/guideline/get/{examid}")
    public Exam getExam(@PathVariable int examid)
    {
        return examService.getGuideline(examid);
    }

}