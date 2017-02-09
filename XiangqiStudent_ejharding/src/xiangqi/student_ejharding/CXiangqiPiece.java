package xiangqi.student_ejharding;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;

public class CXiangqiPiece implements XiangqiPiece {

	
	private XiangqiPieceType type;
	private XiangqiColor color;

	public CXiangqiPiece(XiangqiPieceType type, XiangqiColor color){
		this.type = type;
		this.color = color;
	}
	
	@Override
	public XiangqiColor getColor() {
		return color;
	}

	@Override
	public XiangqiPieceType getPieceType() {
		return type;
	}
	
	public boolean equals(Object other){
		if(!(other instanceof CXiangqiPiece)){
			return false;
		}
		CXiangqiPiece toCheck = (CXiangqiPiece) other;
		
		if(toCheck.getColor().equals(this.color) && toCheck.getPieceType().equals(this.type)){
			return true;
		} else {
			return false;
		}
	}

}
