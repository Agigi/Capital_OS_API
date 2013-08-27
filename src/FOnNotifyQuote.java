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
		result[0] = new String(tforegin.m_caStockNo).trim(); // �Ѳ��N��
		result[1] = new String(tforegin.m_caStockName).trim(); // �Ѳ��W��
		result[2] = (tforegin.m_nBid / Dot) + ""; // �R��
		result[3] = tforegin.m_nBc + ""; // �R�q
		result[4] = (tforegin.m_nAsk / Dot) + ""; // ���
		result[5] = tforegin.m_nAc + ""; // ��q
		result[6] = (tforegin.m_nClose / Dot) + ""; // �����
		result[7] = (tforegin.m_nClose / Dot) - (tforegin.m_nRef / Dot) + ""; // ���^
		result[8] = ((tforegin.m_nClose / Dot) / (tforegin.m_nRef / Dot)) - 1  + ""; // ���^�T
		result[9] = tforegin.m_nTickQty + ""; // ��q
		result[10] = tforegin.m_nTQty + ""; // �`�q
		result[11] = (tforegin.m_nHigh / Dot) + ""; // �̰���
		result[12] = (tforegin.m_nLow / Dot) + ""; // �̧C��
		result[13] = (tforegin.m_nRef / Dot) + ""; // �Q��
		return result;
		
	}
}
