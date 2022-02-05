package pl.koziol.service.impl;

import pl.koziol.model.InputData;
import pl.koziol.service.DatabaseRelations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRelationsImpl implements DatabaseRelations {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:identifier.sqlite";
    private Connection connection;
    private Statement statement;

    public DatabaseRelationsImpl(){
        try {
            Class.forName(DatabaseRelationsImpl.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC driver missing");
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println("open connection problem");
            e.printStackTrace();
        }
        createTables();
    }
    public boolean createTables()  {
        String createTableProcesses = "create table if not exists table_processes\n" +
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
        }
        return true;
    }

    @Override
    public synchronized int selectMaxID() {
        int maxId;
        try {
            ResultSet resultSet = statement.executeQuery(
                    "select max(processes_id) from table_processes");
            maxId = resultSet.getInt("max(processes_id)");

        } catch (SQLException e) {
            System.err.println("select max id error");
            e.printStackTrace();
            return 0;
        }
        return maxId;
    }

    @Override
    public synchronized int insertInputData(InputData inputData) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into table_processes values (NULL, ?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, inputData.getMinLength());
            preparedStatement.setInt(2, inputData.getMaxLength());
            preparedStatement.setInt(3, inputData.getNumberOfString());
            preparedStatement.setString(4, inputData.getInputCharacter());
            preparedStatement.setInt(5, 0);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.println("input error");
            e.printStackTrace();
            return 0;
        }
        return selectMaxID();
    }

    @Override
    public List<InputData> completedProcesses() {
        List<InputData> inputDataList = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(
                    "select * from table_processes where is_thread_terminated > 0");
            int processesID, minValue, maxValue, numberOfResult;
            String inputString;
            boolean isThreadTerminated;
            while (resultSet.next()){
                processesID = resultSet.getInt("processes_id");
                minValue = resultSet.getInt("min_value");
                maxValue = resultSet.getInt("max_value");
                numberOfResult = resultSet.getInt("number_of_result");
                inputString = resultSet.getString("input_string");
                isThreadTerminated = (0!=resultSet.getInt("is_thread_terminated"));
                inputDataList.add(new InputData(processesID,minValue,maxValue,inputString,numberOfResult,isThreadTerminated));

            }
        } catch (SQLException e) {
            System.err.println("select completed processes error");
            e.printStackTrace();
            return null;
        }
        return inputDataList;
    }

    @Override
    public boolean clearDataBases() {
        try {
            boolean result = statement.execute("delete from table_processes");
            result = statement.execute("delete from table_result");


        } catch (SQLException e) {
            System.err.println("delete error");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean confirmTerminated(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update table_processes set is_thread_terminated = 1 where processes_id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();


        } catch (SQLException e) {
            System.err.println("confirm terminated error");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean checkTerminated(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select is_thread_terminated from table_processes  where processes_id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return (0!=resultSet.getInt("is_thread_terminated"));


        } catch (SQLException e) {
            System.err.println("confirm terminated error");
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertResult (int id, List<String> list) {
        PreparedStatement preparedStatement;
        for(String element:list){
            try {
                preparedStatement = connection.prepareStatement(
                        "insert into table_result values (NULL, ?, ?);");
                preparedStatement.setString(1, element);
                preparedStatement.setInt(2, id);
                preparedStatement.execute();
            } catch (SQLException e) {
                System.err.println("error in recording the results");
                e.printStackTrace();
                return false;
            }
        }
        return confirmTerminated(id);
    }

    public void presentResults (int id){
        if(checkTerminated(id)){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from table_result where id_process = ?");
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                int processID;
                String resultString;
                while (resultSet.next()){
                    processID = resultSet.getInt("id_process");
                    resultString = resultSet.getString("unique_string");
                    System.out.println("process: "+processID + " unique word: " + resultString);


                }
            } catch (SQLException e) {
                System.err.println("select completed processes error");
                e.printStackTrace();
            }
        } else {
            System.out.println("process: " + id + " incomplete");
        }

    }

}
