package xiangqi.student_ejharding;

import xiangqi.common.XiangqiCoordinate;

public class CXiangqiCoord implements XiangqiCoordinate {

	private int rank, file;
	
	public CXiangqiCoord(int rank, int file){
		this.rank = rank;
		this.file = file;
	}
	
	public static XiangqiCoordinate convertToRed(XiangqiCoordinate black, int ranks, int files){
		int bRank = black.getRank();
		int bFile = black.getFile();
		return new CXiangqiCoord(ranks - bRank + 1, files - bFile +1);
	}
	
	@Override
	public int getRank() {
		return rank;
	}

	@Override
	public int getFile() {
		return file;
	}

}
