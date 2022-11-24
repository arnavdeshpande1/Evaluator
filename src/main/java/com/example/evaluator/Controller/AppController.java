package com.example.evaluator.Controller;


import com.example.evaluator.Model.Exam;
import com.example.evaluator.Model.ExamGuideline;
import com.example.evaluator.Service.ExamGuidelineService;
import com.example.evaluator.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/exam")
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
    public ResponseEntity<?> createGuideLine(@RequestBody ExamGuideline examGuideline)
    {
        return ResponseEntity.ok(examGuidelineService.addGuideline(examGuideline));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add/{examid}/{guidelineid}")
    public ResponseEntity<?> createExam(@PathVariable int examid, @PathVariable int guidelineid)
    {
        return ResponseEntity.ok(examService.linkExamWithExamGuideline(examid, guidelineid));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test/get/{examid}")
    public ResponseEntity<?> getExam(@PathVariable int examid)
    {
        System.out.println("in get exam api");
        return ResponseEntity.ok(examService.getGuideline(examid));
    }

}