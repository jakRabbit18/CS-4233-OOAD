package xiangqi.student_ejharding;

import java.util.Stack;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiPiece;

public abstract class XiangqiGameImpl implements XiangqiGame {

	protected Board board;
	protected XiangqiColor currentPlayer;
	protected Stack<Move> moveStack;
	protected String moveMessage;
	protected int moveCount;
	protected int maxMoves;
	
	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMoveMessage() {
		return moveMessage;
	}

	@Override
	public XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected void switchPlayers(){
		if(currentPlayer.equals(XiangqiColor.RED)){
			currentPlayer = XiangqiColor.BLACK;
		} else currentPlayer = XiangqiColor.RED;
	}

}
