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
	
	protected int moveCount;
	protected int maxMoves;
	
	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMoveMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect) {
		// TODO Auto-generated method stub
		return null;
	}

}
