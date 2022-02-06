package pl.koziol.model;

public class InputData {
    private int id;
    private int minLength;
    private int maxLength;
    private String inputCharacter;
    private int numberOfString;
    private boolean threadTerminated = false;

    public int getMinLength() {
        return minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public String getInputCharacter() {
        return inputCharacter;
    }

    public int getNumberOfString() {
        return numberOfString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InputData(int id, int minLength, int maxLength, String inputCharacter, int numberOfString) {
        this.id = id;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.inputCharacter = inputCharacter;
        this.numberOfString = numberOfString;
    }

    public InputData(int id, int minLength, int maxLength, String inputCharacter, int numberOfString, boolean threadTerminated) {
        this.id = id;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.inputCharacter = inputCharacter;
        this.numberOfString = numberOfString;
        this.threadTerminated = threadTerminated;
    }

    public InputData(int minLength, int maxLength, String inputCharacter, int numberOfString) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.inputCharacter = inputCharacter;
        this.numberOfString = numberOfString;
    }
}
