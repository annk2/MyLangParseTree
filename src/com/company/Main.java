package com.company;

import java.util.Locale;

public class Main extends Utility {


    public static void main(String[] args) {
        // write your code here
        Main MyMain = new Main();
        ParseBST MyTree = new ParseBST();
        Reader MenuReader = new Reader("ParseTreeMenuOptions.txt");
        String FileName;
        String Last;
        String First;
        String Command;
        ParseFile ToAdd;

        do{
        MenuReader.PrintFile();

        System.out.println();
        System.out.print("Enter a command from the options above: ");
        Command = MyMain.input.nextLine();
        Command = Command.toLowerCase();

        switch (Command) {
            case "add": {
                System.out.print("Enter the last name of the student to add: ");
                Last = MyMain.input.nextLine();
                System.out.print("Enter the first name of the student to add: ");
                First = MyMain.input.nextLine();
                System.out.print("Enter the name of the student file to add (look at sample/error files if testing): ");
                FileName = MyMain.input.nextLine();
                ToAdd = new ParseFile(Last, First, FileName, "UserTutorial.txt");
                boolean Added = MyTree.Add(ToAdd);
                if(!Added)
                    System.out.println("File Not Found. Nothing Was Added.");
                break;
            }

            case "remove": {
                System.out.print("Enter the last name of the student to remove: ");
                Last = MyMain.input.nextLine();
                System.out.print("Enter the first name of the student to remove: ");
                First = MyMain.input.nextLine();
                boolean Removed = MyTree.Remove(Last, First);
                if(!Removed)
                    System.out.println("Student Not Found. Nothing Was Removed.");
                break;
            }

            case "show": {
                System.out.print("Enter the last name of the student to show: ");
                Last = MyMain.input.nextLine();
                System.out.print("Enter the first name of the student to show: ");
                First = MyMain.input.nextLine();
                boolean Printed = MyTree.Print(Last, First);
                if(!Printed)
                    System.out.println("Student Not Found. Nothing Was Shown.");
                break;
            }

            case "parse": {
                System.out.print("Enter the last name of the student to parse: ");
                Last = MyMain.input.nextLine();
                System.out.print("Enter the first name of the student to parse: ");
                First = MyMain.input.nextLine();
                boolean Parsed = MyTree.Parse(Last, First);
                if(!Parsed)
                    System.out.println("Student Not Found. Nothing Was Parsed.");
                break;
            }

            case "showall": {
                boolean AllPrinted = MyTree.PrintAll();
                if(!AllPrinted)
                    System.out.println("Tree is Empty. Nothing Was Shown.");
                break;
            }

            case "removeall": {
                boolean AllRemoved = MyTree.RemoveAll();
                if (!AllRemoved)
                    System.out.println("Tree is Empty. Nothing Was Removed.");
                break;
            }

            case "quit":
                System.out.println("Program Terminated.");
                break;
            default:
                System.out.println("Please Enter a Valid Command Option.");
            }

            System.out.println();
        }while(!Command.equals("quit"));
    }
}
