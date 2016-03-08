import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;


public class IntegracaoLdap {
	
	private String urlldap;
	private String cn;
	private String ou;
	private String dc;
	
	private int errorcode;
	private String errormessage;
	
	private Hashtable<String, String> env;
	
	
	
	

	public IntegracaoLdap()
	{
		errorcode = 0;
		errormessage = "";
		
		env = new Hashtable<String, String>(11);
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
	}

	public IntegracaoLdap(String urlldap, String cn, String ou, String dc) {
		super();
		this.urlldap = urlldap;
		this.cn = cn;
		this.ou = ou;
		this.dc = dc;
	}
	
	
	public boolean IsValidUser(String login, String passwd)
	{
		
		if (! Valida())
		{
			return false;
		}
	    
		// "cn=Pedrinho,ou=Users,dc=insofake,dc=com,dc=br"
		String chamada = "cn="+login +","+ ou+"," + dc ;
    		
		env.put(Context.PROVIDER_URL, urlldap);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, chamada);
		env.put(Context.SECURITY_CREDENTIALS, passwd);

		try 
		{			
		    DirContext ctx = new InitialDirContext(env);
		    ctx.close();
		    return true;
		}
         catch (NamingException e) 
		{
	           return false;
	    }
	}
	
	
	
	private boolean Valida()
	{
		if (null == urlldap || urlldap.isEmpty())
		{
			errorcode = -1;
			errormessage = "Url LDAP is invalid.";
			return false;
		}
		
		if (null == cn || cn.isEmpty())
		{
			errorcode = -2;
			errormessage = "CN is invalid.";
			return false;
		}
		
		if (null == ou || ou.isEmpty())
		{
			errorcode = -3;
			errormessage = "OU is invalid.";
			return false;
		}

		if (null == dc || dc.isEmpty())
		{
			errorcode = -4;
			errormessage = "DC is invalid.";
			return false;
		}		
		return true;
		
	}

	// Gets & Sets
	
	/**
	 * @return the urlldap
	 */
	public String getUrlldap() {
		return urlldap;
	}

	/**
	 * @param urlldap the urlldap to set
	 */
	public void setUrlldap(String urlldap) {
		this.urlldap = urlldap;
	}

	/**
	 * @return the cn
	 */
	public String getCn() {
		return cn;
	}

	/**
	 * @param cn the cn to set
	 */
	public void setCn(String cn) {
		this.cn = cn;
	}

	/**
	 * @return the ou
	 */
	public String getOu() {
		return ou;
	}

	/**
	 * @param ou the ou to set
	 */
	public void setOu(String ou) {
		this.ou = ou;
	}

	/**
	 * @return the dc
	 */
	public String getDc() {
		return dc;
	}

	/**
	 * @param dc the dc to set
	 */
	public void setDc(String dc) {
		this.dc = dc;
	}

	/**
	 * @return the errorcode
	 */
	public int getErrorcode() {
		return errorcode;
	}

	/**
	 * @return the errormessage
	 */
	public String getErrormessage() {
		return errormessage;
	}
	

	
	
	
	

}
