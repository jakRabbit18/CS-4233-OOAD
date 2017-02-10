package xiangqi.student_ejharding;

import xiangqi.common.XiangqiCoordinate;

public interface IMyCoordinate extends XiangqiCoordinate {

	/**
	 * returns if the given coordinate is located horizontally from this one
	 * @param other : the coordinate to check
	 * @return true if the other coordinate is horizontally located, false otherwise
	 */
	public boolean isHorizontal(IMyCoordinate other);
	
	/**
	 * returns if the given coordinate is located vertically from this one
	 * @param other : the coordinate to check
	 * @return true if the other coordinate is vertically located, false otherwise
	 */
	public boolean isVertical(IMyCoordinate other);
	
	/**
	 * returns if the given coordinate is located diagonally from this one
	 * @param other : the coordinate to check
	 * @return true if the other coordinate is diagonally located, false otherwise
	 */
	public boolean isDiagonal(IMyCoordinate other);
	
	/**
	 * returns the status of the path from this coordinate to the other
	 * @param other : the coordinate at the other end of the potential path
	 * @return true if there are no pieces between this coordinate and the other coordinate, 
	 * 			false otherwise
	 */
	public boolean clearStraightPathTo(IMyCoordinate other);
	
	/**
	 * determines if the piece will be moving "forward" (towards the opponent's side of the board)
	 * @param other : the coordinate the piece will move toward
	 * @return true if the other coordinate is closer to the opponent's side of the board than this one
	 */
	public boolean isForwardto(IMyCoordinate other);
	
	/**
	 * determines if this coordinate is located in the palace
	 * @return true if this coordinate is a part of the palace, false otherwise
	 */
	public boolean isInPalace();
	
	/**
	 * returns the distance (orthogonally) between this coordinate and the other
	 * @param other: the coordinate to measure to
	 * @return integer value representing the number of grid lines in range (here, other]
	 */
	public int orthogonalDistnanceTo(IMyCoordinate other);
	
	/**
	 * returns the distance (diagonally) between this coordinate and the other. 
	 * if there is no exact diagonal, returns -1
	 * @param other: the coordinate to measure to
	 * @return integer value representing the number of grid intersections in range (here, other]
	 */
	public int diagonalDistanceTo(IMyCoordinate other);

}
