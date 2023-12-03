package com.assignment.task;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TaskRepository
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
}