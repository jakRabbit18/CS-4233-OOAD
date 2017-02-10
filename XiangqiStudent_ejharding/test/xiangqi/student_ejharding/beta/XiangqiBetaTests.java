package xiangqi.student_ejharding.beta;

import org.junit.Test;

import xiangqi.XiangqiGameFactory;
import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiColor.*;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.student_ejharding.TestCoordinate;

import static org.junit.Assert.*;

import org.junit.Before;

public class XiangqiBetaTests { 

	private XiangqiGame game;

	@Before
	public void setup(){
		game = XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.BETA_XQ);
	}
	@Test
	public void testMakeBetaReturnsValidGame(){
		assertNotNull(game);
	}

	@Test
	public void getPieceAtReturnsCorrectPieces(){
		//get black chariot, advisor, soldier, general
		XiangqiPiece blackChariot = game.getPieceAt(TestCoordinate.make(1, 1), XiangqiColor.BLACK);
		XiangqiPiece blackAdvisor = game.getPieceAt(TestCoordinate.make(1, 2), XiangqiColor.BLACK);
		XiangqiPiece blackSoldier = game.getPieceAt(TestCoordinate.make(2, 3), XiangqiColor.BLACK);
		XiangqiPiece blackGeneral = game.getPieceAt(TestCoordinate.make(1, 3), XiangqiColor.BLACK);

		//get red chariot, advisor, soldier, general
		XiangqiPiece redChariot = game.getPieceAt(TestCoordinate.make(1, 1), XiangqiColor.RED);
		XiangqiPiece redAdvisor = game.getPieceAt(TestCoordinate.make(1, 2), XiangqiColor.RED);
		XiangqiPiece redSoldier = game.getPieceAt(TestCoordinate.make(2, 3), XiangqiColor.RED);
		XiangqiPiece redGeneral = game.getPieceAt(TestCoordinate.make(1, 3), XiangqiColor.RED);
		XiangqiPiece nonePiece = game.getPieceAt(TestCoordinate.make(3, 3), XiangqiColor.RED);


		//check all types and colors
		assertEquals(XiangqiPieceType.CHARIOT, blackChariot.getPieceType()); 
		assertEquals(XiangqiPieceType.ADVISOR, blackAdvisor.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER, blackSoldier.getPieceType());
		assertEquals(XiangqiPieceType.GENERAL, blackGeneral.getPieceType());

		assertEquals(XiangqiPieceType.CHARIOT, redChariot.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR, redAdvisor.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER, redSoldier.getPieceType());
		assertEquals(XiangqiPieceType.GENERAL, redGeneral.getPieceType());

		assertEquals(XiangqiColor.BLACK, blackChariot.getColor());
		assertEquals(XiangqiColor.BLACK, blackAdvisor.getColor());
		assertEquals(XiangqiColor.BLACK, blackSoldier.getColor());
		assertEquals(XiangqiColor.BLACK, blackGeneral.getColor());

		assertEquals(XiangqiColor.RED, redChariot.getColor());
		assertEquals(XiangqiColor.RED, redAdvisor.getColor());
		assertEquals(XiangqiColor.RED, redSoldier.getColor());
		assertEquals(XiangqiColor.RED, redGeneral.getColor());

		assertEquals(XiangqiPieceType.NONE, nonePiece.getPieceType());
		assertEquals(XiangqiColor.NONE, nonePiece.getColor());

	}

	@Test
	public void getPieceAtInvalidLocationReturnsNoneType(){
		XiangqiCoordinate invalid = TestCoordinate.make(20, 20);
		XiangqiPiece nonePiece = game.getPieceAt(invalid, XiangqiColor.RED);
		assertEquals(XiangqiColor.NONE, nonePiece.getColor());
		assertEquals(XiangqiPieceType.NONE, nonePiece.getPieceType());
	}
	
	@Test
	public void moveFromEmptyLocationIllegal(){
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TestCoordinate.make(3, 3), TestCoordinate.make(1, 1)));
	}
	
	@Test
	public void testLocationsOffTheBoardMeanIllegal(){
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TestCoordinate.make(10,10), TestCoordinate.make(1, 1)));
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TestCoordinate.make(1,1 ), TestCoordinate.make(10, 10)));
	}

	@Test
	public void testValidChariotMovesVerticalOK(){
		assertEquals(MoveResult.OK, game.makeMove(TestCoordinate.make(1, 1), TestCoordinate.make(3, 1)));
		assertEquals(XiangqiPieceType.NONE, game.getPieceAt(TestCoordinate.make(1,1), XiangqiColor.RED).getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT, game.getPieceAt(TestCoordinate.make(3, 1), XiangqiColor.RED).getPieceType());
		//		assertEquals(MoveResult.OK, game.makeMove(TestCoordinate.make(3, 1), TestCoordinate.make(3, 3)));
		//		assertEquals(XiangqiPieceType.NONE, game.getPieceAt(TestCoordinate.make(3, 1), XiangqiColor.RED).getPieceType());
		//		assertEquals(XiangqiPieceType.CHARIOT, game.getPieceAt(TestCoordinate.make(3, 3), XiangqiColor.RED).getPieceType());
	}

	@Test
	public void testChariotMovesHorizontalOK(){
		//move red chariotb to open space
		game.makeMove(TestCoordinate.make(1, 5), TestCoordinate.make(3, 5));
		//black moves...
		assertEquals(MoveResult.OK, game.makeMove(TestCoordinate.make(1, 5), TestCoordinate.make(2, 5)));
		assertEquals(MoveResult.OK, game.makeMove(TestCoordinate.make(3, 5), TestCoordinate.make(1, 5)));
	}

	@Test
	public void testChariotCapturesPieceOK(){
		//move red chariotb to open space
		game.makeMove(TestCoordinate.make(1, 5), TestCoordinate.make(3, 5));
		//black moves...
		game.makeMove(TestCoordinate.make(1, 1), TestCoordinate.make(2, 1));
		//red chariot takes black chariot
		assertEquals(MoveResult.OK, game.makeMove(TestCoordinate.make(3, 5), TestCoordinate.make(4, 5)));
		assertEquals(XiangqiPieceType.CHARIOT, game.getPieceAt(TestCoordinate.make(4, 5), XiangqiColor.RED).getPieceType());
		assertEquals(XiangqiColor.RED, game.getPieceAt(TestCoordinate.make(4, 5), XiangqiColor.RED).getColor());
	}

	@Test
	public void testChariotMovesOntoItselfIllegal(){
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TestCoordinate.make(1, 1), TestCoordinate.make(1, 1)));
		assertEquals(XiangqiPieceType.CHARIOT, game.getPieceAt(TestCoordinate.make(1, 1), XiangqiColor.RED).getPieceType());
	}

	@Test
	public void testChariotMoveOverOtherPieceIllegal(){
		//move red chariotb to open space
		game.makeMove(TestCoordinate.make(1, 5), TestCoordinate.make(2, 5));
		//black moves...
		game.makeMove(TestCoordinate.make(1, 5), TestCoordinate.make(2, 5));
		//now make sure the red chariot cannot jump along the back row
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TestCoordinate.make(1, 1), TestCoordinate.make(1, 5)));
		assertEquals(XiangqiPieceType.CHARIOT, game.getPieceAt(TestCoordinate.make(1, 1), XiangqiColor.RED).getPieceType());
	}

	@Test
	public void testChariotMovesOntoOwnColorIllegal(){
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TestCoordinate.make(1, 1), TestCoordinate.make(1, 2)));
		assertEquals(XiangqiPieceType.CHARIOT, game.getPieceAt(TestCoordinate.make(1, 1), XiangqiColor.RED).getPieceType());
	}
	
	@Test
	public void testChariotMovesDiagonallyIllegal(){
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TestCoordinate.make(1, 1), TestCoordinate.make(3, 3)));
	}

	@Test
	public void testValidAdvisorMovesOK(){
		assertEquals(MoveResult.OK, game.makeMove(TestCoordinate.make(1, 2), TestCoordinate.make(2, 1)));
		assertEquals(XiangqiPieceType.NONE, game.getPieceAt(TestCoordinate.make(1,2), XiangqiColor.RED).getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR, game.getPieceAt(TestCoordinate.make(2,1), XiangqiColor.RED).getPieceType());
		//		assertEquals(MoveResult.OK, game.makeMove(TestCoordinate.make(2, 1), TestCoordinate.make(3, 2)));
		//		assertEquals(XiangqiPieceType.NONE, game.getPieceAt(TestCoordinate.make(2, 1), XiangqiColor.RED).getPieceType());
		//		assertEquals(XiangqiPieceType.ADVISOR, game.getPieceAt(TestCoordinate.make(3, 2), XiangqiColor.RED).getPieceType());
	}

	@Test
	public void testSoldierMovesForwardOneOk(){
		assertEquals(MoveResult.OK, game.makeMove(TestCoordinate.make(2, 3),  TestCoordinate.make(3, 3)));
		assertEquals(XiangqiPieceType.SOLDIER, game.getPieceAt(TestCoordinate.make(3, 3), XiangqiColor.RED).getPieceType());
		//move black soldier
		assertEquals(MoveResult.OK, game.makeMove(TestCoordinate.make(2, 3),  TestCoordinate.make(3, 3)));
		assertEquals(XiangqiPieceType.SOLDIER, game.getPieceAt(TestCoordinate.make(3, 3), XiangqiColor.BLACK).getPieceType());
	}
	
	@Test
	public void testSoldierMovesSidewaysIllegal(){
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TestCoordinate.make(2, 3),  TestCoordinate.make(2, 2)));
	}
	
	@Test
	public void testSoldierMovesBackwardsIllegal(){
		assertEquals(MoveResult.OK, game.makeMove(TestCoordinate.make(2, 3),  TestCoordinate.make(3, 3)));
		assertEquals(XiangqiPieceType.SOLDIER, game.getPieceAt(TestCoordinate.make(3, 3), XiangqiColor.RED).getPieceType());
		assertEquals(MoveResult.OK, game.makeMove(TestCoordinate.make(1,1),  TestCoordinate.make(2,1)));
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TestCoordinate.make(3, 3),  TestCoordinate.make(2, 3)));
		assertEquals(XiangqiPieceType.SOLDIER, game.getPieceAt(TestCoordinate.make(3, 3), XiangqiColor.RED).getPieceType());
	}
	
	
	@Test
	public void testValidGeneralMovesReturnsOK(){
		//move red advisor
		game.makeMove(TestCoordinate.make(1, 2), TestCoordinate.make(2, 1));
		//move black advisor
		game.makeMove(TestCoordinate.make(1, 2), TestCoordinate.make(2, 1));
		//move red general
		assertEquals(MoveResult.OK, game.makeMove(TestCoordinate.make(1, 3), TestCoordinate.make(1,2)));
		assertEquals(XiangqiPieceType.NONE, game.getPieceAt(TestCoordinate.make(1,3), XiangqiColor.RED).getPieceType());
		assertEquals(XiangqiPieceType.GENERAL, game.getPieceAt(TestCoordinate.make(1,2), XiangqiColor.RED).getPieceType());

	}

	@Test
	public void testMovingGeneralOutOfPalaceReturnsIllegal(){
		//move red chariot
		game.makeMove(TestCoordinate.make(1, 1), TestCoordinate.make(3, 1));
		//move black advisor
		assertEquals(MoveResult.OK,game.makeMove(TestCoordinate.make(1, 2), TestCoordinate.make(2, 1)));
		//move red advisor
		assertEquals(MoveResult.OK,game.makeMove(TestCoordinate.make(1, 2), TestCoordinate.make(2, 1)));
		//move black advisor
		assertEquals(MoveResult.OK,game.makeMove(TestCoordinate.make(2, 1), TestCoordinate.make(1, 2)));
		//move red general 1 space
		assertEquals(MoveResult.OK,game.makeMove(TestCoordinate.make(1, 3), TestCoordinate.make(1,2)));
		//move black advisor
		assertEquals(MoveResult.OK,game.makeMove(TestCoordinate.make(1, 2), TestCoordinate.make(2, 1)));
		//attempt to move the general out of the palace
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TestCoordinate.make(1, 2), TestCoordinate.make(1,1)));
		assertEquals(XiangqiPieceType.GENERAL, game.getPieceAt(TestCoordinate.make(1,2), XiangqiColor.RED).getPieceType());
	}
		
	@Test
	public void testGeneralInCheckMustBeOutOfCheckAtEndOfMove(){
		//move red chariot
		game.makeMove(TestCoordinate.make(1, 1), TestCoordinate.make(4, 1));
		//move black chariot
		game.makeMove(TestCoordinate.make(1, 1), TestCoordinate.make(4, 1));
		//put black general in check
		game.makeMove(TestCoordinate.make(4, 1), TestCoordinate.make(4, 3));
		//try to move a piece that does not take the general out of check but is otherwise legal
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TestCoordinate.make(4, 1), TestCoordinate.make(4, 3)));
		assertEquals(MoveResult.OK, game.makeMove(TestCoordinate.make(1,2), TestCoordinate.make(2,3)));
		
	}
	//	@Test
	//	public void testCheckmateConditions(){
	//		
	//	}
}
