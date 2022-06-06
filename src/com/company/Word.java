package com.company;

public class Word extends Variable{

    protected String Value;

    public Word(String Name){
        super(DataType.WORD, Name);
        Value = null;
    }

    public boolean CompareValue(String CompValue){
        if(!Value.equals(CompValue))
                return false;
        return true;
    }

    public boolean CompareVariable(Variable CompVariable){
        if(!Value.equals(((Word)CompVariable).Value))
                return false;
        return true;
    }

    public void SetVariable(Variable ChangeVariable){
        Value = ((Word)ChangeVariable).Value;
    }

    public void SetValue(String ChangeValue) {
        String [] Isolate = ChangeValue.split("\"");
        Value = Isolate[1];
    }

    public void Print(){
        System.out.println(Value);
    }
}
