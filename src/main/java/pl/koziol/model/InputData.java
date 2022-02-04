package pl.koziol.model;

import java.util.List;

public class InputData {
    private int minLength;
    private int maxLength;
    private String inputCharacter;
    private int numberOfString;

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

    public InputData(int minLength, int maxLength, String inputCharacter, int numberOfString) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.inputCharacter = inputCharacter;
        this.numberOfString = numberOfString;
    }

}
