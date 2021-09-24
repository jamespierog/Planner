package com.example.lib;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Project implements IProject{
    String name;
    String description;
    Set<Task> tasks = new HashSet<Task>();


    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Iterable<Task> getTasks(){
        return tasks;
    }

    public String toString() {
        return  "Project: " + name + ", description: " + description + '.';
    }

    public void addTask(Task t) throws AlreadyExistsException{
        for(Task s: tasks){
            if(s.getName() == t.getName() && s.getDescription() == t.getDescription() && s.getEstimatedDuration() == t.getEstimatedDuration()){
                throw new AlreadyExistsException("This task already exists!");
            }
        }
        tasks.add(t);
    }

    public void removeTask(Task t) throws NotFoundException{
        boolean isExist = false;
        for (Task s: tasks){
            if(s.getName() == t.getName() && s.getDescription() == t.getDescription() && s.getEstimatedDuration() == t.getEstimatedDuration()){
                tasks.remove(t);
                isExist = true;
                break;
            }
        }
        if(isExist == false){
            throw new NotFoundException("This subtask does not exist, so you cannot remove it!");
        }
    }

    public String projectToXML(){
        String res = "";
        for (Task t: tasks){
            res = res + t.taskToXML();
        }
        return "    <project>" + "\n"
                + "        <name>" + getName() + "</name>" + "\n"
                + res
                + "    </project>" + "\n";
    }
}
