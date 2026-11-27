import java.util.*;

public class PrimoGerador{
    private static boolean[] encerrado;
    private static int[] resultado;

    public static int[] gerandoPrimos(int maxValue){
        if(maxValue < 2){
            return new int[0];
        }else{
            descruzarInteiro(maxValue);
            multiploEncerrado();
            resultadoInteiro();
            return resultado;
        }
    }

    private static void descruzarInteiro(int maxValue){
        encerrado = new boolean[maxValue + 1];
        for (int i = 2; i < encerrado.length; i++){
            encerrado[i] = false;
        }
    }

    private static void multiploEncerrado(){
        int limite = determinaLimiteInterator();
        for (i = 2; i <= limite; i++){
            if(naoEncerrado(i)){
                multiploEncerradoDe(i);
            }
        }
    }

    private static int determinaLimiteInterator(){
        double interatorLimit = Math.sqrt(encerrado.length);
        return (int) interatorLimit;
    }

    private static void multiploEncerradoDe(int i){
        for(int multiple = 2 * i; multiple < encerrado.length; multiple += i){
            encerrado[multiple] = true;
        }
    }

    private static boolean naoEncerrado(int i){
        return encerrado[i] == false;
    }

    private static void integerResultado(){
        resultado = new int[numeroInteiro()];
        for(int j= 0; i = 2; i < encerrado.length; i++){
            if (naoEncerrado(i)){
                resultado[j++] = i;
            }
        }

        private static numeroInteiro(){
            int contador = 0;
            for (int i=2; i< encerrado.length; i++){
                if (naoEncerrado(i)){
                    contador++;
                }
            }
            return contador;
        }
    }
}


kmkmk
