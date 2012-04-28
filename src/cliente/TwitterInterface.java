package cliente;
import twitter4j.QueryResult;
import twitter4j.TwitterException;


public interface TwitterInterface {
	
	QueryResult pesquisaTweets(String hashtag) throws TwitterException;

}
