package cliente;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


public class TwitterImpl implements TwitterInterface {

	@Override
	public QueryResult pesquisaTweets(String hashtag) throws TwitterException {
		// TODO Auto-generated method stub
		Twitter twitter = new TwitterFactory().getInstance();
		Query query = new Query(hashtag);
		QueryResult result;
		result = twitter.search(query);
		return result;
	}

}
