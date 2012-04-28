package cliente;


import java.io.*;
import java.net.*;

class TCPClient {

	public static void main(String argv[]) throws Exception {
		String sentence;
		String modifiedSentence;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));

		int porta = 6789;
		String servidor = "localhost";

		System.out.println("Conectando ao servidor " + servidor + ":" + porta);

		Socket clientSocket = new Socket(servidor, porta);

		DataOutputStream outToServer = new DataOutputStream(clientSocket
				.getOutputStream());

		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		
		while(true) {
			
			System.out.println("Digite sua opção: ");
			sentence = inFromUser.readLine();
			String resposta = "";
			
			if (sentence.equalsIgnoreCase("a")) {
				outToServer.writeBytes("1" + '\n');
				do {
					System.out.println(resposta = inFromServer.readLine());
					System.out.println();
				} while(resposta!="\\\\q");
			} else if (sentence.equalsIgnoreCase("d")) {
				
			} else {
				System.out.println("Comando não reconhecido!" + '\n');
			}

			
			
		}

		

		//clientSocket.close();

	}
}
