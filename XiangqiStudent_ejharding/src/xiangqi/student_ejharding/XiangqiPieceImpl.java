package xiangqi.student_ejharding;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;

public class XiangqiPieceImpl implements XiangqiPiece {

	
	private XiangqiPieceType type;
	private XiangqiColor color;

	public XiangqiPieceImpl(XiangqiPieceType type, XiangqiColor color){
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
		if(!(other instanceof XiangqiPieceImpl)){
			return false;
		}
		XiangqiPieceImpl toCheck = (XiangqiPieceImpl) other;
		
		if(toCheck.getColor().equals(this.color) && toCheck.getPieceType().equals(this.type)){
			return true;
		} else {
			return false;
		}
	}

}
