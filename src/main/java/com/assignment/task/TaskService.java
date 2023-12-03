package com.assignment.task;

import java.util.List;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task geTaskById(Long id){
         Task existingEntity = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
        return existingEntity;
    }

    public Task createTask(Task task){

        return taskRepository.save(task);
    }

    public Task updateById(Long id, Task updatedEntity) {
        // Step 1: Fetch the entity by ID
        Task existingEntity = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));

        // Step 2: Modify the relevant fields
        existingEntity.setTitle(updatedEntity.getTitle());
        existingEntity.setDescription(updatedEntity.getDescription());
        existingEntity.setCompleted(updatedEntity.isCompleted());

        // Step 3: Save the entity back to the database
        return taskRepository.save(existingEntity);
    }


    public void deleteTaskById(Long id){
         taskRepository.deleteById(id);
    }

}
