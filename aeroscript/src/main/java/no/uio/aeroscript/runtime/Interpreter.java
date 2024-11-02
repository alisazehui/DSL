package no.uio.aeroscript.runtime;

import no.uio.aeroscript.antlr.AeroScriptBaseVisitor;
import no.uio.aeroscript.antlr.AeroScriptParser;
import no.uio.aeroscript.ast.expr.Node;
import no.uio.aeroscript.ast.expr.NumberNode;
import no.uio.aeroscript.ast.expr.OperationNode;
import no.uio.aeroscript.ast.stmt.Execution;
import no.uio.aeroscript.ast.stmt.Reaction;
import no.uio.aeroscript.ast.stmt.Statement;
import no.uio.aeroscript.ast.stmt.acAscend;
import no.uio.aeroscript.ast.stmt.acDescend;
import no.uio.aeroscript.ast.stmt.acDock;
import no.uio.aeroscript.ast.stmt.acMove;
import no.uio.aeroscript.ast.stmt.acTurn;
import no.uio.aeroscript.type.Memory;
import no.uio.aeroscript.type.Point;
import no.uio.aeroscript.type.Range;

import java.util.*;

import org.stringtemplate.v4.ST;

public class Interpreter extends AeroScriptBaseVisitor<Object> {
    private final HashMap<Memory, Object> heap;
    private final Stack<Statement> stack;
    private final HashMap<String, Runnable> listeners;

    public Interpreter(HashMap<Memory, Object> heap, Stack<Statement> stack) {
        this.heap = heap;
        this.stack = stack;
        this.listeners = new HashMap<String, Runnable>();
    }

    public Point getPosition() {
        assert heap.get(Memory.VARIABLES) instanceof HashMap;
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
        return (Point) vars.get("current position");
    }

    public float getDistanceTravelled() {
        // Implement this method that returns the actual distance travelled from the variables
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
        float distanceTravelled = (Float) vars.get("distance travelled");

        return distanceTravelled;
    }

    public float getBatteryLevel() {
        // Implement this method that returns the actual battery level from the variables
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
        float batteryLevel = (Float) vars.get("battery level");

        return batteryLevel;
    }

    public void checkBattery() {
        // Implement this method that checks the battery level and triggers the reaction if the battery level is low
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES); 
        float batteryLevel = (Float) vars.get("battery level");

