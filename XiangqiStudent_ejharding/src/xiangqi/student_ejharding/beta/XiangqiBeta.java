package xiangqi.student_ejharding.beta;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.student_ejharding.Board;
import xiangqi.student_ejharding.CXiangqiCoord;
import xiangqi.student_ejharding.XiangqiPieceImpl;
import xiangqi.student_ejharding.moves.Move;

public class XiangqiBeta implements XiangqiGame {

	final XiangqiGameVersion version;
	final int numRanks, numFiles;
	Board board;

	public XiangqiBeta(){
		version = XiangqiGameVersion.BETA_XQ;
		numRanks = numFiles = 5;		
		board = new Board(numRanks, numFiles);
		placeAllPieces();
	}

	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate destination) {
		if(!board.isValidLocation(source) || !board.isValidLocation(destination)){
			return MoveResult.ILLEGAL;
		}
		
		Move move = new Move(source, destination, board);
		if(move.isValid()){
			return move.doMove();
		} else {
			return MoveResult.ILLEGAL;
		}
	}

	@Override
	public String getMoveMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect) {
		if(aspect == XiangqiColor.BLACK){
			where = CXiangqiCoord.convertToRed(where, numRanks, numFiles);
		}
		return board.getPieceAt(where);
	}
	
	
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
		
		board.placePieceAt(redChariotA, new CXiangqiCoord(1,1));
		board.placePieceAt(redAdvisorA, new CXiangqiCoord(1,2));
		board.placePieceAt(redSoldier, new CXiangqiCoord(2,3));
		board.placePieceAt(redGeneral, new CXiangqiCoord(1,3));
		board.placePieceAt(redAdvisorB, new CXiangqiCoord(1,4));
		board.placePieceAt(redChariotB, new CXiangqiCoord(1,5));
		
		board.placePieceAt(blackChariotA, new CXiangqiCoord(1,1));
		board.placePieceAt(blackAdvisorA, new CXiangqiCoord(1,2));
		board.placePieceAt(blackSoldier, new CXiangqiCoord(2,3));
		board.placePieceAt(blackGeneral, new CXiangqiCoord(1,3));
		board.placePieceAt(blackAdvisorB, new CXiangqiCoord(1,4));
		board.placePieceAt(blackChariotB, new CXiangqiCoord(1,5));
	}
}
