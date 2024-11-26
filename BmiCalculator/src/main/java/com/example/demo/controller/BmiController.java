package com.example.demo.controller;

import com.example.demo.model.BmiData;
import com.example.demo.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BmiController {

    @Autowired
    private BmiService bmiService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("bmiData", new BmiData());
        return "bmi-form";
    }

    @PostMapping("/calculate")
    public String calculateBmi(BmiData bmiData, Model model) {
        bmiService.calculateBmi(bmiData);
        model.addAttribute("bmiData", bmiData);
        return "bmi-form";
    }
}