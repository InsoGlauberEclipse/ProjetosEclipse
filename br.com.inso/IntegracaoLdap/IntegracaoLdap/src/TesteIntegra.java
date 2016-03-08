
public class TesteIntegra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		IntegracaoLdap integra = new IntegracaoLdap();
		
		integra.setUrlldap("ldap://192.168.0.145:389");
		integra.setCn("admin");
		integra.setDc("dc=insofake,dc=com,dc=br");
		integra.setOu("ou=Users");
		
		if (integra.IsValidUser("Pedrinho", "Pedro01"))
		{
			System.out.println("O usuario Pedrinho eh valido." );
		}
		else
		{
			System.out.println("O usuario Pedrinho nao eh valido." );
		}

		if (integra.IsValidUser("Juquinha", "Juca01"))
		{
			System.out.println("O usuario Juquinha eh valido." );
		}
		else
		{
			System.out.println("O usuario Juquinha nao eh valido." );
		}
		
		if (integra.IsValidUser("Glauber", "Glauber"))
		{
			System.out.println("O usuario Glauber eh valido." );
		}
		else
		{
			System.out.println("O usuario Glauber nao eh valido." );
		}
		
		
		
	}

}
