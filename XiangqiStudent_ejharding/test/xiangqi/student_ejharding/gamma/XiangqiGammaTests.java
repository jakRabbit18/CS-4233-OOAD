package xiangqi.student_ejharding.gamma;

import static xiangqi.common.XiangqiColor.*;
import static xiangqi.common.XiangqiPieceType.*;
import static org.junit.Assert.*;
import static xiangqi.common.MoveResult.*;
import org.junit.*;
import xiangqi.XiangqiGameFactory;
import xiangqi.common.*;
import xiangqi.student_ejharding.TestCoordinate;
import xiangqi.student_ejharding.XiangqiGameImpl;

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
	
	@Test
	public void advisorMovesOutsidePalaceIllegal(){
		assertEquals(OK, gamma.makeMove(board[1][4], board[2][5]));
		assertEquals(OK, gamma.makeMove(board[1][4], board[2][5]));
		assertEquals(OK, gamma.makeMove(board[2][5], board[3][4]));
		assertEquals(OK, gamma.makeMove(board[2][5], board[3][4]));
		assertEquals(ILLEGAL, gamma.makeMove(board[3][4], board[4][5]));
		assertEquals(ILLEGAL, gamma.makeMove(board[3][4], board[2][3]));
		assertEquals(ILLEGAL, gamma.makeMove(board[3][4], board[4][3]));
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
	public void chariotJumpingOverPiecesIllegal(){
		gamma.makeMove(board[1][9], board[2][9]);
		dbmove1();
		assertEquals(ILLEGAL, gamma.makeMove(board[1][1], board[1][9]));
		assertEquals(ILLEGAL, gamma.makeMove(board[1][9], board[1][1]));
		
	}
	
	@Test
	public void illegalMoveMessageOnInvalidCoords(){
		assertEquals(ILLEGAL, gamma.makeMove(board[0][0], board[0][8]));
		assertTrue(gamma.getMoveMessage().length() > 5);
	}
	
	@Test
	public void moveLimitYieldsDraw(){
		for(int i = 0; i < 12; i++){
			gamma.makeMove(board[1][1], board[2][1]);
			dbmove1();
			gamma.makeMove(board[2][1], board[1][1]);
			dbmove2();
		}
		assertEquals(OK, gamma.makeMove(board[1][1], board[2][1]));
		assertEquals(DRAW, gamma.makeMove(board[1][5], board[2][5]));
	}
	
	@Test
	public void mustMoveGeneralOutOfCheck(){
		System.out.println("Moveing General out of check test");
		gamma.makeMove(board[4][1], board[5][1]);
		gamma.makeMove(board[4][9], board[5][9]);
		gamma.makeMove(board[1][1], board[4][1]);
		//bS takes rS
		gamma.makeMove(board[5][9], board[6][9]);
		//rR takes bS
		gamma.makeMove(board[4][1], board[5][1]);
		//dummy black move
		dbmove1();
		gamma.makeMove(board[5][1], board[7][1]);
		dbmove2();
		gamma.makeMove(board[7][1], board[7][3]);
		dbmove1();
		//put black general in check
		gamma.makeMove(board[7][3], board[7][5]);
		//now is illegal to make dummy move
		assertEquals(ILLEGAL, gamma.makeMove(board[2][1],  board[1][1]));
		//black is allowed to block check
		assertEquals(OK, gamma.makeMove(board[1][4], board[2][5]));		
	}
	
	private void dbmove1(){
		gamma.makeMove(board[1][1], board[2][1]);
	}
	
	private void dbmove2(){
		gamma.makeMove(board[2][1], board[1][1]);
	}
	
	@Test
	public void generalCantEscapeCheck_Checkmate(){ 
		System.out.println("Starting checkmate by threat test!");
		gamma.makeMove(board[4][1], board[5][1]); //red soldier
		gamma.makeMove(board[4][9], board[5][9]); //black soldier
		gamma.makeMove(board[1][1], board[3][1]); //red chariot
		gamma.makeMove(board[5][9], board[6][9]); //black soldier takes red soldier
		gamma.makeMove(board[3][1], board[5][1]); //red chariot takes black soldier
		dbmove1();
		gamma.makeMove(board[5][1], board[7][1]); //red chariot
		dbmove2();
		gamma.makeMove(board[7][1], board[7][3]); //red chariot takes black soldier
		gamma.makeMove(board[1][9], board[3][9]); //get black chariot out of the way
		gamma.makeMove(board[1][9], board[3][9]); //advance other red chariot
		gamma.makeMove(board[1][6], board[2][5]); //start getting black advisor out of the way
		gamma.makeMove(board[3][9], board[3][4]); //move the red chariot into position
		gamma.makeMove(board[2][5], board[3][4]); //finish moving the black advisor out of the way
		gamma.makeMove(board[3][4], board[9][4]); //final red chariot position
		dbmove1(); //dummy move for black chariot
		assertEquals(RED_WINS, gamma.makeMove(board[7][3], board[10][3])); //checkmate for red
	}
	
	@Test
	public void generalUnthreatenedCheckmate(){ 
		
	}
}

