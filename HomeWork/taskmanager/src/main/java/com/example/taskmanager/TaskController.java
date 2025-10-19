package com.example.taskmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getAllTasks(Model model) {
        System.out.println("=== GET /tasks called ===");
        var tasks = taskService.getAllTasks();
        System.out.println("Tasks count: " + tasks.size());
        tasks.forEach(task -> System.out.println("Task: " + task.getName()));

        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/new")
    public String showTaskForm(Model model) {
        System.out.println("=== GET /tasks/new called ===");
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        System.out.println("=== GET /tasks/edit/" + id + " called ===");
        Task task = taskService.getTaskById(id);
        if (task == null) {
            System.out.println("Task not found with id: " + id);
            return "redirect:/tasks";
        }
        model.addAttribute("task", task);
        return "task-form";
    }

    @GetMapping("/test-bootstrap")
    public String testBootstrap() {
        return "test-bootstrap";
    }

    @GetMapping("/details/{id}")
    public String viewTaskDetails(@PathVariable Long id, Model model) {
        System.out.println("=== GET /tasks/details/" + id + " called ===");
        Task task = taskService.getTaskById(id);
        if (task == null) {
            System.out.println("Task not found with id: " + id);
            return "redirect:/tasks";
        }
        model.addAttribute("task", task);
        return "task-details";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute Task task) {
        System.out.println("=== POST /tasks/save called ===");
        System.out.println("Task to save: " + task.getName() + ", ID: " + task.getId());
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        System.out.println("=== GET /tasks/delete/" + id + " called ===");
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}