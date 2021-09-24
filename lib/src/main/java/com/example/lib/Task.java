package com.example.lib;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class Task implements ITask{
    String name;
    String description;
    Duration estimatedDuration;
    Set<Task> subtasks = new HashSet<Task>();

    public Task(String name, String description, Duration estimatedDuration) {
        this.name = name;
        this.description = description;
        this.estimatedDuration = estimatedDuration;
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

    public Iterable<Task> getSubTasks(){
        return subtasks;
    }

    public String toString() {
        return  "Task: " + name + ", description: " + description + ", estimatedDuration: " + estimatedDuration + '.';
    }

    @Override
    public void addSubTask(Task t) throws AlreadyExistsException {
        for (Task s: subtasks){
            if(s.getName() == t.getName() && s.getDescription() == t.getDescription() && s.getEstimatedDuration() == t.getEstimatedDuration()){
                throw new AlreadyExistsException("This subtask already exists!");
            }
        }
        subtasks.add(t);
    }

    @Override
    public void removeSubTask(Task t) throws NotFoundException{
        boolean isExist = false;
        for (Task s: subtasks){
            if(s.getName() == t.getName() && s.getDescription() == t.getDescription() && s.getEstimatedDuration() == t.getEstimatedDuration()){
                subtasks.remove(t);
                isExist = true;
                break;
            }
        }
        if(isExist == false){
            throw new NotFoundException("This subtask does not exist, so you cannot remove it!");
        }
    }

    // Function to convert task object to XML -- accounting subtask
    public String taskToXML(){
        String res = "        <task>" + "\n"
                + "            <name>" + getName() + "</name>" + "\n"
                + "            <description>" + getDescription() + "</description>" + "\n"
                + "            <duration>" + getEstimatedDuration() + "</duration>"+ "\n";
        for (Task t: subtasks) {
            res = res + t.subtaskToXML();
        }
        res = res + "        </task>" + "\n";
        return res;
    }

    // Function to convert task object to XML -- without accounting subtask
//    public String taskToXML(){
//        return "        <task>" + "\n"
//                + "            <name>" + getName() + "</name>" + "\n"
//                + "            <description>" + getDescription() + "</description>" + "\n"
//                + "            <duration>" + getEstimatedDuration() + "</duration>"+ "\n"
//                + "        </task>" + "\n";
//    }

    // Function to convert subtask
    public String subtaskToXML(){
        return "            <subtask>" + "\n"
                + "                <name>" + getName() + "</name>" + "\n"
                + "                <description>" + getDescription() + "</description>" + "\n"
                + "                <duration>" + getEstimatedDuration() + "</duration>"+ "\n"
                + "            </subtask>" + "\n";
    }

    // Function to convert task in sections to XML
    public String taskSectionToXML(){
        return "            <task>" + "\n"
                + "                <name>" + getName() + "</name>" + "\n"
                + "                <description>" + getDescription() + "</description>" + "\n"
                + "                <duration>" + getEstimatedDuration() + "</duration>"+ "\n"
                + "            </task>" + "\n";
    }


}