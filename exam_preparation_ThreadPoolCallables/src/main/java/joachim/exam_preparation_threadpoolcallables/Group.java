package joachim.exam_preparation_threadpoolcallables;

/**
 *
 * @author craci
 */
public class Group {
    private String authors;
    private String classD;
    private String group;

    public Group(String authors, String classD, String group) {
        this.authors = authors;
        this.classD = classD;
        this.group = group;
    }

    
    
    /**
     * @return the authors
     */
    public String getAuthors() {
        return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * @return the classD
     */
    public String getClassD() {
        return classD;
    }

    /**
     * @param classD the classD to set
     */
    public void setClassD(String classD) {
        this.classD = classD;
    }

    /**
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(String group) {
        this.group = group;
    }
    
}
