package snf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tools {
	public static final String MSG_01 = "Não é possivel incluir. Número máximo já foi atingido";

	public static void msg(String msg) {
		System.out.print(msg);
	}

	public static void errormsg(Exception e, boolean fim ) {
    	msg(">> Mensagem de ERRO!!\n" + e);
    	if (fim) {
        	msg("\n\n***  Programa será finalizado!");
        	System.exit(0);
    	}
	}

	public static String repeatStr(String s, int n) {
		String ret = "";
		for (int k=0 ; k<n ; k++){
			ret+=s;
		}
		return ret;
	}

	public static FileReader leitorArquivo(String arqCSV) {
		FileReader arquivo = null;
		try {
			arquivo = new FileReader(arqCSV);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return arquivo;
	}
	
	public static void closeReader(BufferedReader is) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				snf.Tools.errormsg(e,true);	
			}
		}
	}
	
}
