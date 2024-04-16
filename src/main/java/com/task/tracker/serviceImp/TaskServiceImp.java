package com.task.tracker.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.task.tracker.entity.Task;
import com.task.tracker.repository.TaskRepository;
import com.task.tracker.service.TaskService;

public class TaskServiceImp implements TaskService{
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<Task> getAllTask() {
		List<Task> taskList=taskRepository.findAll();
		if(!taskList.isEmpty()) {
			return taskList;
		}
		else {
			return null;
		}
	
	}

	@Override
	public Task getTaskById(Integer id) {
		
		try {
			Optional<Task> task=taskRepository.findById(id);
			if(task.isPresent()) {
				return task.get();
			}
		} catch (Exception e) {
			
		}
		
		return null;
	}

	@Override
	public Task addTask(Task task) {
		return taskRepository.save(task);
		
		
		}
		
	
	@Override
	public Task updateTask(Task task, Integer id) {
		
		return null;
	}

	@Override
	public boolean deleteTaskById(Integer id) {

		Optional<Task> task=taskRepository.findById(id);
		if(task.isPresent()) {
			taskRepository.deleteById(id);
			return true;
		}
		return false;
		
	}

}
