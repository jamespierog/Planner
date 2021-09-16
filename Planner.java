import java.io.FileWriter;
import java.io.IOException;
// import java.time.Duration;
// import java.time.LocalDateTime;

class AlreadyExistsException extends Exception {};
class NotFoundException extends Exception {};

public class Planner {
    Set<Project> projects = new TreeSet<Project>();
    Set<Board> boards = new TreeSet<Board>();

    public Iteratable<Project> getProjects(){
        return projects;
    }

    public Iteratable<Board> getBoards(){
        return boards;
    }

    public void addProject(Project p){
        for(Project s: projects){
            if(s.getName() == p.getName() && s.getDescription() == p.getDescription() && s.getDeadline() == p.getDeadline()){
                throw new AlreadyExistsException("This project already exists!")
            }
        }
        projects.add(p);
    }

    public void removeProject(Project p){
        boolean isExist = false;
        for (Project s: projects){
            if(s.getName() == p.getName() && s.getDescription() == p.getDescription() && s.getDeadline() == p.getDeadline()){
                projects.remove(t);
                isExist = true;
            }
        }
        if(isExist == false){
            throw new NotFoundException("This project does not exist, so you cannot remove it!");
        }
    }

    public void addBoard(Board b){
        for(Board s: boards){
            if(s.getName() == b.getName()){
                throw new AlreadyExistsException("This board already exists!")
            }
        }
        boards.add(b);
    }

    public void removeBoard(Project b){
        boolean isExist = false;
        for (Board s: boards){
            if(s.getName() == b.getName()){
                boards.remove(b);
                isExist = true;
            }
        }
        if(isExist == false){
            throw new NotFoundException("This board does not exist, so you cannot remove it!");
        }
        }

        // void addBoard(IBoard b) throws AlreadyExistsException;
        // void addProject(IProject p) throws AlreadyExistsException; Iterable<IBoard> getBoards();
        // Iterable<IProject> getProjects();
        // public String writeXMLData();
    /*
        input: raw data from an XML file.
    */
        // public void readXMLData(String data);

        // Function to convert project object to XML
        public String plannerToXML(){
            return "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>" + "\n"
                    + "<planner>" + "\n"
                    + "    <project>" + getProject() + "</project>" + "\n"
                    + "</planner>";
        }

        public static void main(String[] args) throws IOException {
            //Sample Planner
            Planner p1 = new Planner();

            // Turn Project object to xml file
            String xmlStr = p1.plannerToXML();
            java.io.FileWriter fw = new FileWriter("planner.xml");
            fw.write(xmlStr);
            fw.close();
        }
    }
