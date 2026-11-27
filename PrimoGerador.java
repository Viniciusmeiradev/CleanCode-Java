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
