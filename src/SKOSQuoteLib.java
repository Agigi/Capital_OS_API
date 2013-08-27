import java.util.Arrays;
import java.util.List;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.ShortByReference;
import com.sun.jna.win32.StdCallLibrary;

public interface SKOSQuoteLib extends StdCallLibrary{ 
	public int SKOSQuoteLib_AttachConnectCallBack(FOnNotifyConnection d);
	public int SKOSQuoteLib_AttachOverseaProductsCallBack(FOnOverseaProducts d);
	public int SKOSQuoteLib_AttachServerTimeCallBack(FOnNotifyServerTime d);
	public int SKOSQuoteLib_AttachQuoteCallBack(FOnNotifyQuote d);
	public int SKOSQuoteLib_AttachKLineDataCallBack(FOnNotifyKLineData d); 
	public int SKOSQuoteLib_AttachBest5GetCallBack(FOnNotifyBest5Get d);
	public int SKOSQuoteLib_AttachBest5CallBack(FOnNotifyBest5 d);
	public int SKOSQuoteLib_AttachTicksGetCallBack(FOnNotifyTicksGet d);
	public int SKOSQuoteLib_AttachTicksCallBack(FOnNotifyTicks d); 
	public int SKOSQuoteLib_AttachHistoryTicksGetCallBack(FOnNotifyTicksGet d);
	public int SKOSQuoteLib_AttachStockCallBack(FOnStockGet d);
	public int SKOSQuoteLib_AttachKDataCallBack(FOnNotifyKData d);
 
	public int SKOSQuoteLib_Initialize(String id,String pass);
	public int SKOSQuoteLib_EnterMonitor(short sConncetType);
	public int SKOSQuoteLib_LeaveMonitor();
	public int SKOSQuoteLib_RequestOverseaProducts();
	
	public int SKOSQuoteLib_GetStockByIndex(short sStockidx,FOREIGN pStock);	
	public int SKOSQuoteLib_GetStockByIndex_CallBack(short sStockidx);
	public int SKOSQuoteLib_GetStockByNo(String pStockNos,FOREIGN pStock);		//WString instead of tchar*
	public int SKOSQuoteLib_GetStockByNo_CallBack(String pStockNos);
	public int SKOSQuoteLib_GetBest5(short sStockidx,BEST5 Best5);
	
	public int SKOSQuoteLib_GetTick(short sStockidx,int nPtr,TICK tick); 
	public int SKQuoteLib_GetVersion(String lpszVersion,IntByReference pnSize);
	public int SKOSQuoteLib_RequestStocks(ShortByReference psPageNo, String pStockNo);
	public int SKOSQuoteLib_RequestTicks(ShortByReference psPageNo,String pStockNo);
	
	public int SKOSQuoteLib_RequestServerTime();
	
	public int SKOSQuoteLib_RequestKLine(String pStock,short KLineType);
	public int SKOSQuoteLib_RequestKData(ShortByReference psPageNo,String pStockNo);
	 
	public ShortByReference sbr_tick=new ShortByReference((short)-1);
	//java對應c的structure  主要在處理指標	
	public static class FOREIGN extends Structure{
		public short m_sStockidx; // 系統自行定義的股票代碼
		public short m_sDecimal; // 報價小數位數
		public int m_nDenominator; // 分母
		public byte m_cMarketNo; //市場代碼 0x05海外商品
		public byte[] m_caExchangeNo = new byte[20]; //交易所代號
		public byte[] m_caExchangeName = new byte[20]; //交易所名稱
		public byte[] m_caStockNo = new byte[20]; //股票代號
		public byte[] m_caStockName = new byte[20]; //股票名稱
		public int m_nOpen; //開盤價
		public int m_nHigh; //最高價
		public int m_nLow; //最低價
		public int m_nClose; //成交價
		public int m_nSettlePrice; //結算價
		public int m_nTickQty; //單量
		public int m_nRef; //昨收、參考價
		public int m_nBid; // 買價
		public int m_nBc; // 買量
		public int m_nAsk; // 賣價
		public int m_nAc; // 賣量
		public int m_nTQty; //成交量
		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[]{"m_sStockidx","m_sDecimal","m_nDenominator","m_cMarketNo","m_caExchangeNo","m_caExchangeName","m_caStockNo","m_caStockName","m_nOpen","m_nHigh","m_nLow","m_nClose","m_nSettlePrice","m_nTickQty","m_nRef","m_nBid","m_nBc","m_nAsk","m_nAc","m_nTQty"});
		}
	}
	//java對應c的structure  主要在處理指標	
	public static class BEST5 extends Structure{
		public int m_nBid1;
		public int m_nBidQty1;
		public int m_nBid2;
		public int m_nBidQty2;
		public int m_nBid3;
		public int m_nBidQty3;
		public int m_nBid4;
		public int m_nBidQty4;
		public int m_nBid5;
		public int m_nBidQty5;
		public int m_nAsk1;
		public int m_nAskQty1;
		public int m_nAsk2;
		public int m_nAskQty2;
		public int m_nAsk3;
		public int m_nAskQty3;
		public int m_nAsk4;
		public int m_nAskQty4;
		public int m_nAsk5;
		public int m_nAskQty5;
		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[]{"m_nBid1", "m_nBidQty1", "m_nBid2", "m_nBidQty2", "m_nBid3", "m_nBidQty3", "m_nBid4", "m_nBidQty4", "m_nBid5", "m_nBidQty5", "m_nAsk1", "m_nAskQty1", "m_nAsk2", "m_nAskQty2", "m_nAsk3", "m_nAskQty3", "m_nAsk4", "m_nAskQty4", "m_nAsk5", "m_nAskQty5"});
		}
	}
	//java對應c的structure  主要在處理指標	
	public static class TICK extends Structure{
		public int m_nPtr; //Index
		public int m_nTime; //時間
		public int m_nClose; //成交價
		public int m_nQty; //成交量
		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(new String[]{"m_nPtr", "m_nTime", "m_nClose", "m_nQty"});
		}
	}
}



