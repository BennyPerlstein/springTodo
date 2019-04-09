package com.task.tasks.repo;

import java.util.Collection;

import com.task.tasks.entities.Task;

public interface TaskService {

	Task saveTask(Task task);
	Task updateTask(Task task);
	void deleteTask(int id);
	Collection<Task> viewAllTasks();
}
