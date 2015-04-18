package com.example.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*This is a controller class, it communicates with the model and the view*/
public class StockController{
	private static final StockController stockController = new StockController();
	
	private StockController(){}

	public static StockController getInstance(){
        	return stockController;
    	}//end getInstance Method

	public Stock getStockPrice(String symbol){
		Stock stock;
		long currentTime = (new Date()).getTime();
		stock = getStockInfo(symbol, currentTime);
		return stock;
	}//end getStockPrice method
	
	//This is synched so we only do one request at a time
	private synchronized Stock getStockInfo(String symbol, long time) {
		Stock stockInfo = new Stock();
		try {
			URL yahoofin = new URL("http://finance.yahoo.com/d/quotes.csv?s=" + symbol + "&f=sl1d1t1c1ohgv&e=.csv");
			URLConnection yc = yahoofin.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				String[] stockInfoArray = inputLine.split(",");
				stockInfo.setTicker(stockInfoArray[0].replaceAll("\"", ""));
				stockInfo.setPrice(Float.valueOf(stockInfoArray[1]));
				stockInfo.setChange(Float.valueOf(stockInfoArray[4]));
				stockInfo.setChartUrlSmall("http://ichart.finance.yahoo.com/t?s=" + stockInfo.getTicker());
				stockInfo.setChartUrlLarge("http://chart.finance.yahoo.com/w?s=" + stockInfo.getTicker());
				stockInfo.setLastUpdated(time);
				break;
			}//end while loop
			in.close();
		}//end try block
		catch (Exception ex) {
			//send a message that there was an error.
			//log.error("Unable to get stockinfo for: " + symbol + ex);
			ex.printStackTrace();
		}//end catch block
		return stockInfo;
	}//end refreshStockInfo
}//end StockTicker class
