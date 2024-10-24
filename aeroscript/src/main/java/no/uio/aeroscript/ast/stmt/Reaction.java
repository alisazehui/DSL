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
        execute();
    }

    @Override
    public void execute(){  
        HashMap<String, Object> executionTable = (HashMap<String, Object>) heap.get(Memory.EXECUTION_TABLE);
        HashMap<String, Boolean> messageAuthentication = (HashMap<String, Boolean>) heap.get(Memory.MESSAGES);

        if (messageAuthentication.containsKey(message) && messageAuthentication.get(message)) {
            // Use heap to check if the message is authentic
            listeners.put(message, () -> {
                Execution execution = (Execution) executionTable.get(id);
                if (execution != null) {
                    execution.receiveMessage(message);
                } else {
                    System.out.println("Execution not found for message: " + message);
                }
            });

        // Predefined listeners
        listeners.put("low battery", () -> {
            System.out.println("Low battery detected! Initiating emergency landing...");
            Execution execution = (Execution) executionTable.get(id);
            execution.receiveMessage("low battery");
        });

        listeners.put("launch", () -> {
            System.out.println("Launch command received.");
            Execution execution = (Execution) executionTable.get(id);
            execution.receiveMessage("launch");
        });
        }
    }
}
