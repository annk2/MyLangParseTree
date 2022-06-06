package com.company;

public class Print extends Command{

    public Print(Variable [] CommandVariables) {
        super(CommandVariables);
    }

    public Print(Variable CommandVariable){
        super(CommandVariable);
    }

    public Print(String CommandLiteral) {
        super(CommandLiteral);
    }

    public Print(Variable [] CommandVariables, String CommandLiteral) {
        super(CommandVariables, CommandLiteral);
    }

    public boolean Execute() {
        if (Literal != null) {
            String [] Isolate = Literal.split("\"");
            System.out.println(Isolate[1]);
            return true;
        }
        else if (Variables != null) {
            Variables[0].Print();
            return true;
        }
        else if(AVariable != null) {
            AVariable.Print();
            return true;
        }
        return false;
    }
}
