package com.mybank.fvk;

import java.util.*;

import com.mybank.model.Model;
import com.mybank.view.ATMView;

import java.io.*;

public class Configuration {
    private static Configuration _instance = null;

    private ATMView view = null;

    private Configuration(Model m) {
        view = new ATMView(m);
    	/*try {
    		FileReader fileReader = new FileReader(  new File("/../data/props.txt"));
    		BufferedReader reader=new BufferedReader(fileReader);
    		String line=null;
    		while((line=reader.readLine())!=null){
    			System.out.println(line);
    			reader.close();
    		}
   	    }
    	catch (Exception e) {
    	    // обработайте ошибку чтения конфигурации
    	}
    	*/
    }

    public synchronized static Configuration getInstance(Model m) {
        if (_instance == null)
            _instance = new Configuration(m);
        return _instance;
    }

    // получить значение свойства по имени
    public synchronized ATMView getView() {
        
        return view;
    }
}