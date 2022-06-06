package com.company;

public abstract class Variable {

    enum DataType {NUMBER, WORD, SENTENCE} //DO I NEED THIS??
    protected DataType Type;
    protected String Variable_Name;

    public Variable(DataType AType, String Name){
        Type = AType;
        Variable_Name = Name.trim();
    }

    public boolean Same(String ToCompare){
//        System.out.println(Variable_Name);
 //       System.out.println(ToCompare);
        ToCompare = ToCompare.trim();
        Variable_Name = Variable_Name.trim();
        if(Variable_Name.equals(ToCompare))
            return true;
        return false;
    }

    public void PrintName(){
        System.out.print(Variable_Name);
    }

    public abstract boolean CompareValue(String CompValue);
    public abstract boolean CompareVariable(Variable CompVariable);
    public abstract void SetValue(String ChangeValue);
    public abstract void SetVariable(Variable ChangeVariable);
    public abstract void Print();
}
