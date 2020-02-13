import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


public class MyVisitor extends MuplBaseVisitor<String> {

    private Map<String, String> memory = new HashMap<>();
    private int numOfErrors;
    private String printStmt = "Semantic = line ";

    @Override public String visit(ParseTree tree){
        super.visit(tree);
        return numOfErrors + "";
    }

    @Override public String visitStart(MuplParser.StartContext ctx){
        super.visitStart(ctx);
        List<TerminalNode> delimiters = ctx.DELIMITER();
        //check if ";" delimiter was used as it would pass syntax check 
        //if any other delimiter is used
        for(TerminalNode tn : delimiters){
            if(!tn.getText().equals(";")){
                printError(printStmt + getLine(tn) + ":" + getColumn(tn) + 
                    " mismatched input '" + tn.getText() + "', expecting ';'");
                
            }
        }
        return null;
    }

    @Override public String visitValue(MuplParser.ValueContext ctx){
        //if value is of type ID then check if it's declared
        //if it's of type Instrument or Literal, Exception will occur due to null ctx.IDENTIFIER()
        try{
            TerminalNode var = ctx.IDENTIFIER();
            if(!memory.containsKey(var.getText())){
                printError(printStmt + getLine(var) + ":" + getColumn(var) + 
                    " variable " +  "'" + var.getText() + "'" + " not declared");
                return null;
            }
            //if it's a valid Identifier
            String type = memory.get(var.getText());
            return type;
        }
        catch(Exception e){
            if(ctx.INSTRUMENT() != null)
                return "instrument";

            return "literal";
        }
    }

    @Override public String visitExpr(MuplParser.ExprContext ctx){
        TerminalNode operator = ctx.OPERATOR();

        String valueType = visitValue(ctx.value());

        //if value is valid i.e instrument, literal or DECLARED variable
        if(valueType != null){
            if(operator != null) {
                //if "=" was used instead, it would passs syntax check
                //so ensuring correct operator was used
                if(!operator.getText().equals("+")){
                    printError(printStmt + getLine(operator) + ":" + getColumn(operator) +
                        " invalid operator '" + operator.getText() + "'");   
                }

                //Making sure compatible types have been used in an expr i.e add/concat statements
                //id of type progression is compatible with itself and literal
                //id of type instrument is compatible with itself and instrument
                String childValueType = visitExpr(ctx.expr());
                try{
                    if(childValueType != null && !valueType.equals(childValueType) && !(valueType.equals("literal") && 
                        childValueType.equals("progression")) && !(valueType.equals("progression") && 
                            childValueType.equals("literal"))){
                        printError(printStmt + ctx.getStart().getLine() + ":" + 
                            ctx.expr().getStart().getCharPositionInLine() + " types mismatch");
                        
                    }
                }
                catch(Exception e){

                }
            }
        }
        return valueType;
    }
    
    @Override public String visitAssign(MuplParser.AssignContext ctx) { 

            TerminalNode variable = ctx.IDENTIFIER();
            String varValue = variable.getText();

            TerminalNode operator = ctx.OPERATOR();
            String operatorValue = operator.getText();

            //Checking correct delimiter usage for end of line i.e ';'
            TerminalNode delimiter = ctx.DELIMITER();
            if(!delimiter.getText().equals(";")){
                printError(printStmt + getLine(delimiter) + ":" + getColumn(delimiter) + 
                    " mismatched input '" + delimiter.getText() + "', expecting ';'");
                
            }

            //Checking correct operator usage for assinment i.e '='
            if(!operatorValue.equals("=")){
                printError(printStmt + getLine(operator) + ":" + getColumn(operator) +
                    " unxpected operator " + "'" + operatorValue + "'");
                
            }

            //Checking if variable already exists
            if (memory.containsKey(varValue)) {
                printError(printStmt + getLine(variable) + ":" + getColumn(variable) +
                    " variable '" + varValue + "'" + " already declared");
                
            }
            else {
                visitExpr(ctx.expr());                    

                //Save data type (instrument, progression) and name of the variable in memory
                //for declaration and type checking
                String type = ctx.TYPE().getText();
                memory.put(varValue, type);
            }

        return null; 
    }

