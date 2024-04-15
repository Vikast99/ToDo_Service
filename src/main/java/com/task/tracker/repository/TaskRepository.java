package com.task.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.tracker.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
