package xiangqi.student_ejharding.gamma;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.student_ejharding.Board;
import xiangqi.student_ejharding.Move;
import xiangqi.student_ejharding.MyCoordinate;
import xiangqi.student_ejharding.XiangqiGameImpl;
import xiangqi.student_ejharding.XiangqiPieceImpl;
import static xiangqi.student_ejharding.XiangqiPieceFactory.*;

import java.util.Stack;

public class XiangqiGamma extends XiangqiGameImpl {

	public XiangqiGamma(){
		board = new Board(10,9);
		currentPlayer = XiangqiColor.RED;
		moveStack = new Stack<Move>();
		moveMessage = "New Game";
		moveCount = 0;
		maxMoves = 25;
		placeAllPieces();
	}
	
	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate destination) {
		// TODO Auto-generated method stub
		MyCoordinate c1 = MyCoordinate.copyCoordinate(source, board);
		MyCoordinate c2 = MyCoordinate.copyCoordinate(destination, board);
		
		if(currentPlayer == XiangqiColor.BLACK){
			c1 = MyCoordinate.convertToRedAspect(c1, board);
			c2 = MyCoordinate.convertToRedAspect(c2, board);
		}
		
		System.out.println("Before Move "+Integer.toString(moveCount)+" :");
		System.out.println(board.toString());
		
		Move move = new Move(c1,c2, board, currentPlayer);
		if(move.isValid()){
			move.doMove();
			moveMessage = move.getMessage();
			moveStack.push(move);
			switchPlayers();
			return MoveResult.OK;
		}
		moveMessage = "Can't do that...";
		return MoveResult.ILLEGAL;
	}

	@Override
	public String getMoveMessage() {
		// TODO Auto-generated method stub
		return this.moveMessage;
	}

	@Override
	public XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect) {
		// TODO Auto-generated method stub
		return board.getPieceAt(MyCoordinate.copyCoordinate(where, board));
	}
	
	private void placeAllPieces(){		
		board.placePieceAt(makeRedChariot(), new MyCoordinate(1,1,board));
		board.placePieceAt(makeRedElephant(), new MyCoordinate(1,3, board));
		board.placePieceAt(makeRedAdvisor(), new MyCoordinate(1,4,board));
		board.placePieceAt(makeRedGeneral(), new MyCoordinate(1,5,board));
		board.placePieceAt(makeRedAdvisor(), new MyCoordinate(1,6,board));
		board.placePieceAt(makeRedElephant(), new MyCoordinate(1,7,board));
		board.placePieceAt(makeRedChariot(), new MyCoordinate(1,9,board));
		
		board.placePieceAt(makeRedSoldier(), new MyCoordinate(4,1,board));
		board.placePieceAt(makeRedSoldier(), new MyCoordinate(4,3,board));
		board.placePieceAt(makeRedSoldier(), new MyCoordinate(4,5,board));
		board.placePieceAt(makeRedSoldier(), new MyCoordinate(4,7,board));
		board.placePieceAt(makeRedSoldier(), new MyCoordinate(4,9,board));

		board.placePieceAt(makeBlackChariot(), new MyCoordinate(10,1,board));
		board.placePieceAt(makeBlackElephant(), new MyCoordinate(10,3,board));
		board.placePieceAt(makeBlackAdvisor(), new MyCoordinate(10,4,board));
		board.placePieceAt(makeBlackGeneral(), new MyCoordinate(10,5,board));
		board.placePieceAt(makeBlackAdvisor(), new MyCoordinate(10,6,board));
		board.placePieceAt(makeBlackElephant(), new MyCoordinate(10,7,board));
		board.placePieceAt(makeBlackChariot(), new MyCoordinate(10,9,board));
		
		board.placePieceAt(makeBlackSoldier(), new MyCoordinate(7,1,board));
		board.placePieceAt(makeBlackSoldier(), new MyCoordinate(7,3,board));
		board.placePieceAt(makeBlackSoldier(), new MyCoordinate(7,5,board));
		board.placePieceAt(makeBlackSoldier(), new MyCoordinate(7,7,board));
		board.placePieceAt(makeBlackSoldier(), new MyCoordinate(7,9,board));
	}

}
