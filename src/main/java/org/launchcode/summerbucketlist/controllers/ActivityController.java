package org.launchcode.summerbucketlist.controllers;

import org.launchcode.summerbucketlist.data.ActivityRepository;
import org.launchcode.summerbucketlist.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;
    @GetMapping("activities/index")
    public String displayAllActivities(Model model) {
        model.addAttribute("activities", activityRepository.findAll());
        return "activities/index";
    }

    @GetMapping("activities/create")
    public String renderCreateActivityForm() {
        return "activities/create";
    }

    @PostMapping("activities/create")
    public String processCreateActivityForm(@RequestParam String activityName, @RequestParam Boolean activityCompleted) {
        Activity newActivity = new Activity(activityName, activityCompleted);
        activityRepository.save(newActivity);
        return "redirect:/activities/index";
    }
}
