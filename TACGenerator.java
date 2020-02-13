import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class TACGenerator {

    private TokenStream tokenStream;
    private ArrayList<String> output;
    private int count;
    private int index;
    private int labelCount;

    public TACGenerator(TokenStream tokenStream){
        this.tokenStream = tokenStream;
        output = new ArrayList<>();
        generateTAC();
    }

    private void generateTAC(){
        try {
            Token token = null;
            while(true){
                token = getNext();
                if(token.getText().equals("=")){
                    generateAssignStmt(token);
                    output.add("\n");
                    
                }
                if(token.getText().equals("at")){
                    generateAtStmt(token);
                }
                if(token.getText().equals("play")){
                    generatePlayStmt(token, "");
                    output.add("\n");
                }
            }
        } catch (Exception e) {
            
        }
    }

    private void generateAssignStmt(Token token){
        String expr = tokenStream.get(index - 2).getText();
        String temp = generateAddStmt(getNext());
        output.add(expr + " = " + temp);
    }

    private String generateAddStmt(Token token){
        String addTo = token.getText();
        String expr = "";
        String temp = "t" + count++;
        boolean addInList = true;
        Token next = getNext();
        while(next.getType() != 10){
            next = getNext();
            expr = addTo + " + " + next.getText();  
            output.add(temp + " = " + expr);
            addTo = temp;
            next = getNext();
            if(next.getType() != 10)
                temp = "t" + count++;
            addInList = false;
        }
        if(addInList)
            output.add(temp + " = " + addTo);
        return temp;
    }

    private void generatePlayStmt(Token token, String atStmt){ //token = play
        String loopInitializerStmt = "i = 0";
        String label = "L" + labelCount;
        String incrementStmt = "";
        String gotoStmt = "";

        String progression = getNext().getText();
        getNext();
        String instrument = getNext().getText();

        if(tokenStream.get(index).getType() == 5){
            labelCount++;
            output.add(loopInitializerStmt);
            output.add(label + ":");
            incrementStmt = "\ti = i + 1";
            gotoStmt = "if i < " + tokenStream.get(index).getText() + " goto " + label;
            getNext();
            getNext();
        }

        String temp1 = "t" + (count++);
        String temp2 = "t" + (count++);

        String tab = "";
        if(!gotoStmt.equals(""))
            tab = "\t";
        String line1 = tab + temp1 + " = play(" + progression + ")" + atStmt;
        String line2 = tab + temp2 + " = " + temp1 + " + with(" + instrument + ")";

        output.add(line1);
        output.add(line2);       

        if(!gotoStmt.equals("")){
            output.add(incrementStmt);
            output.add(gotoStmt);
        }
    }

    private void generateAtStmt(Token token){
        token = getNext();
        String atStmt = " + at(" + token.getText() + ")";
        getNext();
        token = getNext();
        while(!token.getText().equals("]")){
            generatePlayStmt(token, atStmt);
            getNext();
            getNext();
            token = tokenStream.get(index);
        }
    }

    private Token getNext(){
        return tokenStream.get(index++);
    }

    //private String 
    public void printTokens(){
        int i = 0;
        try {
            while(true){
                Token token = tokenStream.get(i);
                System.out.println("Type: " + token.getType() + ", Value: " + token.getText());
                i++;
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void writeOutputToFile(){
        try (PrintWriter out = new PrintWriter("output.txt")) {
            for(String line : output)
                out.println(line);
        }
        catch(FileNotFoundException fnf){

        }
    }

}