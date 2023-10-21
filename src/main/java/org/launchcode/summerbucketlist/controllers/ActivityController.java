//package org.launchcode.summerbucketlist.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.*;
//import java.util.Map.Entry;
//
//@Controller
//@RequestMapping("activities")
//public class ActivityController {
//
//    private static HashMap<String, Boolean> activities;
//
//    @GetMapping
//    public String displayAllActivities(Model model) {
//        model.addAttribute("activities", activ());
//        return "activities/index";
//    }
//
//    @GetMapping("create")
//    public String renderCreateActivityForm() {
//        return "activities/create";
//    }
//
//    @PostMapping("create")
//    public String createActivity(@RequestParam String activityName, @RequestParam Boolean activityCompleted) {
//        activities.put(activityName, activityCompleted);
//        return "redirect:";
//    }
//}
