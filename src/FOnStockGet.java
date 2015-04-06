import java.util.Arrays;

import com.sun.jna.win32.StdCallLibrary.StdCallCallback;


public class FOnStockGet implements StdCallCallback{
	public void callback(short sStockidx, short sDecimal,int nDenominator,short sMarketNo,String bstrExchangeNo,String bstrExchangeName,String bstrStockNo,String bstrStockName, int nOpen,int nHigh,int nLow, int nClose, int nSettlePrice, int nTickQty, int nRef, int nBid, int nBc, int nAsk, int nAc, int nTQty) {
		//System.out.println(sStockidx);
		int nDot = (int) Math.pow(10,sDecimal);
		String[] result = new String[14];
		result[0] = bstrExchangeName.trim(); //交易所名稱
		result[1] = bstrStockName.trim(); //商品名稱
		result[2] = (nOpen / nDot) + ""; //開盤價
		result[3] = (nHigh / nDot) + ""; //最高價
		result[4] = (nLow / nDot) + ""; //最低價
		result[5] = (nClose / nDot) + ""; //成交價
		result[6] = (nSettlePrice / nDot) + ""; //結算價
		result[7] = nTickQty + ""; //單量
		result[8] = (nRef / nDot) + ""; //昨收、參考價
		result[9] = (nBid / nDot) + ""; //買價
		result[10] = nBc + ""; //買量
		result[11] = (nAsk / nDot) + ""; //賣價
		result[12] = nAc + ""; //賣量
		result[13] = nTQty + ""; //成交量
		System.out.println(Arrays.toString(result));
	}
}
