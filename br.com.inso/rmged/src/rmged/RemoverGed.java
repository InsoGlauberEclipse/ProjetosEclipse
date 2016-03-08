package rmged;

import java.io.File;

public class RemoverGed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if (args.length > 0)
		{
			File arquivo = new File(args[0]);
			
			// Verificar se o arquivo existe antes de exclui-lo.
			
			if (arquivo.exists())   
			{
				arquivo.delete();
			}
		}

	}

}
