package org.launchcode.summerbucketlist.controllers;

import org.launchcode.summerbucketlist.data.ActivityRepository;
import org.launchcode.summerbucketlist.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("activities")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping("index")
    public String displayAllActivities(Model model) {
        model.addAttribute("title", "All Activities");
        model.addAttribute("activities", activityRepository.findAll());
        return "activities/index-activities";
    }

    @GetMapping("create")
    public String renderCreateActivityForm() {
        return "activities/create-activity";
    }

    @PostMapping("create")
    public String processCreateActivityForm(@RequestParam String activityName, @RequestParam Boolean activityCompleted) {
        Activity newActivity = new Activity(activityName, activityCompleted);
        activityRepository.save(newActivity);
        return "redirect:index";
    }

    @GetMapping("update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid activity Id:" + id));

        model.addAttribute("activity", activity);
        return "update-activity";
    }

    @PostMapping("update/{id}")
    public String updateActivity(@PathVariable("id") int id, @Valid Activity activity,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            activity.setId(id);
            return "update-activity";
        }

        activityRepository.save(activity);
        return "redirect:/activities/index";
    }

    @PostMapping("/delete/{id}")
    public String deleteActivity(@PathVariable("id") int id, Model model) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id: " + id));
        activityRepository.delete(activity);
        return "redirect:/activities/index";
    }
}
