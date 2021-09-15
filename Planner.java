
public class Planner {
    String project;

    public Planner(String project) {
        this.project = project;
    }

    public String getProject() {
        return project;
    }


    public String toString() {
        return  "Project: " + name ;
    }

    // Function to convert project object to XML
    public String plannerToXML(){
        return "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>" + "\n"
                + "<planner>" + "\n"
                + "    <name>" + getName() + "</name>" + "\n"
                + "    <description>" + getDescription() + "</description>" + "\n"
                + "    <deadline>" + getDeadline() + "</deadline>" + "\n"
                + "</planner>";
    }

    public static void main(String[] args) throws IOException {
        //Sample Planner
        Planner p1 = new Planner("Planner 1", "Planner 1 description", Duration.ofHours(5), LocalDateTime.of(2000, 8, 31, 7, 30));

        // Turn Project object to xml file
        String xmlStr = t1.plannerToXML();
        java.io.FileWriter fw = new FileWriter("planner.xml");
        fw.write(xmlStr);
        fw.close();
    }
}
