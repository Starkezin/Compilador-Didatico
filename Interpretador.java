public class Interpretador {

    public int interpretador(ArvoreSintatica tree){
        if (tree instanceof Num) {
            return ((Num) tree).num;
        }

        if (tree instanceof Operador) {
            Operador op = (Operador) tree;
            int left = interpretador(op.arg1);
            int right = interpretador(op.arg2);

            if (op instanceof Soma) return left + right;
            if (op instanceof Sub) return left - right;
            if (op instanceof Mult) return left * right;
            if (op instanceof Div) return left / right;

            throw new IllegalArgumentException("Operador desconhecido: " + op.getClass().getName());

        }
        throw new IllegalArgumentException("Tipo de nó desconhecido: " + tree.getClass().getName());
    }
 

}