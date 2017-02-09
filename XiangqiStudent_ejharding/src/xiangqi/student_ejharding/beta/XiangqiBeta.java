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
import xiangqi.student_ejharding.CXiangqiPiece;

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
		if(aspect == XiangqiColor.BLACK){
			where = CXiangqiCoord.convertToRed(where, numRanks, numFiles);
		}
		return board.getPieceAt(where);
	}
	
	
	private void placeAllPieces(){
		XiangqiPiece redGeneral = new CXiangqiPiece(XiangqiPieceType.GENERAL, XiangqiColor.RED);
		XiangqiPiece redSoldier = new CXiangqiPiece(XiangqiPieceType.SOLDIER, XiangqiColor.RED);
		XiangqiPiece redAdvisorA = new CXiangqiPiece(XiangqiPieceType.ADVISOR, XiangqiColor.RED);
		XiangqiPiece redAdvisorB = new CXiangqiPiece(XiangqiPieceType.ADVISOR, XiangqiColor.RED);
		XiangqiPiece redChariotA = new CXiangqiPiece(XiangqiPieceType.CHARIOT, XiangqiColor.RED);
		XiangqiPiece redChariotB = new CXiangqiPiece(XiangqiPieceType.CHARIOT, XiangqiColor.RED);
		
		XiangqiPiece blackGeneral = new CXiangqiPiece(XiangqiPieceType.GENERAL, XiangqiColor.BLACK);
		XiangqiPiece blackSoldier = new CXiangqiPiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK);
		XiangqiPiece blackAdvisorA = new CXiangqiPiece(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK);
		XiangqiPiece blackAdvisorB = new CXiangqiPiece(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK);
		XiangqiPiece blackChariotA = new CXiangqiPiece(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK);
		XiangqiPiece blackChariotB = new CXiangqiPiece(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK);
		
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
