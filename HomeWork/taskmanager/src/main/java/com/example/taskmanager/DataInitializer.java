package com.example.taskmanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final TaskService taskService;

    public DataInitializer(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Добавляем тестовые задачи
        Task task1 = new Task();
        task1.setName("Завершить Task 7 Spring Boot");
        task1.setDescription("Должен завершить задачу 7 из курса Java EE, используя Spring Boot framework. Использовать контроллеры и Thymeleaf Framework.");
        task1.setDeadlineDate("2024-12-23");
        task1.setCompleted(true);

        Task task2 = new Task();
        task2.setName("Очистить дом");
        task2.setDescription("Генеральная уборка всей квартиры");
        task2.setDeadlineDate("2024-12-20");
        task2.setCompleted(false);

        Task task3 = new Task();
        task3.setName("Изучить итальянский");
        task3.setDescription("Уроки итальянского языка каждый день");
        task3.setDeadlineDate("2024-12-31");
        task3.setCompleted(false);

        taskService.saveTask(task1);
        taskService.saveTask(task2);
        taskService.saveTask(task3);

        System.out.println("Тестовые задачи добавлены!");
    }
}