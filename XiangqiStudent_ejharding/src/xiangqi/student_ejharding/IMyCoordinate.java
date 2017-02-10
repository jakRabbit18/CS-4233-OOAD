package xiangqi.student_ejharding;

import xiangqi.common.XiangqiCoordinate;

public interface IMyCoordinate extends XiangqiCoordinate {

	public boolean isHorizontal(IMyCoordinate other);
	
	public boolean isVertical(IMyCoordinate other);
	
	public boolean isDiagonal(IMyCoordinate other);
	
	public boolean clearStraightPathTo(IMyCoordinate other);
	
	public boolean isForwardto(IMyCoordinate other);
	
	public boolean isInPalace();
	
	public int orthogonalDistnanceTo(IMyCoordinate other);
	
	public int diagonalDistanceTo(IMyCoordinate other);

}
