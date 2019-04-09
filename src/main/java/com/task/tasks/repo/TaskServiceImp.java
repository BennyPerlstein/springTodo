package com.task.tasks.repo;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.tasks.entities.Task;

@Service
public class TaskServiceImp implements TaskService  {
	
	@Autowired
	private TaskRepository repo;
	

	@Override
	public Task saveTask(Task task) {
		return repo.save(task);
		
	}

	@Override
	public Task updateTask(Task task) {
		return repo.save(task);//need to change
	}

	@Override
	public Collection<Task> viewAllTasks() {
		return repo.findAll();
	}

	@Override
	public void deleteTask(int id) {
		
		repo.deleteById(id);
		
	}

}
