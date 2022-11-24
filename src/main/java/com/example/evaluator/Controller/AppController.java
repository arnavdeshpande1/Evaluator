package com.example.evaluator.Controller;


import com.example.evaluator.Model.Exam;
import com.example.evaluator.Model.ExamGuideline;
import com.example.evaluator.Service.ExamGuidelineService;
import com.example.evaluator.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exam")
public class AppController implements ErrorController {

    @Autowired
    ExamService examService;

    @Autowired
    ExamGuidelineService examGuidelineService;


    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }

//    @Override
//    public String getErrorPath() {
//        return PATH;
//    }

    @RequestMapping(value = "/login")
    public String login()
    {
        return "login";
    }

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