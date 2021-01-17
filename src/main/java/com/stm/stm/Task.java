package com.stm.stm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;
    private String title;
    private String description;
    private LocalDateTime dateAdded=LocalDateTime.now();
    private enum type{TASK, BUG, FEATURE};
    private enum status{NEW,IN_PROGRESS,DONE};
    private type taskType;
    private status taskStatus;


    public Task(String title, String description) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        taskType=type.TASK;
        taskStatus=status.NEW;
    }

}
