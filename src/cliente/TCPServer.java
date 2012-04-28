package cliente;


import java.io.*;
import java.net.*;

import twitter4j.QueryResult;
import twitter4j.Tweet;

class TCPServer {

	public static void main(String argv[]) throws Exception {
		int clientSentence;

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

				clientSentence = inFromClient.read();
				String hashtag = inFromClient.readLine();
				
				QueryResult result;
				TwitterImpl t = new TwitterImpl();
				String resultadoCliente = "";
				
				switch (clientSentence) {
				case 1:
					result = t.pesquisaTweets(hashtag);
					for (Tweet tweet : result.getTweets()) {
						outToClient.writeBytes("@" + tweet.getFromUser() + " " + tweet.getGeoLocation() + ": " + tweet.getText() + "\n");
					}
					outToClient.writeBytes("\\\\q");
					break;

				default:
					break;
				}

			} while(!(clientSentence == -1));

			connectionSocket.close();

		}
	}
}
