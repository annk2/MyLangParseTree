package com.company;

public class Parser extends VariableStorage {

    Reader MyReader;
    Reader UserTutorial;

    public int GetCurrentLine(){
        return MyReader.GetCurrentLine();
    }

    public void SetCurrentLine(int SetLineNum){
        MyReader.SetCurrentLine(SetLineNum);
    }

    protected boolean RunCommand(String CommandLine) {
        String[] SplitCommand = CommandLine.split(":");
        String CommandWord = SplitCommand[0];
        String RestOfLine = null;
        if(SplitCommand.length>1) {
            RestOfLine = SplitCommand[1];
            //RestOfLine.replaceAll("\\s+","");
        }
        Command MyCommand = null;
        switch (CommandWord) {
            case "NUMBER": //CREATING SINGLE VARIABLES
            case "WORD":
            case "SENTENCE": {
                if (!AddVariable(CommandWord, RestOfLine)) return false;
                break;
            }

            case "SET": { //CHANGING VARIABLE VALUES
                String[] SplitVariables = RestOfLine.split(" TO ", 2);
                if (IsLiteral(SplitVariables[1]) || IsNumber(SplitVariables[1])) {
                    if (!ChangeVariableToValue(SplitVariables[0], SplitVariables[1]))
                        return false;
                } else {
                    if (!ChangeVariableToVariable(SplitVariables[0], SplitVariables[1]))
                        return false;
                }
                break;
            }

            //COMMANDS
            case "PRINT": {
                if (IsLiteral(RestOfLine) || IsNumber(RestOfLine))
                    MyCommand = new Print(RestOfLine);
                else {
                    Variable Found = FindVariable(RestOfLine);
                    if (Found != null)
                        MyCommand = new Print(Found);
                    else
                        return false;
                }
                break;
            }
            case "LOOP": {
                boolean StartCondition = false;
                String StartLine = MyReader.ReadLine(MyReader.GetCurrentLine());
                String [] SplitStartLine = StartLine.split(": ", 2);
                String StartConditionStatement = SplitStartLine[1];

                if(IsLiteral(StartConditionStatement)) { //conditional is literal
                    String[] IsolateStartConditionStatement = StartConditionStatement.split("\"");
                    StartConditionStatement = IsolateStartConditionStatement[1];
                    if(StartConditionStatement.equals("always")) {
                        StartCondition = true;
                    }
                }

                else if (StartConditionStatement.contains("NOT")){
                    String[] CompareVariables = StartConditionStatement.split(" IS NOT ");
                    StartCondition = CompareConditionalLiteral(true, CompareVariables[0], CompareVariables[1]);
                }

                else{
                    String[] CompareVariables = StartConditionStatement.split(" IS ");
                    StartCondition = CompareConditionalLiteral(false, CompareVariables[0], CompareVariables[1]);
                }



                String StopConditionStatement = null;
                String [] SplitCheckLine = null;
                int Lines = 0;

                do {
                    String CheckLine = MyReader.ReadLine(MyReader.GetCurrentLine());
                    SplitCheckLine = CheckLine.split(": ", 2);
                    StopConditionStatement = SplitCheckLine[0];
                    if(!StopConditionStatement.equals("REPEAT"))
                        ++Lines;
                }while(!StopConditionStatement.equals("REPEAT"));

                int Repeats = Integer.parseInt(SplitCheckLine[1]);
                SetCurrentLine(GetCurrentLine() - Lines - 1); //sets back to beginning
                MyCommand = new Loop(this, StartCondition, Lines, Repeats);
                break;
            }

            default: {
                System.out.println(CommandWord + " IS NOT A VALID COMMAND.");
                return false;
            }

        }

        if (MyCommand != null)
            MyCommand.Execute();
        return true;
    }

    public Parser(String FileName, String Tutorial) {
        super();
        MyReader = new Reader(FileName);
        UserTutorial = new Reader(Tutorial);
        //print tutorial here?
    }

    public boolean FileNotExist(){
        return MyReader.FileNotExist();
    }

    public void ShowTutorial() {
        UserTutorial.PrintFile();
    }

    public void ShowFile() {
        MyReader.PrintFile();
    }

    public boolean ParseOne(int LineNumber) {
        String CurrentLine;
        CurrentLine = MyReader.ReadLine(LineNumber);
        boolean CommandSuccess = true;
        CommandSuccess = RunCommand(CurrentLine);
        //ViewVariableList();

        if (!CommandSuccess) {
            MyReader.ErrorMessage();
            return false;
        }
        return true;
    }

    public boolean ParseAll(){
        //String CurrentLine = "start";
        //boolean CommandSuccess = true;
        String CurrentLine;
        boolean CommandSuccess = true;
        //while(MyReader.HasNext() && CommandSuccess) {
        do {
            CurrentLine = MyReader.ReadLine(MyReader.GetCurrentLine());
            //CurrentLine = MyReader.ReadLine();
            if(!CurrentLine.equals(""))
                CommandSuccess = RunCommand(CurrentLine);
            //ViewVariableList();
        }while(GetCurrentLine() < MyReader.FileLines.size() && CommandSuccess);

        if(!CommandSuccess) {
            MyReader.ErrorMessage();
            return false;
        }

        //MyReader.CloseFile();
        return true;
    }

     //public boolean ParseLine(String ToParse)
}
