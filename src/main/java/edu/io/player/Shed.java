package edu.io.player;

import edu.io.token.Tool;

import java.util.Stack;


public class Shed {
    // todo: zastanowić się czym i dlaczego warto zastąpić klasę Stack
    private final Stack<Tool> tools = new Stack<>();

    public Shed() {
        tools.push(new NoTool());
    }

    public boolean isEmpty() {
        return tools.peek() instanceof NoTool;
    }

    public void add(Tool tool) throws IllegalArgumentException {
        if (tool == null) throw new IllegalArgumentException("Tool cannot be null");
        tools.push(tool);
    }

    public Tool getTool() {
        return tools.peek();
    }

    public void dropTool() {
        if (!isEmpty()) {
            tools.pop();

        }
    }
}
