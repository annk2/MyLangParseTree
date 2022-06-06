package com.company;

public abstract class Command{
    //protected enum CommandTypes  ???
    //protected String CommandWord;
    protected Variable [] Variables;
    protected Variable AVariable;
    protected String Literal;

    public Command(){
        Variables = null;
        AVariable = null;
        Literal = null;
    }

    public Command(Variable [] CommandVariables){
        Literal = null;
        for(int i = 0; i<CommandVariables.length; ++i)
            Variables[i] = CommandVariables[i];
    }

    public Command(Variable CommandVariable){
        Literal = null;
        Variables = null;
        AVariable = CommandVariable;
    }

    public Command(String CommandLiteral){
        Variables = null;
        Literal = CommandLiteral;
    }

    public Command(Variable [] CommandVariables, String CommandLiteral) {
        for (int i = 0; i < CommandVariables.length; ++i)
            Variables[i] = CommandVariables[i];
        Literal = CommandLiteral;
    }

    public abstract boolean Execute();
}
