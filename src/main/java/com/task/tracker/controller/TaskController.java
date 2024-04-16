package com.task.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.tracker.entity.Task;
import com.task.tracker.service.TaskService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<Task>> findAllTask(){
	log.info("fetching all tasks");
	return new ResponseEntity<List<Task>>(taskService.getAllTask(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable Integer id){
		log.info("get Task By Id");
		return new ResponseEntity<Task>(taskService.getTaskById(id),HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Task> addTask(@RequestBody Task task){
		log.info("adding new task");
		return new ResponseEntity<Task>(taskService.addTask(task),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTaskById(@PathVariable Integer id){
		log.info("deleting task by id");
		taskService.deleteTaskById(id);
		return new ResponseEntity<String>("Task deleted",HttpStatus.OK);
	}
	

}
