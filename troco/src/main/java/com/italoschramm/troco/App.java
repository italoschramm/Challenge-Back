package com.italoschramm.troco;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {	
    	Scanner sc1 = new Scanner(System.in);
    	System.out.println( "Informe o valor total: " );
    	double totalValue = sc1.nextDouble();
    	System.out.println( "Informe o valor a ser pago: " );
    	double valuePaid = sc1.nextDouble();
    	
    	double change = 0;
		try {
			change = calcChange(totalValue, valuePaid);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	System.out.println("Troco: R$ " + Util.formatMoney(change));
    	
    	Map<Double, Integer> mapChange = getBetterCash(change);
    	for (Map.Entry<Double, Integer> map : mapChange.entrySet()) { 
    		System.out.print("- " + map.getValue() + " x R$ " + Util.formatMoney(map.getKey()) + "\n"); 
    	}
    	
    	sc1.close();
    }
    
    public static double calcChange(double totalValue, double valuePaid) throws Exception {
    	double change = valuePaid - totalValue;
    	if(change < 0)
    		throw new Exception("Valor pago menor do que o valor total!");
    	return change;
    }
    
    public static Map<Double, Integer> getBetterCash(double change) {
    	double bankNote[] = {100, 50, 20, 10, 5, 2};
        double cents[] = {100, 50, 25, 10, 5, 1};
        
        
        Map<Double, Integer> resultMap = new HashMap<Double, Integer>();
        int value = (int) change ;
        int i = 0;
        int quantity = 0;
        double rest = change;
        while (i <= 5) {
        	quantity = (int) (value / bankNote[i]); // Calculando a quantidade de notas
          if (quantity > 0) {
        	 resultMap.put(bankNote[i], quantity);
             value = (int) (value % bankNote[i]);
             rest = rest - bankNote[i];
          }
          i = i + 1; //próxima nota
        }

        value = (int)Math.round(rest * 100);
        i = 0;
        while (i <= 5) {
          quantity = (int) (value / cents[i]); // calculando a qtde de moedas
          if (quantity != 0) {
        	 resultMap.put(cents[i]/100, quantity) ;
             value = (int) (value % cents[i]); // sobra
          }
          i = i + 1; // próximo centavo
        }
        
        return Util.orderMap(resultMap);
    }
}
