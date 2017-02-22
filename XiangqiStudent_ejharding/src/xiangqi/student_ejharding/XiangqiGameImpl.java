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
	protected int turnCount;
	protected int maxTurns;
	
	@Override
	public String getMoveMessage() {
		return moveMessage;
	}

	protected void switchPlayers(){
		if(currentPlayer.equals(XiangqiColor.RED)){
			currentPlayer = XiangqiColor.BLACK;
		} else currentPlayer = XiangqiColor.RED;
	}

}
