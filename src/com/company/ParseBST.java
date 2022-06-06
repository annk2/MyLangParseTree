package com.company;

public class ParseBST {

    protected Node Root;

    ParseBST(){
        Root = null;
    }

    private Node Add(Node Root, ParseFile ToAdd){
        if (Root == null) {
            return new Node(ToAdd);
        }

        if (Root.Compare(ToAdd) > 0)
            Root.SetLeft(Add(Root.GetLeft(), ToAdd));
        else if (Root.Compare(ToAdd) <= 0)
            Root.SetRight(Add(Root.GetRight(), ToAdd));

        return Root;
    }

    private void PrintAll(Node Root){
        if (Root == null){
           return;
        }
        PrintAll(Root.GetLeft());
        Root.Print();
        PrintAll(Root.GetRight());
    }

    private void RemoveAll(Node Root){
        if (Root == null){
            return;
        }
        RemoveAll(Root.GetLeft());
        RemoveAll(Root.GetRight());

        Root = null;
    }

    private Node Search(Node Root, String Last, String First)
    {
        if (Root == null || Root.Compare(Last, First) == 0)
            return Root;

        if (Root.Compare(Last, First) < 0)
            return Search(Root.GetRight(), Last, First);

        return Search(Root.GetLeft(), Last, First);
    }

    private Node Remove(Node Root, String Last, String First)
    {
        if (Root == null)
            return Root;

        if (Root.Compare(Last, First) > 0)
            Root.SetLeft(Remove(Root.GetLeft(), Last, First));
        else if (Root.Compare(Last, First) < 0)
            Root.SetRight(Remove(Root.GetRight(), Last, First));

        else {
            if (Root.GetLeft() == null)
                return Root.GetRight();
            else if (Root.GetRight() == null)
                return Root.GetLeft();

            Root.StudentFile = InOrderSuc(Root.GetRight());

            Root.SetRight(Remove(Root.GetRight(), Root.GetLast(), Root.GetFirst()));
        }

        return Root;
    }

    private ParseFile InOrderSuc(Node Root)
    {
        ParseFile IOSFile = Root.StudentFile;
        while (Root.GetLeft() != null)
        {
            IOSFile = Root.GetLeft().StudentFile;
            Root = Root.GetLeft();
        }
        return IOSFile;
    }

    public boolean Add(ParseFile ToAdd){
        if(ToAdd.FileNotExist())
            return false;
        Root = Add(Root, ToAdd);
        return true;
    }

    public boolean Print(String Last, String First){
        if (Root == null)
            return false;
        Node Found = Search(Root, Last, First);
        if (Found == null)
            return false;
        Found.PrintFile();
        return true;
    }

    public boolean Remove(String Last, String First){
        if (Root == null)
            return false;
        Node Found = Search(Root, Last, First);
        if (Found == null)
            return false;
        Root = Remove(Root, Last, First);
        return true;
    }

    public boolean Parse(String Last, String First){
        if (Root == null)
            return false;
        Node Found = Search(Root, Last, First);
        if (Found == null)
            return false;
        Found.Parse();
        return true;
    }

    public boolean PrintAll(){
        if (Root == null){
            return false;
        }
        PrintAll(Root);
        return true;
    }

    public boolean RemoveAll(){
        if (Root == null){
            return false;
        }
        RemoveAll(Root);
        Root = null;
        return true;
    }
}
