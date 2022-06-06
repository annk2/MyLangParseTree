package com.company;

public class Node{

    protected ParseFile StudentFile;
    protected Node Left;
    protected Node Right;

    Node(ParseFile ToParse){
        StudentFile = ToParse;
        Left = null;
        Right = null;
    }

    public String GetLast(){
        return StudentFile.GetLast();
    }

    public String GetFirst(){
        return StudentFile.GetFirst();
    }

    public void Print(){
        StudentFile.Print();
    }

    public void PrintFile(){
        StudentFile.PrintFile();
    }

    public void Parse(){
        StudentFile.Parse();
    }

    public int Compare(ParseFile ToCompare){
        return StudentFile.Compare(ToCompare);
    }

    public int Compare(String Last, String First){
        return StudentFile.Compare(Last, First);
    }

    public Node GetLeft(){
        return Left;
    }

    public Node GetRight(){
        return Right;
    }

    public void SetLeft(Node Connection){
        Left = Connection;
    }

    public void SetRight(Node Connection){
        Right = Connection;
    }
}
