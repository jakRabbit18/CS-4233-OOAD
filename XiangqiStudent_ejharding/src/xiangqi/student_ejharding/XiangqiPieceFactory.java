package xiangqi.student_ejharding;

import static xiangqi.common.XiangqiColor.*;
import static xiangqi.common.XiangqiPieceType.*;

public class XiangqiPieceFactory {
	
	/*Red pieces **************************************/
	public static XiangqiPieceImpl makeRedGeneral(){
		return new XiangqiPieceImpl(GENERAL, RED);
	}
	
	public static XiangqiPieceImpl makeRedChariot(){
		return new XiangqiPieceImpl(CHARIOT, RED);
	}
	
	public static XiangqiPieceImpl makeRedElephant(){
		return new XiangqiPieceImpl(ELEPHANT, RED);
	}
	
	public static XiangqiPieceImpl makeRedAdvisor(){
		return new XiangqiPieceImpl(ADVISOR, RED);
	}
	
	public static XiangqiPieceImpl makeRedSoldier(){
		return new XiangqiPieceImpl(SOLDIER, RED);
	}
	
	/* Black pieces ************************************/
	public static XiangqiPieceImpl makeBlackGeneral(){
		return new XiangqiPieceImpl(GENERAL, BLACK);
	}
	
	public static XiangqiPieceImpl makeBlackChariot(){
		return new XiangqiPieceImpl(CHARIOT, BLACK);
	}
	
	public static XiangqiPieceImpl makeBlackElephant(){
		return new XiangqiPieceImpl(ELEPHANT, BLACK);
	}
	
	public static XiangqiPieceImpl makeBlackAdvisor(){
		return new XiangqiPieceImpl(ADVISOR, BLACK);
	}
	
	public static XiangqiPieceImpl makeBlackSoldier(){
		return new XiangqiPieceImpl(SOLDIER, BLACK);
	}
}
