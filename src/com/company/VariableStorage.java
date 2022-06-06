package com.company;
import java.util.*;

public class VariableStorage extends Utility{

    Vector<Variable> VariableList;

    protected boolean IsLiteral(String CheckString){
        for (int i = 0; i < CheckString.length(); ++i) {
            if (CheckString.charAt(i) == '\"')
                return true;
        }
        return false;
    }

    protected boolean IsNumber(String CheckString){
        for (int i = 0; i < CheckString.length(); ++i) {
            //should print something to test this
        if (CheckString.charAt(i) >= '0' && CheckString.charAt(i) <= '9')
            return true;
        }
        return false;
    }

    public VariableStorage(){
        VariableList = new Vector<Variable>(1);
    }

    public void ViewVariableList(){
        System.out.println();
        System.out.println("DISPLAYING FINAL VARIABLE LIST");
        for (int i = 0; i < VariableList.size(); ++i) {
            VariableList.get(i).PrintName();
            System.out.print(" = ");
            VariableList.get(i).Print();
        }
    }

    /*
    public boolean VariableValid(String VariableName) {
        for (int i = 0; i < VariableList.size(); ++i) {
            if (VariableList.get(i).Same(VariableName))
                return true;
        }
        return false;
    }
     */

    public Variable FindVariable(String VariableName) {
        for (int i = 0; i < VariableList.size(); ++i) {
            if (VariableList.get(i).Same(VariableName))
                return VariableList.get(i);
        }

        System.out.println("THE VARIABLE " + VariableName + " HAS NOT BEEN CREATED YET.");
        return null;
    }

    public boolean ChangeVariableToValue(String VariableName, String ChangeValue){
        Variable Found = FindVariable(VariableName);
        if(Found == null){
            return false;
        }

        Found.SetValue(ChangeValue);
        return true;
    }

    public boolean ChangeVariableToVariable(String VariableName, String ChangeVariable){
        Variable Found = FindVariable(VariableName);
        if(Found == null) {
            return false;
        }

        Variable Found2 = FindVariable(ChangeVariable);
        if(Found2 == null) {
            return false;
        }

        Found.SetVariable(Found2);
        return true;
    }

    public boolean CompareConditionalLiteral(boolean Opposite, String VariableName, String CompValue) {
        Variable Found = FindVariable(VariableName);
        if (Found == null) {
            return false;
        }

        boolean Same = Found.CompareValue(CompValue);
        if(Opposite)
            return (!Same);
        return Same;
    }

    public boolean CompareConditionalVariable(boolean Opposite, String VariableName, String CompVariable) {
        Variable Found = FindVariable(VariableName);
        //change these so throw something
        if (Found == null) {
            return false;
        }
        Variable Found2 = FindVariable(CompVariable);
        if (Found2 == null) {
            return false;
        }

        boolean Same = Found.CompareVariable(Found2);
        if(Opposite)
            return (!Same);
        return Same;
    }

    public boolean AddVariable(String AddType, String AddName) {
        Variable ToAdd = null;
        switch (AddType) {
            case "NUMBER":
                ToAdd = new Number(AddName);
                break;
            case "WORD":
                ToAdd = new Word(AddName);
                break;
            case "SENTENCE":
                ToAdd = new Sentence(AddName);
                break;
        }
        if(ToAdd == null) {
            System.out.println("Type not valid");
            return false;
        }
        VariableList.add(ToAdd);
        return true;
    }
}
