package com.company;

public class Number extends Variable{

    protected int Value;

    public Number(String Name){
        super(DataType.NUMBER, Name);
        Value = 0;
    }

    public boolean CompareValue(String CompValue){
        int RealCompValue = Integer.parseInt(CompValue);
        if(Value != RealCompValue)
            return false;
        return true;
    }

    public boolean CompareVariable(Variable CompVariable){
        if(Value != ((Number)CompVariable).Value)
            return false;
        return true;
    }

    public void SetVariable(Variable ChangeVariable){
        Value = ((Number)ChangeVariable).Value;
    }

    public void SetValue(String ChangeValue) {
        Value = Integer.parseInt(ChangeValue);
    }

    public void Print(){
        System.out.println(Value);
    }
}
