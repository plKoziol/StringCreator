package pl.koziol.model;

public class UniqueString {
    private int id;
    private String uniqueString;
    private int idProcess;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUniqueString() {
        return uniqueString;
    }

    public void setUniqueString(String uniqueString) {
        this.uniqueString = uniqueString;
    }

    public int getIdProcess() {
        return idProcess;
    }

    public void setIdProcess(int idProcess) {
        this.idProcess = idProcess;
    }

    public UniqueString(int id, String uniqueString, int idProcess) {
        this.id = id;
        this.uniqueString = uniqueString;
        this.idProcess = idProcess;
    }
}
