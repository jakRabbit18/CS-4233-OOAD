package xiangqi.student_ejharding.moves;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.student_ejharding.Board;
/**
 * class to handle making moved in the game
 * @author Rett
 *
 */
public class Move {

	private XiangqiCoordinate destination;
	private XiangqiCoordinate source;
	private XiangqiPiece piece;
	private Board board;
	private String message;

	public Move(XiangqiCoordinate source, XiangqiCoordinate dest, Board board){
		this.source = source;
		this.destination = dest;
		this.piece = board.getPieceAt(source);
		this.board = board;
		this.message = "";
	}
	
	public boolean isValid(){
		this.message = "Illegal Move";
		return false;
	}
	
	public boolean undo(){
		return true;
	}
	
	public MoveResult doMove(){
		return MoveResult.ILLEGAL; 
	}
}
