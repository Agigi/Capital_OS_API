import java.util.Arrays;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;


public class FOnNotifyQuote implements StdCallCallback{
	final SKOSQuoteLib skquotelib = (SKOSQuoteLib) Native.loadLibrary(
			"SKOSQuoteLib", SKOSQuoteLib.class);
	public void callback(short sStockidx) {
		int Status;
		//int ini = skquotelib.SKOSQuoteLib_GetStockByIndex_CallBack(sStockidx);
		
		SKOSQuoteLib.FOREIGN tforegin = new SKOSQuoteLib.FOREIGN();
		Status = skquotelib.SKOSQuoteLib_GetStockByIndex(sStockidx, tforegin);
		if (Status == 0) {
			String[] str = translation(tforegin);
			System.out.println(Arrays.toString(str));
		}
	}
	
	private String[] translation(SKOSQuoteLib.FOREIGN tforegin) {
		double Dot = Math.pow(10, tforegin.m_sDecimal);
		String[] result = new String[14];
		result[0] = new String(tforegin.m_caStockNo).trim(); // 布腹
		result[1] = new String(tforegin.m_caStockName).trim(); // 布嘿
		result[2] = (tforegin.m_nBid / Dot) + ""; // 禦基
		result[3] = tforegin.m_nBc + ""; // 禦秖
		result[4] = (tforegin.m_nAsk / Dot) + ""; // 芥基
		result[5] = tforegin.m_nAc + ""; // 芥秖
		result[6] = (tforegin.m_nClose / Dot) + ""; // Θユ基
		result[7] = (tforegin.m_nClose / Dot) - (tforegin.m_nRef / Dot) + ""; // 害禴
		result[8] = ((tforegin.m_nClose / Dot) / (tforegin.m_nRef / Dot)) - 1  + ""; // 害禴碩
		result[9] = tforegin.m_nTickQty + ""; // 虫秖
		result[10] = tforegin.m_nTQty + ""; // 羆秖
		result[11] = (tforegin.m_nHigh / Dot) + ""; // 程蔼基
		result[12] = (tforegin.m_nLow / Dot) + ""; // 程基
		result[13] = (tforegin.m_nRef / Dot) + ""; // 琎Μ
		return result;
		
	}
}
