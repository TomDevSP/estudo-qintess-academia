package com.qintess.leitura.arquivo;

import java.util.HashMap;
import java.util.Map;

public class LerFileHashMap {
	public static void main(String[] args) {
		Map<String, Double> resultados = new HashMap<String, Double>();
		
		resultados.put("abbccc", 19.0);
		resultados.put("aaabc", 8.0);
		
		if (resultados.containsKey("abbccc")) {
			double valor = resultados.get("abbccc");
			valor += 1.3;
			resultados.replace("abbccc", valor);
		}
		resultados.forEach((k,v) -> System.out.println(v));
	}

}
