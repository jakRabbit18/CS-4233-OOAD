package xiangqi.student_ejharding.alpha;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.student_ejharding.Board;
import xiangqi.student_ejharding.CXiangqiCoord;
import xiangqi.student_ejharding.XiangqiPieceImpl;

/**
 * This class implements the Alpha version of Xiangqi
 * It uses only the generals on a 2x2 board. The generals are initially
 * placed on 11 (for each aspect)
 * @author Everett Harding
 *
 */
public class XiangqiAlpha implements XiangqiGame {

	Board board;
	int moveCount = 0;
	
	public XiangqiAlpha(){
		board = new Board(3,3);
		board.placePieceAt(new XiangqiPieceImpl(XiangqiPieceType.GENERAL, XiangqiColor.RED), new CXiangqiCoord(1,1));
		board.placePieceAt(new XiangqiPieceImpl(XiangqiPieceType.GENERAL, XiangqiColor.BLACK), new CXiangqiCoord(1,1));
	}
	
	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate destination) {
		if(source.getRank() > board.getNumFiles()){
			return MoveResult.ILLEGAL;
		}
		if(source.getFile() > board.getNumFiles()){
			return MoveResult.ILLEGAL;
		}
		if(destination.getRank() > board.getNumFiles()){
			return MoveResult.ILLEGAL;
		}
		if(destination.getFile() > board.getNumFiles()){
			return MoveResult.ILLEGAL;
		}
		if((Math.abs(source.getRank() - destination.getRank()) == 1 && Math.abs(source.getFile() - destination.getFile()) == 0) ||
				(Math.abs(source.getRank() - destination.getRank()) == 0 && Math.abs(source.getFile() - destination.getFile()) == 1)){
			if(moveCount >= 1)
				return MoveResult.RED_WINS;
			moveCount++;
			return MoveResult.OK;
		}
		return MoveResult.ILLEGAL;
	}

	@Override
	public String getMoveMessage() {
		// TODO Auto-generated method stub
		return "Move Message";
	}

	@Override
	public XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect) {
		// TODO Auto-generated method stub
		return new XiangqiPieceImpl(XiangqiPieceType.NONE, XiangqiColor.NONE);
	}

}
