package com.task.tasks.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.tasks.entities.Task;


public interface TaskRepository extends JpaRepository<Task, Integer> {
		

}
