import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.sun.jna.Native;
import com.sun.jna.ptr.ShortByReference;

public class SKOSQuoteLib_SWT_Example {
	//static FOnNotifyKLineData fnkld;
	public static ShortByReference sbr_tick = new ShortByReference((short) -1);
	public static ShortByReference sbr_zero = new ShortByReference((short) 0);
	static int ini;
	public static void main(String[] args) {

		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setSize(300, 200);
		shell.setText("群益海期報價API");
		shell.setLayout(new RowLayout());
		final SKOSQuoteLib skquotelib = (SKOSQuoteLib) Native.loadLibrary(
				"SKOSQuoteLib", SKOSQuoteLib.class);
		System.out.println("start OverSea");

		final Button button = new Button(shell, SWT.PUSH);
		button.setText("接收報價");
		final Button close = new Button(shell, SWT.PUSH);
		close.setText("結束連線");
		final Label connectionlabel = new Label(shell, SWT.SHADOW_IN);
		connectionlabel.setText("Connecting...");
		System.out.println("skquotelib =" + skquotelib);
		ini = skquotelib.SKOSQuoteLib_Initialize("身分證字號","密碼");
		System.out.println("inti " + ini);
		if (ini == 0) {
			// fnkld=new FOnNotifyKLineData();
			// fnmt = new FOnNotifyMarketTot(skquotelib,twse_ohlc);
			// fnq = new FOnNotifyQuote(skquotelib,twse_ohlc);
			// int kline = skquotelib.SKQuoteLib_AttachKLineDataCallBack(fnkld);
			ini = ini + skquotelib
					.SKOSQuoteLib_AttachServerTimeCallBack(new FOnNotifyServerTime());
			ini = ini + skquotelib
					.SKOSQuoteLib_AttachConnectCallBack(new FOnNotifyConnection());
			// int tot = skquotelib.SKQuoteLib_AttachMarketTotCallBack(fnmt);
			ini = ini + skquotelib
					.SKOSQuoteLib_AttachQuoteCallBack(new FOnNotifyQuote());
			ini = ini + skquotelib.SKOSQuoteLib_AttachStockCallBack(new FOnStockGet());
			skquotelib.SKOSQuoteLib_EnterMonitor((short)0);
		}

		button.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				String tmp = "Status: "
						+ skquotelib.SKOSQuoteLib_RequestStocks(sbr_zero, "SGX,TWN1308#17,KOSPI");
				connectionlabel.setText(tmp);
			}

			public void widgetDefaultSelected(SelectionEvent event) {
				String tmp = "Status: "
						+ skquotelib.SKOSQuoteLib_RequestStocks(sbr_zero, "SGX,TWN1308#17,KOSPI");
				connectionlabel.setText(tmp);
			}
		});

		close.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				String tmp = "Status: " + skquotelib.SKOSQuoteLib_LeaveMonitor();
				;
				connectionlabel.setText(tmp);
			}

			public void widgetDefaultSelected(SelectionEvent event) {
				String tmp = "Status: " + skquotelib.SKOSQuoteLib_LeaveMonitor();
				;
				connectionlabel.setText(tmp);
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}