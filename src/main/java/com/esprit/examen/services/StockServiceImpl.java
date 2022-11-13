package com.esprit.examen.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockServiceImpl implements IStockService {

	@Autowired
	StockRepository stockRepository;


	@Override
	public List<Stock> retrieveAllStocks() {
		// récuperer la date à l'instant t1
		
		return stockRepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		// récuperer la date à l'instant t1
	
		return stockRepository.save(s);
		
	}

	@Override
	public void deleteStock(Long stockId) {
		
		stockRepository.deleteById(stockId);

	}

	@Override
	public Stock updateStock(Stock s) {
		
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long stockId) {
		return stockRepository.findById(stockId).orElse(null);
	}

	StringBuilder bld = new StringBuilder();
	@Override
	public String retrieveStatusStock() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String msgDate = sdf.format(now);
		String finalMessage = "";
		String newLine = System.getProperty("line.separator");
		List<Stock> stocksEnRouge = stockRepository.retrieveStatusStock();
		for (int i = 0; i < stocksEnRouge.size(); i++) {
			bld.append(newLine + finalMessage + msgDate+newLine + ": le stock ");
			finalMessage = bld.toString();
					

		}
		
		return finalMessage;
	}

}