import java.util.Arrays;

import com.sun.jna.win32.StdCallLibrary.StdCallCallback;


public class FOnStockGet implements StdCallCallback{
	public void callback(short sStockidx, short sDecimal,int nDenominator,short sMarketNo,String bstrExchangeNo,String bstrExchangeName,String bstrStockNo,String bstrStockName, int nOpen,int nHigh,int nLow, int nClose, int nSettlePrice, int nTickQty, int nRef, int nBid, int nBc, int nAsk, int nAc, int nTQty) {
		//System.out.println(sStockidx);
		int nDot = (int) Math.pow(10,sDecimal);
		String[] result = new String[14];
		result[0] = bstrExchangeName.trim(); //����ҦW��
		result[1] = bstrStockName.trim(); //�ӫ~�W��
		result[2] = (nOpen / nDot) + ""; //�}�L��
		result[3] = (nHigh / nDot) + ""; //�̰���
		result[4] = (nLow / nDot) + ""; //�̧C��
		result[5] = (nClose / nDot) + ""; //�����
		result[6] = (nSettlePrice / nDot) + ""; //�����
		result[7] = nTickQty + ""; //��q
		result[8] = (nRef / nDot) + ""; //�Q���B�Ѧһ�
		result[9] = (nBid / nDot) + ""; //�R��
		result[10] = nBc + ""; //�R�q
		result[11] = (nAsk / nDot) + ""; //���
		result[12] = nAc + ""; //��q
		result[13] = nTQty + ""; //����q
		System.out.println(Arrays.toString(result));
	}
}
