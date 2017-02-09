package xiangqi.student_ejharding.alpha;
import org.junit.Test;

import xiangqi.XiangqiGameFactory;
import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.student_ejharding.TestCoordinate;

import static org.junit.Assert.*;

import org.junit.Before;

public class TestXiangqiAlpha {
	
	private XiangqiGame game;
	
	@Before
	public void setup(){
		game = XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.ALPHA_XQ);
	}
 
	@Test
	public void testFactoryMakesAlphaXiangqi(){
		assertNotNull(game);
	}
		
	@Test
	public void testRedFirstMoveIsValid(){
		assertEquals(MoveResult.OK, game.makeMove(TestCoordinate.make(1, 1), TestCoordinate.make(1,2)));
	}
	@Test
	public void testBlackSecondMoveRedWins(){
		game.makeMove(TestCoordinate.make(1, 1), TestCoordinate.make(1,2));
		assertEquals(MoveResult.RED_WINS, game.makeMove(TestCoordinate.make(1, 1), TestCoordinate.make(1, 2)));
	}
	
	@Test
	public void testIllegalMoveToInvalidLocation(){
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TestCoordinate.make(1, 1), TestCoordinate.make(2, 2)));
	}
	
	@Test
	public void testIllegalMoveFromInvalidLocation(){
		assertEquals(MoveResult.ILLEGAL, game.makeMove(TestCoordinate.make(4,3), TestCoordinate.make(3,3)));
	}
	
	@Test
	public void testGetPieceAtReturnsNoneTypeColor(){
		XiangqiPiece dummy = game.getPieceAt(TestCoordinate.make(1,1), XiangqiColor.RED);
		assertEquals(XiangqiPieceType.NONE, dummy.getPieceType());
		assertEquals(XiangqiColor.NONE, dummy.getColor());
	}
	
}
