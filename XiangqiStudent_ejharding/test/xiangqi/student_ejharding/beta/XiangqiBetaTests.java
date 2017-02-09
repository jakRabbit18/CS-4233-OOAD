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
		
	}
	
	@Test
	public void getPieceAtInvalidLocationReturnsNoneType(){
		XiangqiCoordinate invalid = TestCoordinate.make(20, 20);
		XiangqiPiece nonePiece = game.getPieceAt(invalid, XiangqiColor.RED);
		assertEquals(XiangqiColor.NONE, nonePiece.getColor());
		assertEquals(XiangqiPieceType.NONE, nonePiece.getPieceType());
	}
	
//	@Test
//	public void testValidChariotMovesReturnsOK(){
//		
//	}
//	
//	@Test
//	public void testInvalidChariotMovesReturnsIllegal(){
//		
//	}
//	
//	@Test
//	public void testValidAdvisorMovesReturnsOK(){
//		
//	}
//	
//	@Test
//	public void testInvalidAdvisorMovesReturnsIllegal(){
//		
//	}
//	
//	@Test
//	public void testValidGeneralMovesReturnsOK(){
//		
//	}
//	
//	@Test
//	public void testInvalidGeneralMovesReturnsIllegal(){
//		
//	}
//	
//		
//	@Test
//	public void testCheckmateConditions(){
//		
//	}
}
