package xiangqi.student_ejharding.beta;

import java.util.Stack;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.student_ejharding.Board;
import xiangqi.student_ejharding.Move;
import xiangqi.student_ejharding.MyCoordinate;
import xiangqi.student_ejharding.XiangqiGameImpl;
import xiangqi.student_ejharding.XiangqiPieceImpl;

public class XiangqiBeta extends XiangqiGameImpl {

	final XiangqiGameVersion version;
	final int numRanks, numFiles;

	public XiangqiBeta(){
		version = XiangqiGameVersion.BETA_XQ;
		numRanks = numFiles = 5;		
		board = new Board(numRanks, numFiles);
		currentPlayer = XiangqiColor.RED;
		moveCount = 0;
		maxMoves = 10;
		moveStack = new Stack<Move>();
		placeAllPieces();
	}

	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate destination) {
		boolean checkToStart = board.generalInCheck(currentPlayer);

		if(currentPlayer == XiangqiColor.BLACK){
			source = MyCoordinate.convertToRedAspect(MyCoordinate.copyCoordinate(source, board),board);
			destination = MyCoordinate.convertToRedAspect(MyCoordinate.copyCoordinate(destination, board), board);
		}
		System.out.println("Before Move "+Integer.toString(moveCount)+" :");
		System.out.println(board.toString());
		Move move = new Move(source, destination, board, currentPlayer);
		
		if(move.isValid()){
			MoveResult result = move.doMove();
			System.out.println("After Move " + Integer.toString(moveCount) +" :");
			System.out.println(board.toString());
			
			if(checkToStart && board.generalInCheck(currentPlayer)){
				move.undo();
				moveMessage = "That's Illegal.";
				return MoveResult.ILLEGAL;
			} else {
				moveCount ++;
				if(moveCount > 2* maxMoves){
					moveMessage = move.getMessage();
					result = MoveResult.DRAW;
				}
				moveMessage = move.getMessage();
				moveStack.push(move);
				switchPlayers();
				return result;
			}
		} else {
			moveMessage = move.getMessage();
			return MoveResult.ILLEGAL;
		}
	}

//	@Override
//	public String getMoveMessage() {
//		return moveStack.peek().getMessage();
//	}

	@Override
	public XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect) {
		if(aspect == XiangqiColor.BLACK){
			where = MyCoordinate.convertToRedAspect(MyCoordinate.copyCoordinate(where, board), board);
		}
		return board.getPieceAt(where);
	}

//	private void switchPlayers(){
//		if(currentPlayer.equals(XiangqiColor.RED)){
//			currentPlayer = XiangqiColor.BLACK;
//		} else currentPlayer = XiangqiColor.RED;
//	}
	
	private void placeAllPieces(){
		XiangqiPiece redGeneral = new XiangqiPieceImpl(XiangqiPieceType.GENERAL, XiangqiColor.RED);
		XiangqiPiece redSoldier = new XiangqiPieceImpl(XiangqiPieceType.SOLDIER, XiangqiColor.RED);
		XiangqiPiece redAdvisorA = new XiangqiPieceImpl(XiangqiPieceType.ADVISOR, XiangqiColor.RED);
		XiangqiPiece redAdvisorB = new XiangqiPieceImpl(XiangqiPieceType.ADVISOR, XiangqiColor.RED);
		XiangqiPiece redChariotA = new XiangqiPieceImpl(XiangqiPieceType.CHARIOT, XiangqiColor.RED);
		XiangqiPiece redChariotB = new XiangqiPieceImpl(XiangqiPieceType.CHARIOT, XiangqiColor.RED);

		XiangqiPiece blackGeneral = new XiangqiPieceImpl(XiangqiPieceType.GENERAL, XiangqiColor.BLACK);
		XiangqiPiece blackSoldier = new XiangqiPieceImpl(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK);
		XiangqiPiece blackAdvisorA = new XiangqiPieceImpl(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK);
		XiangqiPiece blackAdvisorB = new XiangqiPieceImpl(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK);
		XiangqiPiece blackChariotA = new XiangqiPieceImpl(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK);
		XiangqiPiece blackChariotB = new XiangqiPieceImpl(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK);

		board.placePieceAt(redChariotA, new MyCoordinate(1,1,board));
		board.placePieceAt(redAdvisorA, new MyCoordinate(1,2,board));
		board.placePieceAt(redSoldier, new MyCoordinate(2,3,board));
		board.placePieceAt(redGeneral, new MyCoordinate(1,3,board));
		board.placePieceAt(redAdvisorB, new MyCoordinate(1,4,board));
		board.placePieceAt(redChariotB, new MyCoordinate(1,5,board));

		board.placePieceAt(blackChariotA, new MyCoordinate(5,1,board));
		board.placePieceAt(blackAdvisorA, new MyCoordinate(5,2,board));
		board.placePieceAt(blackSoldier, new MyCoordinate(4,3,board));
		board.placePieceAt(blackGeneral, new MyCoordinate(5,3,board));
		board.placePieceAt(blackAdvisorB, new MyCoordinate(5,4,board));
		board.placePieceAt(blackChariotB, new MyCoordinate(5,5,board));
	}
}
