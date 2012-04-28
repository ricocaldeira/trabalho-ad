package cliente;


import java.io.*;
import java.net.*;
import java.util.Scanner;

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
			
			String resposta = "";
			String entrada = null;
			
			System.out.println("Digite sua op��o: ");
			sentence = inFromUser.readLine();
			
			if (sentence.equalsIgnoreCase("a")) {
				System.out.println("Digite sua hashtag: ");
				entrada = inFromUser.readLine();
				
				outToServer.writeByte(1);
				outToServer.writeBytes(entrada + "\n");
				do {
					System.out.println(resposta = inFromServer.readLine());
					System.out.println();
				} while(resposta!="\\\\q");
			} else if (sentence.equalsIgnoreCase("d")) {
				
			} else {
				System.out.println("Comando n�o reconhecido!" + '\n');
			}
		}
		//clientSocket.close();
	}
}
