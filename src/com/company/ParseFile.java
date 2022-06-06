package com.company;

public class ParseFile {

    protected String LastName;
    protected String FirstName;
    protected String FileName; //should this be an actual file?
    protected String TutorialName;
    protected Parser StudentParser;

    ParseFile(String Last, String First, String File, String Tutorial){
        LastName = Last;
        FirstName = First;
        FileName = File; //??
        TutorialName = Tutorial;
        StudentParser = new Parser(FileName, TutorialName);
    }

    public boolean FileNotExist(){
        return StudentParser.FileNotExist();
    }

    public String GetLast(){
        return LastName;
    }

    public String GetFirst(){
        return FirstName;
    }

    public void Print(){
        System.out.println(LastName + "," + FirstName + "\t" + "\t" + FileName);
    }

    public void PrintFile(){
        StudentParser.ShowFile();
    }

    public int Compare(ParseFile ToCompare){
        if(LastName.equalsIgnoreCase(ToCompare.LastName)) //if last name greater, positive
            return FirstName.compareToIgnoreCase(ToCompare.FirstName);
        return LastName.compareToIgnoreCase(ToCompare.LastName);
    }
    public int Compare(String Last, String First){
        if(LastName.equalsIgnoreCase(Last)) //if last name greater, positive
            return FirstName.compareToIgnoreCase(First);
        return LastName.compareToIgnoreCase(Last);
    }

    public void Parse(){
        boolean Success = StudentParser.ParseAll();

        if (Success)
           System.out.println("PROGRAM RESULT: SUCCESS");
        if (!Success)
           System.out.println("PROGRAM RESULT: FAILURE");
    }
}
