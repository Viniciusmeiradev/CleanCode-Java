public class quantidadePalavras{
    private String numero;
    private String verbo;
    private String pluralModificador;
    
    public String faz(char candidato, int count){
        createPluralDependentMessageParts(count);
        return String.format("Analise: %s %s - %s (%s)", verbo, numero, candidato, pluralModificador);
    }

    
    private void createPluralDependentMessageParts(int count){
        if (count == 0){
            naotemLetra();
        }else if(count == 1){
            temUmaLetra();
        }else{
            temMuitasLetras(count);
        }
    }

    private void naotemLetra(){
        numero = "nenhum";
        verbo = "Existem";
        pluralModificador = "s";
    }

    private void temUmaLetra(){
        numero = "1";
        verbo = "Existe";
        pluralModificador = "";
    }

    private void temMuitasLetras(int count){
        numero = Integer.toString(count);
        verbo = "Existem";
        pluralModificador = "s";
    }

    public static void main(String[] args){
        quantidadePalavras mensagem= new quantidadePalavras();
        System.out.println(mensagem.faz('a',1));
        System.out.println(mensagem.faz('a',6));
        System.out.println(mensagem.faz('a',0));
    }
}
