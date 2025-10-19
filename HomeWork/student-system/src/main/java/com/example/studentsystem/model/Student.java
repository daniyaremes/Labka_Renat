package com.example.studentsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String surname;
    private int exam;
    private String mark;

    public void calculateMark() {
        if (exam >= 90) {
            this.mark = "A";
        } else if (exam >= 75) {
            this.mark = "B";
        } else if (exam >= 60) {
            this.mark = "C";
        } else if (exam >= 50) {
            this.mark = "D";
        } else {
            this.mark = "F";
        }
    }
}