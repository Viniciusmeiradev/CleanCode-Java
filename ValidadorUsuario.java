//Compara usuario e senha

public class ValidadorUsuario {
    private Cryptographer cryptographer;
    
    public boolean checkSenha(String  username, String password){
        User user = UserGateway.findByName(username);
        if (user != User.NULL){
            String codedPhrase = user.getPharseEncodedByPassword();
            String phrase = cryptographer.decrypt(codedPhrase, password);
            
        }        
    }
}
