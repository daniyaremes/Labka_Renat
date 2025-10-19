package com.example.studentsystem.service;

import com.example.studentsystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);
    public StudentService() {
        addStudent(new Student(null, "Renat", "Mykysh", 88, null));
        addStudent(new Student(null, "Dias", "Zhumabekov", 99, null));
        addStudent(new Student(null, "Malades", "Adamdar",49, null));
        addStudent(new Student(null, "Men", "Qazakpyn",50, null));

    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public void addStudent(Student student) {
        student.setId(counter.getAndIncrement());
        student.calculateMark();
        students.add(student);
    }

    public List<Student> searchStudents(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllStudents();
        }

        String searchTerm = keyword.toLowerCase();
        return students.stream()
                .filter(student ->
                        student.getName().toLowerCase().contains(searchTerm) ||
                                student.getSurname().toLowerCase().contains(searchTerm) ||
                                student.getMark().toLowerCase().contains(searchTerm))
                .toList();
    }
}