package cliente;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterClient {

	public static void main(String[] args) {
		Twitter twitter = new TwitterFactory().getInstance();
		String pesquisa  = "#asminapira";
		Query query = new Query(pesquisa);
		QueryResult result;
		System.out.println("Pesquisa " + pesquisa);
		try {
			result = twitter.search(query);
			for (Tweet tweet : result.getTweets()) {
				System.out.println(tweet.getFromUser() + "@" + 	tweet.getGeoLocation() + " :" + tweet.getText());
				System.out.println();
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		System.out.println("---");
	}
}
