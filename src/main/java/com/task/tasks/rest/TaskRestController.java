package com.task.tasks.rest;

import java.io.IOException;
import java.util.Collection;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.tasks.entities.Task;
import com.task.tasks.repo.TaskServiceImp;

@RestController
@RequestMapping("tasks")
public class TaskRestController {

	@Autowired
	private TaskServiceImp taskService;
	
//	@RequestMapping(method=RequestMethod.POST, path="add")
//	public Task storeTask(@RequestBody Task task) {
//		System.out.println(task);
//		return taskService.saveTask(task);
//	}
//	
//	@RequestMapping(method=RequestMethod.PUT, path="update")
//	public Task updateTask(@RequestBody Task task) {
//		System.out.println(task);
//		return taskService.updateTask(task);
//	}
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@RequestMapping(method=RequestMethod.POST, path="add")
//	public void storeTask(@RequestBody Task task) {
//		System.out.println(task);
//		taskService.saveTask(task);
//	}
//	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@RequestMapping(method=RequestMethod.PUT, path="update")
//	public void updateTask(@RequestBody Task task) {
//		System.out.println(task);
//		taskService.updateTask(task);
//	}
//	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@RequestMapping(method=RequestMethod.GET, path="all")
//	public Collection<Task> allTasks(){
//		return taskService.viewAllTasks();
//	}
	
	
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Task>  storeTask(@RequestBody String task) {
		
		String finalTask = task.substring(8, task.length()-1);
		
		Task bean = null;
		try {
			bean = new ObjectMapper()
				      .readerFor(Task.class)
				      .readValue(finalTask);
		} catch (IOException e) {
			e.printStackTrace();
		}
		taskService.saveTask(bean);
		return new ResponseEntity<Task>(bean,HttpStatus.OK);
	}
	
//	@CrossOrigin
//	@RequestMapping(method=RequestMethod.PUT)
//	public void updateTask(@RequestBody Task task) {
//		System.out.println(task);
//		taskService.updateTask(task);
//	}
	
	@CrossOrigin
	@RequestMapping(value = "{id}", method=RequestMethod.PATCH)
	public String updateTask(@PathVariable("id") int id, @RequestBody String task) {
		String finalTask = task.substring(8, task.length()-1);
		
		Task bean = null;
		try {
			bean = new ObjectMapper()
				      .readerFor(Task.class)
				      .readValue(finalTask);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		taskService.updateTask(bean);
		return "{}"; 
	}
	
//	@CrossOrigin
//	@RequestMapping(value = "{id}", method=RequestMethod.PATCH)
//	public String updateTask(@PathVariable("id") int id, @RequestBody Task task) {
//		System.out.println(task);
//		taskService.updateTask(task);
//		return "{}"; 
//	}
	
	@CrossOrigin
	@RequestMapping(value = "{id}", method=RequestMethod.DELETE)
	public String deleteTask(@PathVariable("id") int id) {
		System.out.println(id);
		taskService.deleteTask(id);
		return "{}";
	}
	

	
	@RequestMapping(method=RequestMethod.GET)
	public Collection<Task> allTasks(){
		return taskService.viewAllTasks();
	}
	
}
