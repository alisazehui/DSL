package no.uio.aeroscript.ast.stmt;
import java.util.HashMap;

import no.uio.aeroscript.type.Memory;

public class Reaction extends Statement{
    private HashMap<String, Runnable> listeners;
    private HashMap<Memory, Object> heap;
    private String message, id;

    public Reaction(HashMap<String, Runnable> listeners, HashMap<Memory, Object> heap, 
                    String message, String id) {
        this.listeners = listeners;
        this.heap = heap;
        this.message = message;
        this.id = id;
        addListener();
    }

    public void addListener() {
        HashMap<String, Object> executionTable = (HashMap<String, Object>) heap.get(Memory.EXECUTION_TABLE);
        HashMap<String, String> messageAuthentication = (HashMap<String, String>) heap.get(Memory.MESSAGES);
        
        listeners.put(message, () -> {
            if (messageAuthentication.containsKey(message) && "true".equals(messageAuthentication.get(message))) {
                System.out.println("Listener triggered for message: " + message);

                Execution execution = (Execution) executionTable.get(id);
                if (execution != null) {
                    execution.execute();
                } else {
                    System.out.println("Execution not found for message: " + message);
                }
            }
        });
    }

    @Override
    public void execute(){  
        HashMap<String, Object> executionTable = (HashMap<String, Object>) heap.get(Memory.EXECUTION_TABLE);
        Execution execution = (Execution) executionTable.get(this.id);
        execution.receiveMessage(message);
    }
}
