import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;


public class LDAPServiceLocator {
	protected static LDAPServiceLocator instance;
    private LDAPServiceLocator() {
        super();
    }
    /**
     * Obtem a mesma instancia de LDAPServiceLocator para todas as chamadas
     * (Classe singleton)
     *
     * @return um objeto LDAPServiceLocator
     */
    public static LDAPServiceLocator getInstance() {
        if (instance == null) {
            instance = new LDAPServiceLocator();
        }
        return instance;
    }
    public DirContext getContext() {
        Hashtable env = new Hashtable(2);
        // Especifica a fabrica de INITIAL CONTEXT
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                LDAPParametrosConfig.INITIAL_CTX);
        // Especifica o IP/Nome e a porta do servidor LDAP
        env.put(Context.PROVIDER_URL, LDAPParametrosConfig.SERVIDOR);
        // As linhas abaixo são usadas quando o servidor LDAP não permite busca como anonymous
        env.put(Context.SECURITY_PRINCIPAL, LDAPParametrosConfig.ADMIN_DN );
        env.put(Context.SECURITY_CREDENTIALS, LDAPParametrosConfig.ADMIN_PW );
        env.put(Context.SECURITY_PROTOCOL, "ssha" );
        // none", "simple", "strong"
        //env.put(Context.SECURITY_AUTHENTICATION, "strong");
        DirContext ctx = null;
        try {
            // Obtem um Initial Context
            ctx = new InitialDirContext(env);
        } catch (NamingException e) {
            System.out.println("Não foi possivel obter um contexto LDAP");
            e.printStackTrace();
        }
        return ctx;
    }
}
