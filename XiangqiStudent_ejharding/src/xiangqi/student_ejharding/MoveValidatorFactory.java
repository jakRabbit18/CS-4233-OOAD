package xiangqi.student_ejharding;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;

import xiangqi.common.XiangqiPieceType;

public class MoveValidatorFactory {

	static BiPredicate<IMyCoordinate, IMyCoordinate> horizontalValidator = 
			(IMyCoordinate c1, IMyCoordinate c2) -> c1.isHorizontal(c2);
	static BiPredicate<IMyCoordinate, IMyCoordinate> verticalValidator = 
			(IMyCoordinate c1, IMyCoordinate c2) -> c1.isVertical(c2);
	private static BiPredicate<IMyCoordinate, IMyCoordinate> soldierForwardValidator =
			(IMyCoordinate c1, IMyCoordinate c2) -> c1.isNotBackwards(c2);
	private static BiPredicate<IMyCoordinate, IMyCoordinate> diagonalValidator = 
			(IMyCoordinate c1, IMyCoordinate c2) -> c1.isDiagonal(c2);
	static BiPredicate<IMyCoordinate, IMyCoordinate> orthogonalValidator = 
			(IMyCoordinate c1, IMyCoordinate c2) -> c1.isHorizontal(c2) || c1.isVertical(c2);
	private static BiPredicate<IMyCoordinate, IMyCoordinate> clearStraightPathValidator = 
			(IMyCoordinate c1, IMyCoordinate c2) -> c1.clearStraightPathTo(c2);
	private static BiPredicate<IMyCoordinate, IMyCoordinate> diagonalDistanceValidator1 = 
			((IMyCoordinate c1, IMyCoordinate c2) -> c1.diagonalDistanceTo(c2) == 1);
	private static BiPredicate<IMyCoordinate, IMyCoordinate> diagonalDistanceValidator2 = 
			(IMyCoordinate c1, IMyCoordinate c2) -> c1.diagonalDistanceTo(c2) == 2;
	private static BiPredicate<IMyCoordinate, IMyCoordinate> orthogonalDistanceValidator = 
			(IMyCoordinate c1, IMyCoordinate c2) -> c1.orthogonalDistnanceTo(c2) == 1;
	private static BiPredicate<IMyCoordinate, IMyCoordinate> inCheckValidator = 
			(IMyCoordinate c1, IMyCoordinate c2) -> true;
	private static BiPredicate<IMyCoordinate, IMyCoordinate> clearHorsePathValidator =
			(IMyCoordinate c1, IMyCoordinate c2) ->true;
	private static BiPredicate<IMyCoordinate, IMyCoordinate> staysInPalaceValidator =
			(IMyCoordinate c1, IMyCoordinate c2) -> c2.isInPalace();
			
	/**
	 * given a piece type, will determine which validators must be used to determine how that piece can move.
	 * @param pieceType : the type of piece to be moved
	 * @return list of lambda expressions that dictate the movement of the piece.
	 */
	public static List<BiPredicate<IMyCoordinate, IMyCoordinate>> getValidators(XiangqiPieceType pieceType){
		
		List<BiPredicate<IMyCoordinate, IMyCoordinate>> validators = new LinkedList<BiPredicate<IMyCoordinate, IMyCoordinate>>();
		switch(pieceType){
		case CHARIOT: 
			validators.add(orthogonalValidator);
			validators.add(clearStraightPathValidator);
			break;
		case ADVISOR:
			validators.add(diagonalValidator);
			validators.add(diagonalDistanceValidator1);
			validators.add(clearStraightPathValidator);
			break;
		case GENERAL:
			validators.add(orthogonalValidator);
			validators.add(orthogonalDistanceValidator);
			validators.add(inCheckValidator);
			validators.add(staysInPalaceValidator);
			break;
		case SOLDIER:
			validators.add(verticalValidator);
			validators.add(orthogonalDistanceValidator);
			validators.add(soldierForwardValidator);
			break;
		case ELEPHANT:
			validators.add(diagonalValidator);
			validators.add(diagonalDistanceValidator2);
			validators.add(clearStraightPathValidator);
			break;
		case NONE: break;
		default: 
			System.out.println("Unrecognized Type"); break;
		
		}
		return validators;
	}
			
}
