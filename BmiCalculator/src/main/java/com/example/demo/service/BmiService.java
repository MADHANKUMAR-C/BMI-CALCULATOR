package com.example.demo.service;

import com.example.demo.model.BmiData;
import org.springframework.stereotype.Service;

@Service
public class BmiService {

    public void calculateBmi(BmiData bmiData) {
        double heightInMeters = bmiData.getHeight() / 100;
        double bmi = bmiData.getWeight() / (heightInMeters * heightInMeters);
        bmiData.setBmi(Math.round(bmi * 10.0) / 10.0);

        if (bmi < 18.5) {
            bmiData.setCategory("Underweight");
        } else if (bmi < 26.3) {
            bmiData.setCategory("Normal weight");
        } else if (bmi < 30) {
            bmiData.setCategory("Overweight");
        } else {
            bmiData.setCategory("Obese");
        }
    }
}