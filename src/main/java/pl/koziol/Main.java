package pl.koziol;

/*todo przerzucic funkcjonalności do Endpointów
*  stworzyć możliwość testowania endpoitów,
* wszytkie testy do wymiany*/
/*
public class Main {
    static UniqueStringService unique = new UniqueStringService();
    static DatabaseRelations dbRelations = new DatabaseRelationsImpl();
    public static int menu(){
        System.out.println("Select an activity");
        System.out.println("1. Enter data for calculation");
        System.out.println("2. Display the number of processes in progress");
        System.out.println("3. Display calculation results");
        System.out.println("4. Close application");
        Scanner scanner = new Scanner(System.in);
        int chose;
        try{
            chose = scanner.nextInt();
        } catch (RuntimeException e){
            chose = 0;
        }

        switch (chose){
            case 1:
                enterData();
                break;
            case 2:
                numberOfProcesses();
                break;
            case 3:
                displayResult();
                break;
            case 4:
                return 0;
            default:
                System.out.println("Enter a number from 1 to 4");
        }
        menu();
        return 0;
    }
    public static void enterData(){
        int minLength, maxLength, numberOfWords;
        String word;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the minimum word length");
            minLength = scanner.nextInt();
            System.out.println("Enter the maximum word length");
            maxLength = scanner.nextInt();
            System.out.println("Enter how many words you want to create");
            numberOfWords = scanner.nextInt();
            System.out.println("Enter the characters from which the word is to be composed");
            word = scanner.next();
            unique.createUniqueWords(minLength,maxLength,word,numberOfWords);
        } catch (RuntimeException e){
            System.out.println("enter correct data");
        }

    }
    public static void numberOfProcesses(){
        System.out.println("there are " + unique.getActiveProcesses() + " active processes " );
    }
    public static void displayResult(){
        Scanner scanner = new Scanner(System.in);
        List<InputData> inputDataList = dbRelations.completedProcesses();
        System.out.println("list of completed processes");
        for(InputData inputData: inputDataList){
            System.out.println("ID process: " + inputData.getId() + " entered String: " + inputData.getInputCharacter());
        }
        System.out.println("Enter the id of the process you want to see the result");
        int chose;
        try{
            chose = scanner.nextInt();
            unique.getResultById(chose);
        } catch (RuntimeException e){
            System.out.println("enter correct data");
        }
    }


    public static void main(String[] args) {
        menu();
    }

}*/
