package no.uio.aeroscript.runtime;
import no.uio.aeroscript.ast.stmt.Statement;
import no.uio.aeroscript.type.Memory;
import java.util.*;

public class Program {
    // Add the variables that you might be needing
    private HashMap<Memory, Object> heap;
    private Stack<Statement> execution;

    public Program(HashMap<Memory, Object> heap, Stack<Statement> execution) {
        this.heap = heap;
        this.execution = execution;
    }

    // Hint: we should keep track of the executions and add them to a stack

    public void run(String id) {
        // Implement the run method
    }
}
