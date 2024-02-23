package brack.bernardo.catalogoimdb.infra.banco;

import java.util.*;

public class BancoDeDados {

    private static final Map<Class, Set> OBJETOS = new HashMap<>();
    private static Long id = 0L;

    public void inserirObjeto(Object objeto) {
        Set objetos = colecaoDeObjetos(objeto.getClass());
        objetos.add(objeto);
    }

    public void excluirObjeto(Object objeto) {
        Set objetos = colecaoDeObjetos(objeto.getClass());
        objetos.remove(objeto);
    }

    public List buscarObjetosPorTipo(Class clazz) {
        Set objetos = colecaoDeObjetos(clazz);
        return new ArrayList(objetos);
    }

    private Set colecaoDeObjetos(Class clazz) {
        Set objetos = (Set) BancoDeDados.OBJETOS.get(clazz);
        if (objetos == null) {
            objetos = new HashSet();
            BancoDeDados.OBJETOS.put(clazz, objetos);
        }
        return objetos;
    }

    public Long proximoId() {
        id = id + 1;
        return id;
    }

}