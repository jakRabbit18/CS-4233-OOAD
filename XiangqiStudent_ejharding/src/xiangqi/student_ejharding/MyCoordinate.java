package xiangqi.student_ejharding;

import java.util.LinkedList;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPieceType;

public class MyCoordinate implements IMyCoordinate {

	private int rank, file;
	Board board;

	public static MyCoordinate copyCoordinate(XiangqiCoordinate loc, Board b){
		return new MyCoordinate(loc.getRank(), loc.getFile(), b);
	}

	public MyCoordinate(int rank, int file, Board b){
		this.rank = rank;
		this.file = file;
		this.board = b;
	}


	public static XiangqiCoordinate convertToRedAspect(MyCoordinate black, int ranks, int files){
		int bRank = black.getRank();
		int bFile = black.getFile();
		return new MyCoordinate(ranks - bRank + 1, files - bFile +1, black.board);
	}

	public Board getBoard() {
		return board;
	}

	@Override
	public int getRank() {
		return rank;
	}

	@Override
	public int getFile() {
		return file;
	}

	@Override
	public boolean clearStraightPathTo(IMyCoordinate other) {
		if(!board.isValidLocation(other) || !board.isValidLocation(this)){
			return false;
		}
		LinkedList<IMyCoordinate> intermediates = new LinkedList<IMyCoordinate>();
		if(isHorizontal(other)){
			for(int f = this.file+1; f < other.getFile(); f++){
				intermediates.add(new MyCoordinate(this.rank, f, board));
			}
		}
		if(isDiagonal(other)){
			int f = this.file+1;
			int r = this.rank+1;
			while(r <=other.getRank() && f < other.getFile()){
				intermediates.add(new MyCoordinate(r, f, board));
				r++;
				f++;
			}
		}
		if(isVertical(other)){
			for(int r = this.rank + 1; r < other.getRank(); r++){
				intermediates.add(new MyCoordinate(r, this.file, board));
			}
		}

		for(IMyCoordinate c: intermediates){
			if(board.getPieceAt(c).getPieceType() != XiangqiPieceType.NONE){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isHorizontal(IMyCoordinate other) {		
		return rank - other.getRank() == 0 && file - other.getFile() != 0;
	}

	@Override
	public boolean isVertical(IMyCoordinate other){
		return rank - other.getRank() != 0 && file - other.getFile() ==0;
	}

	@Override
	public boolean isDiagonal(IMyCoordinate other) {
		return Math.abs(rank - other.getRank()) == Math.abs(file - other.getFile()) && other.getRank() - rank != 0;
	}

	@Override
	public int orthogonalDistnanceTo(IMyCoordinate other) {
		if(this.isHorizontal(other))
			return Math.abs(file - other.getFile());
		else
			return Math.abs(rank - other.getRank());
	}

	@Override
	public int diagonalDistanceTo(IMyCoordinate other) {
		int rankDelta = Math.abs(this.rank - other.getRank());
		int fileDelta = Math.abs(this.file - other.getFile());
		if(rankDelta == fileDelta){
			return rankDelta;
		} else return -1;
	}

	@Override
	public boolean isInPalace() {
		if(this.file > 4 || this.file < 2 || this.rank > 1){
			return false;
		}
		return true;
	}

	@Override
	public boolean isForwardto(IMyCoordinate other) {
		if(board.getPieceAt(this).getColor() == XiangqiColor.RED){
			return this.isBelow(other);
		} else if(board.getPieceAt(this).getColor() ==XiangqiColor.BLACK){
			return this.isAbove(other);
		}
		return false;
	}

	private boolean isAbove(IMyCoordinate other) {
		return this.rank > other.getRank();
	}

	private boolean isBelow(IMyCoordinate other) {
		return this.rank < other.getRank();
	}

}