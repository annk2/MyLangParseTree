package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Reader{

    protected String FileName;
    protected Scanner AReader;
    protected List<String> FileLines;
    protected int CurrentLineNum;

    public Reader(String FileToOpen) {
        try {
            FileLines = Files.readAllLines(Paths.get(FileToOpen));
            this.FileName = FileToOpen;
            this.CurrentLineNum = 0;
        } catch (IOException e) {
            System.out.println("FILE NOT FOUND.");
            FileLines = null;
            CurrentLineNum = 0;
        }
    }

    public boolean FileNotExist(){
        if(FileLines == null)
            return true;
        return false;
    }

    public void PrintFile(){
        for(int i = 0; i < FileLines.size(); ++i) {
            System.out.println(FileLines.get(i));
        }
    }

    /*
    public Reader(String FileToOpen) {
        try {
            System.out.println(FileToOpen);
            File MyObj = new File(FileToOpen);
            this.AReader = new Scanner(MyObj);
            if(this.AReader.hasNextLine()) {
                this.FileName = FileToOpen;
                this.CurrentLineNum = 1;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
     */

    public void ErrorMessage(){
        System.out.println("ERROR ON LINE " + (CurrentLineNum));
    }

    public void SetCurrentLine(int SetLineNum){
        CurrentLineNum = SetLineNum;
    }

    public int GetCurrentLine(){
        return CurrentLineNum;
    }

    public String ReadLine(){

        if (this.AReader.hasNextLine()) {
            String LineRead = this.AReader.nextLine();
            System.out.println("Line " + (this.CurrentLineNum+1) + "\t" + LineRead);
            ++this.CurrentLineNum;
            return LineRead;
        }

        else {
            System.out.println("Program Finished!");
            return null;
        }
    }

    public String ReadLine(int ToRead){
        String LineRead = null;
        LineRead = FileLines.get(ToRead);
        //System.out.println("Line " + (this.CurrentLineNum+1) + "\t" + LineRead);
        ++this.CurrentLineNum;
        return LineRead;
    }

    /*
    public boolean HasNext(){
        if (this.AReader.hasNextLine())
            return true;
        return false;
    }

    public void CloseFile(){
        this.AReader.close();
    }
     */
}
