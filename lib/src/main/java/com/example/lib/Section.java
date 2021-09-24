package com.example.lib;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Section implements ISection {
    String name;
    Set<Task> tasks = new HashSet<Task>();

    public Section(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Iterable<Task> getTasks(){
        return tasks;
    }

    public String toString() {
        return  "Section: " + name + '.';
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

    public String sectionToXML(){
        String res = "";
        for (Task t: tasks){
            res = res + t.taskSectionToXML();
        }
        return "        <section>" + "\n"
                + "            <name>" + getName() + "</name>" + "\n"
                + res
                + "        </section>" + "\n";
    }
}
