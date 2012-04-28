package cliente;


import java.io.*;
import java.net.*;

import twitter4j.QueryResult;
import twitter4j.Tweet;

class TCPServer {

	public static void main(String argv[]) throws Exception {
		String clientSentence;
		String capitalizedSentence;

		int porta = 6789;
		ServerSocket welcomeSocket = new ServerSocket(porta);

		System.out.println("Esperando conexoes na porta " + porta);

		int numConn = 1;

		while (true) {

			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("Conexao [" + numConn++ + "] aceita....");

			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream()));

			DataOutputStream outToClient = new DataOutputStream(
					connectionSocket.getOutputStream());


			do {

				clientSentence = inFromClient.readLine();
				int clientSentenceInt = Integer.parseInt(clientSentence);	// Convertendo String do Client para Inteiro
				
				QueryResult result;
				TwitterImpl t = new TwitterImpl();
				String resultadoCliente = "";
				
				switch (clientSentenceInt) {
				case 1:
					result = t.pesquisaTweets("#asminapira");
					for (Tweet tweet : result.getTweets()) {
						outToClient.writeBytes(tweet.getFromUser() + "@" + tweet.getGeoLocation() + " :" + tweet.getText() + "\n");
					}
					outToClient.writeBytes("\\\\q");
					break;

				default:
					break;
				}

			} while(!clientSentence.equalsIgnoreCase("x"));

			connectionSocket.close();

		}
	}
}
