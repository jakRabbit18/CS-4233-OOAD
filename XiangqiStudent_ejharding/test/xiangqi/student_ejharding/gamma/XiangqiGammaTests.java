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
		assertEquals(OK, gamma.makeMove(board[1][5], board[2][5]));
		assertEquals(OK, gamma.makeMove(board[2][5], board[2][4]));
	}
}
