package lexico;

public class Analisador {
    Entrada ent;

    public Analisador(String arquivo){
        ent = new Entrada(arquivo);
    }
    public Token proximoToken(){
        //ignorar espacos em branco --> is read retorn -1 quando finalizar a leitura
        int caractereLido= -1;

        while((caractereLido = ent.LerProximoCaratere()) != -1){
            char c = (char)caractereLido;
            if(c == ' ' || c == '\n')
                continue;
            // teste
            //token com unico caractere
            if(c == ':'){
                return new Token(TipoToken.DoisPontos, ":");
            }else if(c == '.'){
                return new Token(TipoToken.Ponto, "." );
            }else if(c == ','){
                return new Token(TipoToken.Virgula, "," );
            }else if(c == ';'){
                return new Token(TipoToken.PontoVirgurla, ";" );
            }else if(c == '|'){
                c = (char)ent.LerProximoCaratere();
                if(c == '|'){
                    return new Token(TipoToken.OpBoolOu, "||");
                }else{
                    return new Token(TipoToken.Barra, "|");
                }
            }else if(c == '\\'){
                return new Token(TipoToken.BarraInversa, "\\" );
            }else if(c == '?'){
                return new Token(TipoToken.Interrogacao, "?" );
            }else if(c == '!'){
                return new Token(TipoToken.Exclamacao, "!" );
            }else if(c == '*'){
                return new Token(TipoToken.OpMultiplicacao, "*" );
            }else if(c == '/'){
                return new Token(TipoToken.OpDivisao, "/" );
            }else if(c == '+'){
                return new Token(TipoToken.OpSoma, "+" );
            }else if(c == '-') {
                return new Token(TipoToken.OpSubtracao, "-");
            }
            else if(c == '{') {
                return new Token(TipoToken.AbrirPar, "{");
            }else if(c == '}') {
                return new Token(TipoToken.FecharPar, "}");
            }else if(c == '[') {
                return new Token(TipoToken.AbrirCol, "[");
            }else if(c == ']') {
                return new Token(TipoToken.FecharCol, "]");
            }else if(c == '\'') {
                return new Token(TipoToken.AspasSimples, "'");
            }
            else if(c == '\"') {
                return new Token(TipoToken.AspasDuplas, "\"");
            }

            //relacionais ==> == >=
            // implementar um logica para dois caracteres
            else if(c == '<') {
                c = (char)ent.LerProximoCaratere();
                if(c == '>'){
                    return new Token(TipoToken.Diferente, "<>");
                }else if(c == '='){
                    return new Token(TipoToken.MenorIgualQue, "<=");
                }else{
                    return new Token(TipoToken.MenorQue, "<");
                }
            }

            else if(c == '>') {
                c = (char)ent.LerProximoCaratere();
                if(c == '='){
                    return new Token(TipoToken.MaiorIgualQue, ">=");
                }else{
                    return new Token(TipoToken.MaiorQue, ">");
                }
            }

            else if(c == '=') {
                c = (char)ent.LerProximoCaratere();
                if(c == '='){
                    return new Token(TipoToken.Igual, "==");
                }else{
                    return new Token(TipoToken.Atribui, "=");
                }
            }

            else if(c == '=') {
                c = (char)ent.LerProximoCaratere();
                if(c == '='){
                    return new Token(TipoToken.Igual, "==");
                }else{
                    return new Token(TipoToken.Atribui, "=");
                }
            }

            else if(c == '&') {
                c = (char)ent.LerProximoCaratere();
                if(c == '&'){
                    return new Token(TipoToken.OpBoolE, "&&");
                }
            }
            else if(c == '|') {
                c = (char)ent.LerProximoCaratere();
                if(c == '='){
                    return new Token(TipoToken.Igual, "==");
                }
            }

        }

        return null;
    }
}








































