package pl.koziol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.koziol.model.InputData;
import pl.koziol.model.UniqueString;
import pl.koziol.repository.InputRepository;
import pl.koziol.repository.ResultRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// todo przerobić na implemetacje z wykorzytaniem repo w H2
@Service
@RequiredArgsConstructor
public class DatabaseRelations {
    
    final InputRepository inputRepository;
    final ResultRepository resultRepository;

  /*  public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:identifier.sqlite";
    private Connection connection;
    private Statement statement;*/

    public boolean createTables()  {
        //todo przeczycić bazę danych do H2
      /*  String createTableProcesses = "create table if not exists table_processes\n" +
                "(\n" +
                "    processes_id     integer\n" +
                "        constraint table_processes_pk\n" +
                "            primary key,\n" +
                "    min_value        integer,\n" +
                "    max_value        integer,\n" +
                "    number_of_result integer,\n" +
                "    input_string     text\n" +
                "  is_thread_terminated integer\n" +
                ");";
        String createTableResult = "create table if not exists table_result\n" +
                "(\n" +
                "    id            integer\n" +
                "        constraint table_result_pk\n" +
                "            primary key,\n" +
                "    unique_string text,\n" +
                "    id_process    integer\n" +
                "        references table_processes\n" +
                ");";
        try {
            statement.execute(createTableProcesses);
            statement.execute(createTableResult);
        } catch (SQLException e) {
            System.err.println("Error creating table");
            e.printStackTrace();
            return false;
        }*/
        return true;
    }
    /**
     * This method returns the number of the entered process, in case of error it returns 0.
     * It is responsible for enters data into the process table.
     * */
    public synchronized int insertInputData(InputData inputData) {
        int id =inputRepository.findByMaxId().getId()+1;
        inputData.setId(id);
        inputRepository.save(inputData);
        return id;
    }


    /**
     * This method returns a list of successfully completed processes.
     */
    public List<InputData> completedProcesses() {
        List<InputData> inputDataList =  inputRepository.findByTerminated(true);
        return inputDataList;
    }


    /**
     * The method returns true if the array is cleared. Only used for tests
     * The program does not clean the database
     */
    public boolean clearDataBases() {
        inputRepository.deleteAll();
        return true;
    }

    public void confirmTerminated(int id) {
        InputData inputData =inputRepository.getById(id);
        inputData.setThreadTerminated(true);
        inputRepository.save(inputData);
    }
    public boolean checkTerminated(int id) {
        return inputRepository.getById(id).isThreadTerminated();
    }
    /**
     * The method returns true if the results of a given process have been correctly placed in the database.
     * Additionally, the method makes sure that the exact number of declared results is placed.
     * For this purpose, it takes the maximum number of words and entered so far.
     */
    public void insertResult (int id, Set<String> list, int enteredData, int maxEnteredData) {

        int counter = enteredData;
        for(String element:list){
            if(counter<=maxEnteredData) {
                resultRepository.save(new UniqueString(element,id));
            }
            counter++;
        }
        confirmTerminated(id);
    }
    /**
     * the method returns a list of strings with results for the process with the specified id.
     */
    public List<String> presentResults (int id){
        List<String> list = new ArrayList<>();
        if(checkTerminated(id)){
            list  = resultRepository.findByProcessId(id).stream().map(x -> x.getUniqueString()).collect(Collectors.toList());

        } else {
            System.out.println("process: " + id + " incomplete");
        }
        return list;
    }

}
