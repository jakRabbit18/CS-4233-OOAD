package xiangqi.student_ejharding;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Before;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;

public class BoardTests {
	
	Board board;
	
	@Before
	public void setup(){
		board = new Board(5,5);
	}
	
	@Test
	public void testLocationsContainNoneTypePieces(){
		for(int rank = 1; rank <= 5; rank++){
			for(int file = 1; file <= 5; file++){
				assertEquals(XiangqiPieceType.NONE, board.getPieceAt(TestCoordinate.make(rank, file)).getPieceType());
			}
		}
	}
	
//	@Test
//	public void testRemovePieceLeavesNoneTypeBehind(){
//		
//	}
//	
//	@Test
//	public void testGetPieceAtReturnsCorrectPiece(){
//		
//	}
	
	@Test
	public void testPlacePiecePutsPieceInCorrectLocation(){
		XiangqiPiece redGeneral = new XiangqiPieceImpl(XiangqiPieceType.GENERAL, XiangqiColor.RED);
		assertTrue(board.placePieceAt(redGeneral, TestCoordinate.make(1, 1)));
		assertEquals(redGeneral, board.board[0][0].piece); //getPieceAt(TestCoordinate.make(1, 1)));
	}
	
	@Test
	public void getPieceAtReturnsNoneOnInvalidLocation(){
		
	}
	
}
