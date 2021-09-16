import java.io.FileWriter;
import java.io.IOException;
// import java.time.Duration;
// import java.time.LocalDateTime;

class AlreadyExistsException extends Exception {};
class NotFoundException extends Exception {};

public class Planner {
    String project;

    public Planner(String project) {
        this.project = project;
    }

    public String getProject() {
        return project;
    }


    public String toString() {
        return  "Project: " + project ;
    }

    void addBoard(IBoard b) throws AlreadyExistsException;
    void addProject(IProject p) throws AlreadyExistsException; Iterable<IBoard> getBoards();
    Iterable<IProject> getProjects();
    public String writeXMLData();
    /*
        input: raw data from an XML file.
    */
    public void readXMLData(String data);

    // Function to convert project object to XML
    public String plannerToXML(){
        return "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>" + "\n"
                + "<planner>" + "\n"
                + "    <project>" + getProject() + "</project>" + "\n"
                + "</planner>";
    }

    public static void main(String[] args) throws IOException {
        //Sample Planner
        Planner p1 = new Planner("Planner 1");

        // Turn Project object to xml file
        String xmlStr = p1.plannerToXML();
        java.io.FileWriter fw = new FileWriter("planner.xml");
        fw.write(xmlStr);
        fw.close();
    }
}
