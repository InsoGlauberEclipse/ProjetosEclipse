import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchResult;

import java.util.Hashtable;

import javax.naming.Context;

import javax.naming.NamingException;

import javax.naming.directory.SearchControls;




public class Principal {

//	private static LdapContext ctx;
    //private static final String URL_LDAP = "ldap://192.168.0.145:389";
//	private static final String URL_LDAP = "ldap://192.168.0.145";
//    private static Hashtable<String, String> env;
    
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*
		String login = "Pedrinho";
		String senha = "Pedro01";
		// ///////////
		DirContext ctx = LDAPServiceLocator.getInstance().getContext();
		Attributes matchAttrs = new BasicAttributes(false);
		// Array de atributos que deseja retornar do LDAP
		String[] atributosRetorno = new String[] { "givenName", "cn" , "userPassword"};
		// Parametros de busca
		matchAttrs.put(new BasicAttribute("uid", login));
		matchAttrs.put(new BasicAttribute("userPassword", senha));
		System.out.println("Buscando...");
		try {
		// Efetua a busca
		NamingEnumeration resultado = ctx.search(
		LDAPParametrosConfig.SEARCHBASE, matchAttrs,
		atributosRetorno);
		// Exibindo o resultado, se houver
		while (resultado.hasMore()) {
		SearchResult sr = (SearchResult) resultado.next();
		// Obtem os atributos
		Attributes atributos = sr.getAttributes();
		for (NamingEnumeration todosAtributos = atributos.getAll(); todosAtributos
		.hasMore();) {
		Attribute attrib = (Attribute) todosAtributos.next();
		String nomeAtributo = attrib.getID();
		System.out.println("Atributo:" + nomeAtributo);
		// Exibe todos os valores do atributo
		for (NamingEnumeration e = attrib.getAll(); e.hasMore();) {
		System.out.println("\tvalor:" + e.next());
		}
		}
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		System.out.println("Busca finalizada.");
*/
		
		

		// Set up environment for creating initial context
		Hashtable env = new Hashtable(11);
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		//env.put(Context.PROVIDER_URL, "ldap://192.168.0.145:389/o=JNDITutorial");
		env.put(Context.PROVIDER_URL, "ldap://192.168.0.145:389");

		// Authenticate as S. User and give incorrect password
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		//env.put(Context.SECURITY_PRINCIPAL, "cn=S. User, ou=NewHires, o=JNDITutorial");
// Deu Certo		
//		env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=insofake,dc=com,dc=br");
//		env.put(Context.SECURITY_CREDENTIALS, "Pipoquinha01");

//		env.put(Context.SECURITY_PRINCIPAL, "cn=Pedrinho,ou=Users,dc=insofake,dc=com,dc=br");
//		env.put(Context.SECURITY_CREDENTIALS, "Pedro01");

		env.put(Context.SECURITY_PRINCIPAL, "cn=Pedrinho,ou=Users,dc=insofake,dc=com,dc=br");
		env.put(Context.SECURITY_CREDENTIALS, "Pedro011");
		
		
		try 
		{
		    // Create initial context
			
			// Se a credencial do usuário for inválida, aqui ja ocorre o exception.
			
		    DirContext ctx = new InitialDirContext(env);

		    System.out.println(ctx.lookup("ou=Users,dc=insofake,dc=com,dc=br"));

			Attributes matchAttrs = new BasicAttributes(false);
			// Array de atributos que deseja retornar do LDAP
			String[] atributosRetorno = new String[] { "givenName", "cn" , "userPassword"};

			// Efetua a busca
			NamingEnumeration resultado = ctx.search(LDAPParametrosConfig.SEARCHBASE, matchAttrs,atributosRetorno);
			// Exibindo o resultado, se houver
			while (resultado.hasMore()) 
			{
   			   SearchResult sr = (SearchResult) resultado.next();
			// Obtem os atributos
			Attributes atributos = sr.getAttributes();
			for (NamingEnumeration todosAtributos = atributos.getAll(); todosAtributos.hasMore();) 
			{
			    Attribute attrib = (Attribute) todosAtributos.next();
			    String nomeAtributo = attrib.getID();
			    System.out.println("Atributo:" + nomeAtributo);
    			//    Exibe todos os valores do atributo
			    for (NamingEnumeration e = attrib.getAll(); e.hasMore();) 
			    {
			        System.out.println("\tvalor:" + e.next());
			    }
			}
		    
		    // do something useful with ctx

		    // Close the context when we're done
		    ctx.close();
		   }
		} catch (NamingException e) {
		    e.printStackTrace();
		}		
		
		}		

		
/*		
	    env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, URL_LDAP);
        //env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_AUTHENTICATION, "md5");
        
        autenticarLdap("Juquinha", "Juca01");
        autenticarLdap("root", "Pipoquinha01");
*/        
//	}
/*
	 private static void autenticarLdap(String usuario, String senha) throws Exception
	             {
		 // 
	        env.put(Context.SECURITY_PRINCIPAL, "uid="+usuario+",ou=Groups,dc=insofake,dc=com,dc=br");
	        env.put(Context.SECURITY_CREDENTIALS,senha);
	        env.put(Context.SECURITY_PROTOCOL,"md5");
	        try {
	            ctx = new InitialLdapContext(env, null);
	            System.out.println("Autenticou.");
	        } catch (Exception e) {
	        	System.out.println("Usuário / Senha inválido.");
	            throw new Exception("Usuário / Senha inválido",e);
	
	
	        }
	             }
*/
	
	
	 public SearchResult findAccountByAccountName(DirContext ctx, String ldapSearchBase, String accountName) throws NamingException {

	        String searchFilter = "(&(objectClass=user)(sAMAccountName=" + accountName + "))";

	        SearchControls searchControls = new SearchControls();
	        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

	        NamingEnumeration<SearchResult> results = ctx.search(ldapSearchBase, searchFilter, searchControls);

	        SearchResult searchResult = null;
	        if(results.hasMoreElements()) {
	             searchResult = (SearchResult) results.nextElement();

	            //make sure there is not another item available, there should be only 1 match
	            if(results.hasMoreElements()) {
	                System.err.println("Matched multiple users for the accountName: " + accountName);
	                return null;
	            }
	        }
	        
	        return searchResult;
	    }
	    
	    public String findGroupBySID(DirContext ctx, String ldapSearchBase, String sid) throws NamingException {
	        
	        String searchFilter = "(&(objectClass=group)(objectSid=" + sid + "))";

	        SearchControls searchControls = new SearchControls();
	        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
	        
	        NamingEnumeration<SearchResult> results = ctx.search(ldapSearchBase, searchFilter, searchControls);

	        if(results.hasMoreElements()) {
	            SearchResult searchResult = (SearchResult) results.nextElement();

	            //make sure there is not another item available, there should be only 1 match
	            if(results.hasMoreElements()) {
	                System.err.println("Matched multiple groups for the group with SID: " + sid);
	                return null;
	            } else {
	                return (String)searchResult.getAttributes().get("sAMAccountName").get();
	            }
	        }
	        return null;
	    }
	    
	    public String getPrimaryGroupSID(SearchResult srLdapUser) throws NamingException {
	        byte[] objectSID = (byte[])srLdapUser.getAttributes().get("objectSid").get();
	        String strPrimaryGroupID = (String)srLdapUser.getAttributes().get("primaryGroupID").get();
	        
	        String strObjectSid = decodeSID(objectSID);
	        
	        return strObjectSid.substring(0, strObjectSid.lastIndexOf('-') + 1) + strPrimaryGroupID;
	    }
	    
	    /**
	     * The binary data is in the form:
	     * byte[0] - revision level
	     * byte[1] - count of sub-authorities
	     * byte[2-7] - 48 bit authority (big-endian)
	     * and then count x 32 bit sub authorities (little-endian)
	     * 
	     * The String value is: S-Revision-Authority-SubAuthority[n]...
	     * 
	     * Based on code from here - http://forums.oracle.com/forums/thread.jspa?threadID=1155740&tstart=0
	     */
	    public static String decodeSID(byte[] sid) {
	        
	        final StringBuilder strSid = new StringBuilder("S-");

	        // get version
	        final int revision = sid[0];
	        strSid.append(Integer.toString(revision));
	        
	        //next byte is the count of sub-authorities
	        final int countSubAuths = sid[1] & 0xFF;
	        
	        //get the authority
	        long authority = 0;
	        //String rid = "";
	        for(int i = 2; i <= 7; i++) {
	           authority |= ((long)sid[i]) << (8 * (5 - (i - 2)));
	        }
	        strSid.append("-");
	        strSid.append(Long.toHexString(authority));
	        
	        //iterate all the sub-auths
	        int offset = 8;
	        int size = 4; //4 bytes for each sub auth
	        for(int j = 0; j < countSubAuths; j++) {
	            long subAuthority = 0;
	            for(int k = 0; k < size; k++) {
	                subAuthority |= (long)(sid[offset + k] & 0xFF) << (8 * k);
	            }
	            
	            strSid.append("-");
	            strSid.append(subAuthority);
	            
	            offset += size;
	        }
	        
	        return strSid.toString();    
	    }	
	
}
