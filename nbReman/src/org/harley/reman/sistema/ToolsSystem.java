package org.harley.reman.sistema;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ToolsSystem {
    
    public static boolean CompararVersiones(String A, String B){
        String[] SeparadoA = A.split("\\.");
        String[] SeparadoB = B.split("\\.");
        int length = Math.max(SeparadoA.length, SeparadoB.length);
        
        String[] CadenaA = new String[length];
        String[] CadenaB = new String[length];
        
        for(int a=0; a<SeparadoA.length; a++){
            CadenaA[a]=SeparadoA[a];
        }
        for(int b=0; b<SeparadoB.length; b++){
            CadenaB[b]=SeparadoB[b];
        }
        
        if(length > SeparadoA.length){
            for(int i = SeparadoA.length; i < length; i++){
                CadenaA[i] = "0";
            }
        }
        else{
            for(int j = SeparadoB.length; j < length; j++){
                CadenaB[j] = "0";
            }
        }
       
        for(int k=0; k<length ;k++){
            if(CadenaA[k].length() > CadenaB[k].length())
                return true;
            else if(CadenaB[k].length() > CadenaA[k].length())
                return false;
            else{
                for(int l=0; l<CadenaA[k].length(); l++){
                     if(CadenaA[k].codePointAt(l) > CadenaB[k].codePointAt(l)){
                         return true;
                     }
                     if(CadenaA[k].codePointAt(l) < CadenaB[k].codePointAt(l)){
                         return false;
                     }
                }
            }  
        }
        return false;
    }
    
    public static String IncrementarCodigo(String A){
        int []convertido = new int[A.length()];
        int cont = 0;
        String B="";
        
        for(int i=0; i<A.length(); i++){
            convertido[i] = A.codePointAt(i);
            if(convertido[i]<48 || convertido[i]>57){
                cont+=1;
            }
        }
        
        convertido[A.length()-1]+=1;
        
        for(int i=A.length()-1; i>=cont;i--){
            if(convertido[i]>57){
                convertido[i]-=10;
                convertido[i-1]+=1;
            }
        }
        
        for(int i=0; i<A.length(); i++){
            B = B + String.valueOf((char)convertido[i]);
        }
        return B;
    }
    
    public static String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
    
    public static ArrayList<ArrayList<String>> getHist(ArrayList<Historico> historicos){
        ArrayList<ArrayList<String>> datos = new ArrayList<>();
        ArrayList<String> version = new ArrayList<>();
        ArrayList<String> fecha = new ArrayList<>();
        ArrayList<String> razon = new ArrayList<>();
        ArrayList<String> autor = new ArrayList<>();
        for(Historico h : historicos){
            version.add(h.getVersion());
            fecha.add(h.getFecha());
            razon.add(h.getRazon());
            autor.add(h.getAutor());            
        }
        datos.add(version);
        datos.add(fecha);
        datos.add(razon);
        datos.add(autor);
        return datos;
    }
}