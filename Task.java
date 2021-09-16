//package com.example.lib;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

interface ITask {
    String
            String
    Duration
    getName();
    getDescription() ;
    getExpectedDuration();
    Iterable<ITask> getSubTasks() ;
    void addSubTask(ITask t) throws AlreadyExistsException; void removeSubTask(ITask t) throws NotFoundException;
}

public class Task {
    String name;
    String description;
    Duration estimatedDuration;
    LocalDateTime deadline;
    Set<Task> subtask = new HashSet<Task>();

    public Task(String name, String description, Duration estimatedDuration, LocalDateTime deadline) {
        this.name = name;
        this.description = description;
        this.estimatedDuration = estimatedDuration;
        this.deadline = deadline;
    }

    public Iterable<Task> getSubTasks(){
        return subtasks;
    }

    public void addSubtask(Task t) throws AlreadyExistsException{
        for(Task s: subtasks){
            if(s.getName() == t.getName() && s.getDescription() == t.getDescription() && s.getExpectedDuration() == t.getExpectedDuration()){
                throw new AlreadyExistsException("This subtask already exists!")
            }
        }
        subtask.add(t)
    }

    public void removeSubTask(Task t) throws NotFoundException{
        boolean isExist = false;
        for (Task s: subtasks){
            if(s.getName() == t.getName() && s.getDescription() == t.getDescription() && s.getExpectedDuration() == t.getExpectedDuration()){
                subtasks.remove(t);
                isExist = true;
            }
        }
        if(isExist == false){
            throw new NotFoundException("This subtask does not exist, so you cannot remove it!");
        }
    }

    public void removeSubtask(Task t){
        subtask.remove(t)
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Duration getEstimatedDuration() {
        return estimatedDuration;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String toString() {
        return  "Task: " + name + ", description: " + description + ", estimatedDuration: " + estimatedDuration + ", deadline: " + deadline + '.';
    }

    // Function to convert task object to XML
    public String taskToXML(){
        return "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>" + "\n"
                + "<task>" + "\n"
                + "    <name>" + getName() + "</name>" + "\n"
                + "    <description>" + getDescription() + "</description>" + "\n"
                + "    <duration>" + getEstimatedDuration() + "</duration>"+ "\n"
                + "    <deadline>" + getDeadline() + "</deadline>" + "\n"
                + "</task>";
    }

    public static void main(String[] args) throws IOException {
        //Sample task
        Task t1 = new Task("Task 1", "Task 1 description", Duration.ofHours(5), LocalDateTime.of(2000, 8, 31, 7, 30));
        Task t2 = new Task("Task 2", "Task 2 description", Duration.ofHours(5), LocalDateTime.of(2000, 8, 31, 7, 30));

//        System.out.println(t1.toString());

        // Adding subtask
        t1.addSubtask(t2);
        System.out.println(t2);
        System.out.println(t1.subtask);

        // Turn Task object to xml file
//        String xmlStr = t1.taskToXML();
//        java.io.FileWriter fw = new FileWriter("task.xml");
//        fw.write(xmlStr);
//        fw.close();
    }
}