
public class LDAPParametrosConfig {
	 /*
     * Implementação do Initial context para LDAP
     */
    public static final String INITIAL_CTX = "com.sun.jndi.ldap.LdapCtxFactory";
    /*
     * Servidor LDAP
     */
    public static final String SERVIDOR = "ldap://192.168.0.145:389";
    /*
     * Base de busca
     */
    public static final String SEARCHBASE = "ou=users, dc=insofake,dc=com,dc=br";
    /*
     * Nome do usuário do admin
     */
    public static final String ADMIN_DN = "cn=admin,dc=insofake,dc=com,dc=br";
    /*
     * Senha
     */
    public static final String ADMIN_PW = "Pipoquinha01";
    /*
     *  “top level” do diretório (base DN)
     */
    public static final String BASE_DN = "dc=insofake,dc=com,dc=br";
    
    //<property name="userDn" value="cn=admin,dc=teste,dc=com,dc=br" />
//    <property name="password" value="teste" />    
    
}
