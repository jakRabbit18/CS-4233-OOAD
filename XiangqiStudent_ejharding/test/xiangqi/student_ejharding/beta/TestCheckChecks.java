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
public class TestCheckChecks {

	private XiangqiGame game;
	
	@Before
	public void setup(){
		game = XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.BETA_XQ);
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
}
