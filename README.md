Capital\_OS\_API (群益海期報價API)
===========
作者：[Philipz](mailto://philipzheng@gmail.com "Email")  
Blog：[Philipz學習日誌](http://server.everfine.com.tw/blog/)  
感謝[Lucas](mailto://jenru.tw@gmail.com)提供JNA+SWT來接C語言Callback的程式碼
API下載網址：[群益API](http://www.capital.com.tw/Service2/Download/api.asp)

使用Java JNA和SWT去界接群益海期報價API的範例

1.  使用必要條件  
a.  需有群益帳戶  
b.  有開通報價API，並下載那API相關DLL檔  

2.  使用方法  
a.  將群益帳號密碼輸入到SKOSQuoteLib_SWT_Example的身分證字號和密碼。  
b.  將那SKOSQuoteLib.dll和SKOSQuoteLib.lib複製到這專案目錄下。  
c.  如果那SKOSQuoteLib.dll為32位元，請用32位元版的SWT和JDK，若64位元，則用64位元版的SWT和JDK，目前是使用32位元。  
d.  執行那SKOSQuoteLib_SWT_Example.java，需先修改摩台期代碼，TWN+年月，如：TWN1308，就會登入，按下接收報價就會取得新加玻摩台期跟韓國股市指數的報價。  
e.  要結束請先按結束連線再關閉。  

目前 [TradingBot 程式交易機器人](http://www.tradingbot.com.tw)，就是使用群益報價API  
歡迎大家加入討論程式交易，[Facebook粉絲團](http://www.facebook.com/tradingbot)  
![capital_os_api.png](http://server.everfine.com.tw/blog/capital_os_api.png "capital_os_api.png")