    @Override public String visitCmd(MuplParser.CmdContext ctx) {
        
        List<TerminalNode> keywords = ctx.KEYWORD();
        List<MuplParser.ExprContext> exprs = ctx.expr();
        
        String exprType1 = visitExpr(exprs.get(0));
        String exprType2 = visitExpr(exprs.get(1));

        TerminalNode delimiter = ctx.DELIMITER();
        if(!delimiter.getText().equals(";")){
            printError(printStmt + getLine(delimiter) + ":" + getColumn(delimiter) + 
                " mismatched input '" + delimiter.getText() + "', expecting ';'");
            
        }

        if(keywords.get(0).getText().equals("play") && keywords.get(1).getText().equals("with")){
            if(exprType1 != null && exprType2 != null){
                if(exprType1.equals("instrument")){
                    printError(printStmt + exprs.get(0).getStart().getLine() + ":" + 
                        exprs.get(0).getStart().getCharPositionInLine() + " types mismatch; 'play' should be followed by " +
                            "a progression");
                    
                }
                if(!exprType2.equals("instrument")){
                    printError(printStmt + exprs.get(1).getStart().getLine() + ":" + 
                        exprs.get(1).getStart().getCharPositionInLine() + " types mismatch; 'with' should be followed by " +
                            "an instrument");
                    
                }

                if(ctx.loop() != null)
                    visitLoop(ctx.loop());
            }
        }
        else{
            if(!keywords.get(0).getText().equals("play")){
                printError(printStmt + getLine(keywords.get(0)) + ":" + getColumn(keywords.get(0)) +
                    " mismatched input '" + keywords.get(0).getText() + "', expecting 'play'");
                
            }
            if(!keywords.get(1).getText().equals("with")){
                printError(printStmt + getLine(keywords.get(1)) + ":" + getColumn(keywords.get(1)) +
                    " mismatched input '" + keywords.get(1).getText() + "', expecting 'with'");
                
            }
        }
        return null; 
    }

    @Override public String visitBlock(MuplParser.BlockContext ctx){
        TerminalNode keyword = ctx.KEYWORD();
        TerminalNode del1 = ctx.DELIMITER(0);
        TerminalNode del2 = ctx.DELIMITER(1);

        for(MuplParser.CmdContext cmdCtx : ctx.cmd()){
            visitCmd(cmdCtx);
        }

        //Ensuring valid KEYWORD was used as any other would still pass syntax check
        if(!keyword.getText().equals("at")){
            printError(printStmt + getLine(keyword) + ":" + 
                getColumn(keyword) + " block must begin with 'at'");
        }

        //Ensuring valid OPERATOR was used as any other would still pass syntax check
        if(!del1.getText().equals("[")){
            printError(printStmt + getLine(del1) + ":" + getColumn(del1) +
                " mismatched input '" + del1.getText() + "'");
        }

        //Ensuring valid OPERATOR was used as any other would still pass syntax check
        if(!del2.getText().equals("]")){
            printError(printStmt + getLine(del2) + ":" + getColumn(del2) +
                " mismatched input '" + del2.getText() + "'");
        }

        return null;
    }

    @Override public String visitLoop(MuplParser.LoopContext ctx){
        TerminalNode keyword = ctx.KEYWORD();

        //Ensuring valid KEYWORD was used as any other would still pass syntax check
        if(!keyword.getText().equals("times")){
            printError(printStmt + getLine(keyword) + ":" + getColumn(keyword) +
                " mismatched input '" + keyword.getText() + "', expecting 'times'");
        }
        return null;
    }

    //returns line number of the token
    private int getLine(TerminalNode node){
        return node.getSymbol().getLine();
    }

    //returns index of the first letter of the token value in the line where it was found
    private int getColumn(TerminalNode node) {
        return node.getSymbol().getCharPositionInLine();
    }

    private void printError(String statement){
        System.out.println(statement);
        numOfErrors++;
    }
}