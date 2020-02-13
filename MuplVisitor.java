// Generated from Mupl.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MuplParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MuplVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MuplParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(MuplParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuplParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MuplParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuplParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(MuplParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuplParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MuplParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuplParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(MuplParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuplParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MuplParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuplParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(MuplParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuplParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(MuplParser.LoopContext ctx);
}