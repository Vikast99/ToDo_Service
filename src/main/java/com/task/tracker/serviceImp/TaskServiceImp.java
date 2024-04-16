package com.task.tracker.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.task.tracker.entity.Task;
import com.task.tracker.repository.TaskRepository;
import com.task.tracker.service.TaskService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaskServiceImp implements TaskService{
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<Task> getAllTask() {
		
		try {
			List<Task> taskList=taskRepository.findAll();
			if(!taskList.isEmpty()) {
				return taskList;
			}
			
		}catch (Exception e) {
			log.error("exception "+ e);
		}
		
			return null;
	
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
	public Task updateTask(Task newTask, Integer id) {
		
		Optional<Task> task = taskRepository.findById(id);
		if(task.isPresent()) {
			if(!newTask.getTitle().equals(null)) {
				task.get().setTitle(newTask.getTitle());
			}
			if(!newTask.getDescription().equals(null)) {
				task.get().setDescription(newTask.getDescription());
			}
			taskRepository.save(task.get());
		}
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
