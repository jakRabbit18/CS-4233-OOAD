package xiangqi.student_ejharding.gamma;

import static xiangqi.common.XiangqiColor.*;
import static xiangqi.common.XiangqiPieceType.*;
import static org.junit.Assert.*;
import static xiangqi.common.MoveResult.*;
import org.junit.*;
import xiangqi.XiangqiGameFactory;
import xiangqi.common.*;
import xiangqi.student_ejharding.TestCoordinate;

public class XiangqiGammaTests {

	TestCoordinate[][] board;
	XiangqiGame gamma;
	
	@Before
	public void setup(){
		gamma = XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.GAMMA_XQ);
		board = TestCoordinate.makeFullBoardofCoordinates(10, 9);
	}
	
	@Test
	public void correctPiecePlacement(){
		//Red pieces
		assertEquals(CHARIOT, gamma.getPieceAt(board[1][1], RED).getPieceType());
		assertEquals(ELEPHANT, gamma.getPieceAt(board[1][3], RED).getPieceType());
		assertEquals(ADVISOR, gamma.getPieceAt(board[1][4], RED).getPieceType());
		assertEquals(GENERAL, gamma.getPieceAt(board[1][5], RED).getPieceType());
		assertEquals(ADVISOR, gamma.getPieceAt(board[1][6], RED).getPieceType());
		assertEquals(ELEPHANT, gamma.getPieceAt(board[1][7], RED).getPieceType());
		assertEquals(CHARIOT, gamma.getPieceAt(board[1][9], RED).getPieceType());
		assertEquals(SOLDIER, gamma.getPieceAt(board[4][1], RED).getPieceType());
		assertEquals(SOLDIER, gamma.getPieceAt(board[4][3], RED).getPieceType());
		assertEquals(SOLDIER, gamma.getPieceAt(board[4][5], RED).getPieceType());
		assertEquals(SOLDIER, gamma.getPieceAt(board[4][7], RED).getPieceType());
		assertEquals(SOLDIER, gamma.getPieceAt(board[4][9], RED).getPieceType());
		//Black pieces
		assertEquals(CHARIOT, gamma.getPieceAt(board[1][1], BLACK).getPieceType());
		assertEquals(ELEPHANT, gamma.getPieceAt(board[1][3], BLACK).getPieceType());
		assertEquals(ADVISOR, gamma.getPieceAt(board[1][4], BLACK).getPieceType());
		assertEquals(GENERAL, gamma.getPieceAt(board[1][5], BLACK).getPieceType());
		assertEquals(ADVISOR, gamma.getPieceAt(board[1][6], BLACK).getPieceType());
		assertEquals(ELEPHANT, gamma.getPieceAt(board[1][7], BLACK).getPieceType());
		assertEquals(CHARIOT, gamma.getPieceAt(board[1][9], BLACK).getPieceType());
		assertEquals(SOLDIER, gamma.getPieceAt(board[4][1], BLACK).getPieceType());
		assertEquals(SOLDIER, gamma.getPieceAt(board[4][3], BLACK).getPieceType());
		assertEquals(SOLDIER, gamma.getPieceAt(board[4][5], BLACK).getPieceType());
		assertEquals(SOLDIER, gamma.getPieceAt(board[4][7], BLACK).getPieceType());
		assertEquals(SOLDIER, gamma.getPieceAt(board[4][9], BLACK).getPieceType());
	}
	
	@Test
	public void generalMovesOrthogonallyOK(){
		assertEquals(OK, gamma.makeMove(board[1][5], board[2][5]));
		assertEquals(XiangqiPieceType.NONE, gamma.getPieceAt(board[1][5], RED).getPieceType());
		assertEquals(OK, gamma.makeMove(board[1][5], board[2][5]));
		assertEquals(XiangqiPieceType.NONE, gamma.getPieceAt(board[1][5], BLACK).getPieceType());
		assertEquals(OK, gamma.makeMove(board[2][5], board[2][4]));
		assertEquals(XiangqiPieceType.NONE, gamma.getPieceAt(board[2][5], RED).getPieceType());
	}
	
	@Test
	public void generalMovesOutsidePalaceIllegal(){
		gamma.makeMove(board[1][5], board[2][5]);
		gamma.makeMove(board[1][5], board[2][5]);
		gamma.makeMove(board[2][5], board[2][4]);
		assertEquals(ILLEGAL, gamma.makeMove(board[2][4], board[2][3]));
		assertEquals(GENERAL, gamma.getPieceAt(board[2][4], RED).getPieceType());
	}
	
	@Test
	public void elephantMovesDiagonally2OK(){
		assertEquals(OK, gamma.makeMove(board[1][3], board[3][5]));
		assertEquals(XiangqiPieceType.NONE, gamma.getPieceAt(board[1][3], RED).getPieceType());
		assertEquals(OK, gamma.makeMove(board[1][3], board[3][5]));
		assertEquals(XiangqiPieceType.NONE, gamma.getPieceAt(board[1][3], BLACK).getPieceType());
		assertEquals(OK, gamma.makeMove(board[3][5], board[5][3]));
		assertEquals(XiangqiPieceType.NONE, gamma.getPieceAt(board[3][5], RED).getPieceType());
	}
	
	@Test
	public void elephantCrossesRiverIllegal(){
		gamma.makeMove(board[1][3], board[3][5]);
		gamma.makeMove(board[1][3], board[3][5]);
		gamma.makeMove(board[3][5], board[5][3]);
		gamma.makeMove(board[3][5], board[5][3]);
		assertEquals(ILLEGAL, gamma.makeMove(board[5][3], board[7][1]));
		assertEquals(ILLEGAL, gamma.makeMove(board[5][3], board[7][1]));
	}
	
	@Test
	public void soldierMovesAcrossRiverOK(){
		assertEquals(OK, gamma.makeMove(board[4][1], board[5][1]));
		assertEquals(OK, gamma.makeMove(board[4][1], board[5][1]));
		assertEquals(OK, gamma.makeMove(board[5][1], board[6][1]));
		assertEquals(OK, gamma.makeMove(board[5][1], board[6][1]));
	}
	
	@Test
	public void soldierMovesSidewaysAfterCrossingRiverOK(){
		assertEquals(OK, gamma.makeMove(board[4][1], board[5][1]));
		assertEquals(OK, gamma.makeMove(board[4][1], board[5][1]));
		assertEquals(OK, gamma.makeMove(board[5][1], board[6][1]));
		assertEquals(OK, gamma.makeMove(board[5][1], board[6][1]));
		assertEquals(OK, gamma.makeMove(board[6][1], board[6][2]));
	}
	
	@Test
	public void soldierMovesBackwardOrSidewaysBeforeRiverIllegal(){
		assertEquals(ILLEGAL, gamma.makeMove(board[4][1], board[3][1]));
		assertEquals(ILLEGAL, gamma.makeMove(board[4][1], board[4][2]));
	}
	
	@Test
	public void soliderMovesBackwardAfterRiverIllegal(){

		assertEquals(OK, gamma.makeMove(board[4][1], board[5][1]));
		assertEquals(OK, gamma.makeMove(board[4][1], board[5][1]));
		assertEquals(OK, gamma.makeMove(board[5][1], board[6][1]));
		assertEquals(OK, gamma.makeMove(board[5][1], board[6][1]));
		assertEquals(ILLEGAL, gamma.makeMove(board[6][1], board[5][1]));
	}
	
	@Test
	public void advisorMovesDiagonalInPalaceOK(){
		assertEquals(OK, gamma.makeMove(board[1][4], board[2][5]));
		assertEquals(OK, gamma.makeMove(board[1][4], board[2][5]));
		assertEquals(OK, gamma.makeMove(board[2][5], board[3][4]));
		assertEquals(OK, gamma.makeMove(board[2][5], board[3][4]));
		assertEquals(OK, gamma.makeMove(board[3][4], board[2][5]));
	}
	
	public void advisorMovesOutsidePalaceIllegal(){
		assertEquals(OK, gamma.makeMove(board[1][4], board[2][5]));
		assertEquals(OK, gamma.makeMove(board[1][4], board[2][5]));
		assertEquals(OK, gamma.makeMove(board[2][5], board[3][4]));
		assertEquals(OK, gamma.makeMove(board[2][5], board[3][4]));
		assertEquals(ILLEGAL, gamma.makeMove(board[3][4], board[4][5]));
	}
	
	@Test
	public void chariotMovesOrthogonalDistancesOK(){
		assertEquals(OK, gamma.makeMove(board[1][1], board[2][1]));
		assertEquals(OK, gamma.makeMove(board[1][1], board[2][1]));
		assertEquals(OK, gamma.makeMove(board[2][1], board[2][8]));
		assertEquals(OK, gamma.makeMove(board[2][1], board[2][8]));
	}
	
	@Test
	public void chariotCrossesRiverOK(){
		assertEquals(OK, gamma.makeMove(board[1][1], board[1][2]));
		assertEquals(OK, gamma.makeMove(board[1][1], board[1][2]));
		assertEquals(OK, gamma.makeMove(board[1][2], board[6][2]));
		assertEquals(OK, gamma.makeMove(board[1][2], board[6][2]));
	}
	
	@Test
	public void illegalMoveMessageOnInvalidCoords(){
		assertEquals(ILLEGAL, gamma.makeMove(board[0][0], board[0][8]));
		assertTrue(gamma.getMoveMessage().length() > 5);
	}
}

