package no.uio.aeroscript.runtime;

import no.uio.aeroscript.ast.stmt.Execution;
import no.uio.aeroscript.type.Memory;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

// Uncomment the following code for the REPL after implementing the execution and the rest of the code

class Command {
    private final String name;
    private final REPL repl;
    private final Function<String, Boolean> command;
    private final String help;
    private final boolean requiresParameter;
    private final String parameterHelp;

    public Command(String name, REPL repl, Function<String, Boolean> command, String help, boolean requiresParameter, String parameterHelp) {
        this.name = name;
        this.repl = repl;
        this.command = command;
        this.help = help;
        this.requiresParameter = requiresParameter;
        this.parameterHelp = parameterHelp;
    }

    public String getName() {
        return name;
    }

    public String getHelp() {
        return help;
    }

    public boolean isRequiresParameter() {
        return requiresParameter;
    }

    public String getParameterHelp() {
        return parameterHelp;
    }

    public boolean execute(String param) {
        if (requiresParameter && Objects.equals(param, "")) {
            System.out.println(name + " requires a parameter: " + parameterHelp);
            return false;
        }

        return command.apply(param);
    }
}

public class REPL {
    private final HashMap<Memory, Object> heap;
    private final HashMap<String, Command> commands = new HashMap<>();
    private final Map<String, Runnable> listeners;
    private final Execution initialExecution;
    private boolean terminating = false;

    public REPL(HashMap<Memory, Object> heap, Map<String, Runnable> listeners, Execution initialExecution) {
        this.heap = heap;
        this.listeners = listeners;
        this.initialExecution = initialExecution;
        initCommands();
    }

    public boolean isTerminating() {
        return terminating;
    }

    private void printRepl(String str) {
        System.out.println("MO-out> " + str);
    }

    public boolean command(String str, String param) {
        LocalTime start = LocalTime.now();
        boolean result;

        if (str.equals("help")) {
            for (Command cmd : commands.values()) {
                System.out.printf("%11s - %s%n\n", cmd.getName(), cmd.getHelp());
                if (!Objects.equals(cmd.getParameterHelp(), "")) {
                    System.out.printf("%14s\n", cmd.getParameterHelp());
                }
            }
            result = false;
        } else {
            Command cmd = commands.get(str);

            if (cmd == null) {
                printRepl("Unknown command: " + str + ". Type \"help\" to get a list of available commands");
                result = false;
            } else {
                try {
                    cmd.execute(param);
                    result = true;
                } catch (Exception e) {
                    printRepl("Command " + str + " " + param + " caused an exception. Internal state may be inconsistent");
                    result = false;
                }
            }
        }

        float time = Duration.between(start, LocalTime.now()).toMillis() / 1000f;
        printRepl("Command executed in " + time + " seconds");

        return result;
    }

    private void initCommands() {
        commands.put("help", new Command("help", this, (param) -> false, commands.keySet().toString(), false, ""));
        // for command "message" we get the message passed as parameter, we need to add the trigger for the listener
        commands.put("message", new Command("message", this, (param) -> {
            Runnable listener = listeners.get(param);
            if (listener != null) {
                this.initialExecution.receiveMessage(param);
            } else {
                printRepl("No listener for message: " + param);
            }
            return true;
        }, "Send a message to the listener", true, "The message to send"));
        commands.put("info", new Command("info", this, (param) -> {
            printRepl("Heap: " + heap);
            return true;
        }, "Prints the information on the heap", false, ""));
        commands.put("exit", new Command("exit", this, (param) -> {
            terminate();
            return true;
        }, "Exits the REPL", false, ""));
    }

    public void terminate() {
        System.out.println("Terminating the REPL");
        this.terminating = true;
    }
}
