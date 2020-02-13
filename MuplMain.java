import java.awt.Dimension;
import java.io.FileInputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.gui.TestRig;

public class MuplMain {
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(args[0]));
        // create a lexer that feeds off of input CharStream
        MuplLexer lexer = new MuplLexer(input);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
        MuplParser parser = new MuplParser(tokens);

        ParseTree tree = parser.start(); // begin parsing at init rule

        MyVisitor eval = new MyVisitor();

        int numSyntaxErrors = parser.getNumberOfSyntaxErrors();
        int numSemanticErrors = 0;
        //System.out.println(numSyntaxErrors);

        TACGenerator tac = new TACGenerator(parser.getTokenStream());
        
        if(numSyntaxErrors == 0){
            numSemanticErrors = Integer.parseInt(eval.visit(tree));
            if(numSemanticErrors == 0){
                System.out.println("build successful");
                tac.writeOutputToFile();
            }
            else{
                System.out.println("build failed; three address code not generated");
            }
        }
        else{
            System.out.println("build failed; three address code not generated");
        }

        try {
            if(args[1].equals("tokens")){
                System.out.println();
                tac.printTokens(); 
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

        //TestRig gui = new TestRig(args);
        //gui.process();

        try {
            if(args[2].equals("gui")){
                JFrame frame = new JFrame("MuPL AST");
                JPanel panel = new JPanel();
                TreeViewer viewr = new TreeViewer(Arrays.asList(
                    parser.getRuleNames()),tree);
                try {
                    viewr.setScale(Integer.parseInt(args[5]));
                } catch (Exception e) {
                    viewr.setScale(2);
                }
                JScrollPane scrollPane = new JScrollPane(panel);
                panel.add(viewr);

                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                
                
                JPanel contentPane = new JPanel(null);

                int width = 1500, height = 600;
                try {
                    height = Integer.parseInt(args[4]);
                    width = Integer.parseInt(args[3]);
                } catch (Exception e) {
                    width = 1500;
                    height = 600;
                }

                scrollPane.setBounds(0, 0, width, height);
                contentPane.setPreferredSize(new Dimension(width, height));
                contentPane.add(scrollPane);

                
                frame.setContentPane(contentPane);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocation(0, 0);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        }
        catch(Exception e){

        }
        
    }
}