package no.uio.aeroscript.ast.stmt;
import no.uio.aeroscript.type.Memory;
import java.util.*;

public class Execution extends Statement {
    // Add all the variables that you need for the exeuction
    private List<Object> statements;
    private HashMap<Memory, Object> heap;
    private final HashMap<String, Runnable> listeners;

    public Execution(List<Object> statements, HashMap<Memory, Object> heap, HashMap<String, Runnable> listeners) {
        this.statements = statements;
        this.heap = heap;
        this.listeners = listeners;
    }

    public void receiveMessage(String message) {
        // When you receive a message you need to execute its content
        // Hint: for messages you can use listeners to trigger the execution
        System.out.println("Received message: " + message);
        if (listeners.containsKey(message)) {
            listeners.get(message).run();
        } else {
            System.out.println("No listener for message: " + message);
        }
    }


    @Override
    public void execute() {
        // Hint: When you start running an execution, you need to push a copy of the corresponding code from the EXECUTION_TABLE on the stack
        // Hint: you should check if you have nested execution
        // Hint: you should keep track of the executed statements to avoid infinite loops
        
    }
}

