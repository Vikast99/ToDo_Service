package com.task.tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.task.tracker.entity.Task;

@Service
public interface TaskService {
	
	public List<Task>  getAllTask();
	
	public Task getTaskById(Integer id);
	
	public Task addTask(Task task);
	
	public Task updateTask(Task task,Integer id);
	
	public boolean deleteTaskById(Integer id);

}
