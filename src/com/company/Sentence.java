package com.company;

public class Sentence extends Variable{

    protected String [] Value;

    public Sentence(String Name){
        super(DataType.SENTENCE, Name);
        Value = null;
    }

    public boolean CompareValue(String CompValue){
        String [] Isolate = CompValue.split("\"");
        CompValue = Isolate[1];
        String [] SplitCompValue = CompValue.split(" ");
        for(int i = 0; i<SplitCompValue.length; ++i){
            if(!Value[i].equals(SplitCompValue[i]))
                return false;
        }
            return true;
    }

    public boolean CompareVariable(Variable CompVariable){
        for(int i = 0; i<((Sentence)CompVariable).Value.length; ++i){
        if(!Value[i].equals(((Sentence)CompVariable).Value[i]))
            return false;
    }
            return true;
    }

    public void SetVariable(Variable ChangeVariable){
        Value = new String[((Sentence)ChangeVariable).Value.length];
        for(int i = 0; i<((Sentence)ChangeVariable).Value.length; ++i)
            Value[i] = ((Sentence)ChangeVariable).Value[i];
    }

    public void SetValue(String ChangeValue) {
        String [] Isolate = ChangeValue.split("\"");
        ChangeValue = Isolate[1];
        Value = ChangeValue.split(" ");
    }

    //need indexing capabilities

    public void Print(){
        if(Value == null) {
            System.out.println("null");
            return;
        }

        for(int i = 0; i<Value.length; ++i) {
            System.out.print(Value[i] + " ");
        }
        System.out.println();
    }

}
