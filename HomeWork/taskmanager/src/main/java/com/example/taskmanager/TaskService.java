package com.example.taskmanager;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public Task getTaskById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void saveTask(Task task) {
        if (task.getId() == null) {
            task.setId(counter.getAndIncrement());
            tasks.add(task);
        } else {
            Task existingTask = getTaskById(task.getId());
            if (existingTask != null) {
                existingTask.setName(task.getName());
                existingTask.setDescription(task.getDescription());
                existingTask.setDeadlineDate(task.getDeadlineDate());
                existingTask.setCompleted(task.isCompleted());
            }
        }
    }

    public void deleteTask(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}