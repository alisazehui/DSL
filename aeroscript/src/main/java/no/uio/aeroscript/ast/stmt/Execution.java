package no.uio.aeroscript.ast.stmt;
import no.uio.aeroscript.type.Memory;
import java.util.*;

public class Execution extends Statement {
    // Add all the variables that you need for the exeuction
    private List<Object> statements;
    private HashMap<Memory, Object> heap;
    private HashMap<String, Runnable> listeners;
    private Set<Statement> executedExecutions = new HashSet<>();
    private Stack<Execution> executionStack = new Stack<>();
    private Execution nextExecution;

    public Execution(List<Object> statements, HashMap<Memory, Object> heap, HashMap<String, Runnable> listeners) {
        this.statements = statements;
        this.heap = heap;
        this.listeners = listeners;
    }

    public void receiveMessage(String message) {
        // When you receive a message you need to execute its content
        // Hint: for messages you can use listeners to trigger the execution
        System.out.println("Received message: " + message);
        HashMap<String, Object> messages = (HashMap<String, Object>) heap.get(Memory.MESSAGES);
        if (listeners.containsKey(message)) {
            String id = (String) messages.get(message);
            HashMap<String, Execution> execution_table = (HashMap<String, Execution>) heap.get(Memory.EXECUTION_TABLE);
            Execution execution = execution_table.get(id);
            if (execution != null) {
                execution.execute();
                return;
            }
        } else {
            System.out.println("No listener for message: " + message);
        }
    }

    public void setNextExecution(Execution nextExecution) {
        this.nextExecution = nextExecution;
    }

    @Override
    public void execute() {
        // Hint: When you start running an execution, you need to push a copy of the corresponding code from the EXECUTION_TABLE on the stack
        // Hint: you should check if you have nested execution
        // Hint: you should keep track of the executed statements to avoid infinite loops
        // Create a stack to keep track of nested executions
        executionStack.add(this);

		while (!executionStack.isEmpty()) {
			Execution current = (Execution) executionStack.pop();
            if (executedExecutions.contains(current)) {
                System.out.println("Skipping already executed Execution to avoid an infinite loop: " + current);
                continue;
            }
            executedExecutions.add(current);
			for (Object statements : current.statements) {
                HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES); 
                float batteryLevel = (Float) vars.get("battery level");
                
                // Battery check for each action
                if (batteryLevel < 20) {
                    vars.put("battery low", true);
                    System.out.println("Battery low! Initiating emergency landing...");
        
                    acDescend emergencyLandingAction = new acDescend(heap);
                    emergencyLandingAction.execute();  
        
                    System.out.println("Emergency landing completed. Exiting program.");
                    System.exit(0);  
                }

                switch (statements) {
                    case Execution execution -> this.statements.add(execution);
                    case Statement statement -> statement.execute();
                    default -> System.out.println("Input statement is not an execution or statement");
                }
            }

            if (nextExecution != null) {
                executionStack.push(nextExecution);
                nextExecution.execute();
            }
		}
	} 
}

