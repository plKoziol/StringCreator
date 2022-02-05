package pl.koziol.model;

import java.util.List;

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

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public String getInputCharacter() {
        return inputCharacter;
    }

    public void setInputCharacter(String inputCharacter) {
        this.inputCharacter = inputCharacter;
    }

    public int getNumberOfString() {
        return numberOfString;
    }

    public void setNumberOfString(int numberOfString) {
        this.numberOfString = numberOfString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isThreadTerminated() {
        return threadTerminated;
    }

    public void setThreadTerminated(boolean threadTerminated) {
        this.threadTerminated = threadTerminated;
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
