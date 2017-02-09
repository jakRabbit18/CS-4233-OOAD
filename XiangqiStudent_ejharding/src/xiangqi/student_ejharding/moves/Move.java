package xiangqi.student_ejharding.moves;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
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
	private XiangqiPiece destPiece;
	private Board board;
	private String message;

	public Move(XiangqiCoordinate source, XiangqiCoordinate dest, Board board){
		this.source = source;
		this.destination = dest;
		this.piece = board.getPieceAt(source);
		this.destPiece = board.getPieceAt(dest);
		this.board = board;
		this.message = "";
	}
	
	public boolean isValid(){
		switch(piece.getPieceType()){
		case GENERAL: return validGeneralMove(source, destination);
		case CHARIOT: return validChariotMove(source, destination);
		case ADVISOR: return validAdvisorMove(source, destination);
		default:
			break;
		}
		
		return false;
	}
	

	public boolean undo(){
		return true;
	}
	
	public MoveResult doMove(){
		if(board.placePieceAt(piece, destination)){
			board.removePieceFrom(source);
			return MoveResult.OK;
		}
		board.placePieceAt(destPiece, destination);
		board.placePieceAt(piece, source);
		return MoveResult.ILLEGAL; 
	}
	
	private boolean validChariotMove(XiangqiCoordinate source, XiangqiCoordinate destination) {
		if(!board.isValidLocation(source) || !board.isValidLocation(destination)){
			return false;
		}
		
		//will return false for none-type and
		if(piece.getColor() == XiangqiColor.NONE || piece.getColor().equals(destPiece.getColor())){
			return false;
		}
		
		if((source.getRank() - destination.getRank() == 0) ^ (source.getFile() - destination.getFile() ==0)){
			return true;
		}
		
		return false;
	}
	
	private boolean validAdvisorMove(XiangqiCoordinate source, XiangqiCoordinate destination) {
		if(!board.isValidLocation(source) || !board.isValidLocation(destination)){
			return false;
		}
		
		if(piece.getColor() == XiangqiColor.NONE || piece.getColor().equals(destPiece.getColor())){
			return false;
		} 
		
		if(Math.abs(source.getRank() - destination.getRank()) == 1 && Math.abs(source.getFile() - destination.getFile()) == 1){
			return true;
		}
		
		return false;
	}

	private boolean validGeneralMove(XiangqiCoordinate source, XiangqiCoordinate destination) {
		// TODO Auto-generated method stub
		if(!board.isValidLocation(source) || !board.isValidLocation(destination)){
			return false;
		}
		
		if(piece.getColor() == XiangqiColor.NONE || piece.getColor().equals(destPiece.getColor())){
			return false;
		}
		return false;
	}
}