        if (batteryLevel < 20) {
            vars.put("battery low", true);
            System.out.println("Battery low! Initiating emergency landing...");

            acDescend emergencyLandingAction = new acDescend(heap);
            emergencyLandingAction.execute();  

            System.out.println("Emergency landing completed. Exiting program.");
            System.exit(0);  
        }
    }

    public HashMap<String, Runnable> getListeners() {
        Map<String, String> reactions = (HashMap<String, String>) heap.get(Memory.MESSAGES);
		Map<String, Execution> execution = (HashMap<String, Execution>) heap.get(Memory.EXECUTION_TABLE);

		for(String e : listeners.keySet()) {
			Execution x = execution.get(reactions.get(e));
			listeners.put(e, () -> {
					x.execute();
						});
		}

        return this.listeners;
    }

    public Execution getFirstExecution() {
        for (Statement statement : stack) {
            if (statement instanceof Execution) {
                return (Execution) statement;
            }
        }
        return null;
    }

    @Override
    public Object visitProgram(AeroScriptParser.ProgramContext ctx) {
        // går gjennom alle executions og kaller på visitExecution
        // rapporten skal si hvordan vi implementerte hele programmet
        for (AeroScriptParser.ExecutionContext executionContext : ctx.execution()) {
            Execution execution = (Execution) visitExecution(executionContext);
            // Push the execution to the stack if it's valid
            if (execution != null) {
                stack.push(execution);
            }
        }
        return new Program(heap, stack);
    }

    @Override
    public Object visitExecution(AeroScriptParser.ExecutionContext ctx) {
        // går gjennom execution uttrykk som mission control, som går gjennom statements innenfor der. 
        String id = ctx.ID(0).getText();
        List<Object> statement = new ArrayList<>();
        Map<String, Object> execution_table = (Map<String, Object>) heap.get(Memory.EXECUTION_TABLE);

        for(AeroScriptParser.StatementContext statements : ctx.statement()) {
            statement.add(visitStatement(statements));
        }

        Execution execution = new Execution(statement, heap, listeners);

        Execution previousExecution = (Execution) execution_table.get("previousExecution");
        if (previousExecution != null) {
            previousExecution.setNextExecution(execution);
        }
        execution_table.put("previousExecution", execution);  
        execution_table.put(id, execution); 

        return execution;
    }

    @Override
    public Object visitStatement(AeroScriptParser.StatementContext ctx) {
        if (ctx.action() != null) {
            return visitAction(ctx.action());
        } else if (ctx.execution() != null) {
            return visitExecution(ctx.execution());
        }
        else if (ctx.reaction() != null) {
            return visitReaction(ctx.reaction());
        }
        throw new IllegalArgumentException("Invalid statement!");
    }
 
    @Override
    public Object visitAction(AeroScriptParser.ActionContext ctx) {
        if (ctx.acDock() != null) {
            return visitAcDock(ctx.acDock());
        }
        else if (ctx.acAscend() != null) {
            return visitAcAscend(ctx.acAscend());
        }
        else if (ctx.acDescend() != null){
            return visitAcDescend(ctx.acDescend());
        }
        else if (ctx.acMove() != null) {
            return visitAcMove(ctx.acMove());
        }
        else if (ctx.acTurn() != null) {
            return visitAcTurn(ctx.acTurn());
        }
        throw new IllegalArgumentException("Invalid action!");
    }

    @Override
    public Object visitAcDock(AeroScriptParser.AcDockContext ctx) {
        acDock action = new acDock(heap);
        return action;
    }

    @Override
    public Object visitAcAscend(AeroScriptParser.AcAscendContext ctx) {
        acAscend action = new acAscend(heap, (Node) visit(ctx.expression()));
        return action;
    }

    @Override 
    public Object visitAcDescend(AeroScriptParser.AcDescendContext ctx) {
        acDescend action;
        if (ctx.DESCEND() != null) {
            action = new acDescend(heap, (Node) visit(ctx.expression()));
        }
        else {
            action = new acDescend(heap);
        }
        return action;
    }

    @Override
    public Object visitAcMove(AeroScriptParser.AcMoveContext ctx) {
        acMove action;
        if (ctx.POINT() != null) { 
            action = new acMove(heap, (Point) visit(ctx.point()));
        }
        else {
            action = new acMove(heap, (Node) visit(ctx.NUMBER()));
        }
        return action;
    }

    @Override
    public Object visitAcTurn(AeroScriptParser.AcTurnContext ctx) {
        acTurn action = new acTurn(heap, (Node) visit(ctx.expression()));
        return action;
    }

    @Override
    public Object visitReaction(AeroScriptParser.ReactionContext ctx) {
        String message = "";
        String id = ctx.ID().getText();

        if (ctx.event().MESSAGE() != null) {
            message = ctx.event().ID().getText();           // message ID, e.g. launch
            HashMap<String, String> messages = (HashMap<String, String>) heap.get(Memory.MESSAGES);
            messages.put(message, id);
        } else {
            message = ctx.event().getText();                // obstacle, low battery
            HashMap<String, String> reactions = (HashMap<String, String>) heap.get(Memory.REACTIONS);
            reactions.put(message, id);
        }
        Reaction reaction = new Reaction(listeners, heap, message, id);
        listeners.put(message, null);

        return reaction;
    }

    @Override
    public Object visitPoint(AeroScriptParser.PointContext ctx) {
        Node xNode = (Node) visit(ctx.expression(0));
        Node yNode = (Node) visit(ctx.expression(1));
        float x = Float.parseFloat(xNode.evaluate().toString());
        float y = Float.parseFloat(yNode.evaluate().toString());
        return new Point(x, y);
    }

    @Override
    public Object visitRange(AeroScriptParser.RangeContext ctx) {
        Node startNode = (Node) visit(ctx.expression(0));
        Node endNode = (Node) visit(ctx.expression(1));
        float start = Float.parseFloat(startNode.evaluate().toString());
        float end = Float.parseFloat(endNode.evaluate().toString());
        return new Range(start, end);
    }

    @Override
    public Node visitExpression(AeroScriptParser.ExpressionContext ctx) {
        // Case of binary operation
        if (ctx.PLUS() != null || ctx.MINUS() != null || ctx.TIMES() != null) {
            Node left = (Node) visit(ctx.expression(0));
            Node right = (Node) visit(ctx.expression(1));
            String operator = ctx.PLUS() != null ? "PLUS" :
                    ctx.MINUS() != null ? "MINUS" :
                            "TIMES";
            return new OperationNode(operator, left, right);
        }
        // Case of negation
        else if (ctx.NEG() != null) {
            Node expr = (Node) visit(ctx.expression(0));
            return new OperationNode("NEG", expr, null);
        }
        // Case of random
        else if (ctx.RANDOM() != null) {
            Node start;
            Node end;
            if (ctx.range() != null) {
                AeroScriptParser.RangeContext rangeContext = ctx.range();
                start = (Node) visit(rangeContext.expression(0));
                end = (Node) visit(rangeContext.expression(1));
            } else {
                start = new NumberNode((float) 0);
                end = new NumberNode(100F);
            }
            return new OperationNode("RANDOM", start, end);
        }
        // Case of point
        else if (ctx.POINT() != null) {
            AeroScriptParser.PointContext pointContext = ctx.point();
            Node x = (Node) visit(pointContext.expression(0));
            Node y = (Node) visit(pointContext.expression(1));
            return new OperationNode("POINT", x, y);
        }
        // Case of number
        else if (ctx.NUMBER() != null) {
            return new NumberNode(Float.parseFloat(ctx.NUMBER().getText()));
        }
        // Case of expression in parentheses
        else if (ctx.LPAREN() != null) {
            return (Node) visit(ctx.expression(0));
        }
        return new NumberNode(Float.parseFloat(ctx.NUMBER().getText()));
    }
} 
