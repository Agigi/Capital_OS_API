import java.util.Arrays;

import com.sun.jna.win32.StdCallLibrary.StdCallCallback;


public class FOnStockGet implements StdCallCallback{
	public void callback(short sStockidx, short sDecimal,int nDenominator,short sMarketNo,String bstrExchangeNo,String bstrExchangeName,String bstrStockNo,String bstrStockName, int nOpen,int nHigh,int nLow, int nClose, int nSettlePrice, int nTickQty, int nRef, int nBid, int nBc, int nAsk, int nAc, int nTQty) {
		//System.out.println(sStockidx);
		int nDot = (int) Math.pow(10,sDecimal);
		String[] result = new String[14];
		result[0] = bstrExchangeName.trim(); //ユ┮嘿
		result[1] = bstrStockName.trim(); //坝珇嘿
		result[2] = (nOpen / nDot) + ""; //秨絃基
		result[3] = (nHigh / nDot) + ""; //程蔼基
		result[4] = (nLow / nDot) + ""; //程基
		result[5] = (nClose / nDot) + ""; //Θユ基
		result[6] = (nSettlePrice / nDot) + ""; //挡衡基
		result[7] = nTickQty + ""; //虫秖
		result[8] = (nRef / nDot) + ""; //琎Μ把σ基
		result[9] = (nBid / nDot) + ""; //禦基
		result[10] = nBc + ""; //禦秖
		result[11] = (nAsk / nDot) + ""; //芥基
		result[12] = nAc + ""; //芥秖
		result[13] = nTQty + ""; //Θユ秖
		System.out.println(Arrays.toString(result));
	}
}
