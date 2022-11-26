package com.example.evaluator.Controller;


import com.example.evaluator.Model.Exam;
import com.example.evaluator.Model.ExamGuideline;
import com.example.evaluator.Model.Question;
import com.example.evaluator.Service.ExamGuidelineService;
import com.example.evaluator.Service.ExamService;
import com.example.evaluator.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
//@RequestMapping("/exam")
public class AppController implements ErrorController {

    @Autowired
    ExamService examService;

    @Autowired
    ExamGuidelineService examGuidelineService;


    @Autowired
    QuestionService questionService;

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }

//    @Override
//    public String getErrorPath() {
//        return PATH;
//    }

//    @RequestMapping(value = "/")
//    public Iterable<Exam> getexamid()
//    {
//        return examService.listAll();
//    }

//    @RequestMapping(value="/first")
////    @ResponseBody
//    public String getTest()
//    {
//        return "first";
//    }

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

    @RequestMapping(method = RequestMethod.GET, value = "/test/get/{examid}")
    public List<Exam> getExam(@PathVariable int examid)
    {
        System.out.println("in get exam api");
        return examService.getGuideline(examid);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exam/status/{guideLineId}")
    public List<Exam> getStatus(@PathVariable Integer guideLineId)
    {
        return examService.getSummary(guideLineId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/pendingPapers/{guideLineId}")
    public List<Exam> getPapers(@PathVariable Integer guideLineId)
    {
        return examService.getUncheckedPaper(guideLineId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/question/add/{examid}")
    public boolean addQuestion(@RequestBody Question question,  @PathVariable Integer examid)
    {
        return questionService.addQuestion(question, examid);
    }

}