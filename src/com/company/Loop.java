package com.company;

public class Loop extends Command {

    protected Parser LoopParser;
    //protected String[] CommandLines;
    protected int CommandLines;
    protected int Count;
    protected boolean Stop;
    protected boolean Start;
    protected int Repeat;

    //public boolean IfStop(boolean Compare)

    public boolean RunLoopCommands(){
        for(int i = 0; i<CommandLines; ++i) {
            //replace current line with count
            if (!LoopParser.ParseOne(LoopParser.GetCurrentLine()))
                return false;
        }
        return true;
    }

    protected boolean ForLoop(){
        for(int i = 0; i<Repeat; ++i) {
            if(i>0) {
                LoopParser.SetCurrentLine(LoopParser.GetCurrentLine() - CommandLines); //sets back to beginning
            }
            //System.out.println(LoopParser.GetCurrentLine() + 1);
            if (!RunLoopCommands())
                return false;
        }
        LoopParser.SetCurrentLine(LoopParser.GetCurrentLine() + 1); //sets to after repeat
        return true;
    }

    //protected WhileLoop()

    //protected DoWhileLoop()

    public Loop(Parser MyParser, boolean IfStart, int Lines, int ToRepeat){
        super();
        LoopParser = MyParser;
        Start = IfStart;
        CommandLines = Lines;
        Repeat = ToRepeat;
    }

    public Loop(Parser MyParser, Variable[] CommandVariables) {
        super(CommandVariables);
        Count = 0;
        LoopParser = MyParser;
    }

    public Loop(Parser MyParser, Variable CommandVariable) {
        super(CommandVariable);
        Count = 0;
        LoopParser = MyParser;
    }

    public Loop(Parser MyParser, String CommandLiteral) {
        super(CommandLiteral);
        Count = 0;
        LoopParser = MyParser;
    }

    public Loop(Parser MyParser, Variable[] CommandVariables, String CommandLiteral) {
        super(CommandVariables, CommandLiteral);
        Count = 0;
        LoopParser = MyParser;
    }

    public boolean Execute() {
        boolean Success = false;
        if(Start)
            Success = ForLoop();
        else{
            LoopParser.SetCurrentLine(LoopParser.GetCurrentLine() + CommandLines + 1); //sets to after repeat
        }
        return Success;
    }
}
