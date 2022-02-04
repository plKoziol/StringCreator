package pl.koziol.service;

import java.sql.Time;

public interface RunningProcesses {
    int addTheProcessNumber ();
    Time timeStartProcess ();
    Time timeStopProcess ();
    String logTime ();

}
