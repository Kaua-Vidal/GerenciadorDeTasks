package dcx.ufpb.br.gerenciadorDeTask.exceptions;

import dcx.ufpb.br.gerenciadorDeTask.Usuario;

public class UsuarioJaCadastradoException extends Exception{
    public UsuarioJaCadastradoException(String msg){
        super(msg);
    }
}
