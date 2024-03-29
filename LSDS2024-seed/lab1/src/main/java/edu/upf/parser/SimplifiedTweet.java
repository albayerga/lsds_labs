package edu.upf.parser;

import java.util.Optional;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

public class SimplifiedTweet {

  // All classes use the same instance
  private static JsonParser parser = new JsonParser();
  private static Gson gson = new Gson();


  private final long tweetId;			  // the id of the tweet ('id')
  private final String text;  		      // the content of the tweet ('text')
  private final long userId;			  // the user id ('user->id')
  private final String userName;		  // the user name ('user'->'name')
  private final String language;          // the language of a tweet ('lang')
  private final long timestampMs;		  // seconduserIds from epoch ('timestamp_ms')

  public SimplifiedTweet(long tweetId, String text, long userId, String userName,
                         String language, long timestampMs)
  {

    this.tweetId = tweetId;
    this.text = text;
    this.userId = userId;
    this.userName = userName;
    this.language = language;
    this.timestampMs = timestampMs;

  }


  /**
   * Returns a {@link SimplifiedTweet} from a JSON String.
   * If parsing fails, for any reason, return an {@link Optional#empty()}
   *
   * @param jsonStr
   * @return an {@link Optional} of a {@link SimplifiedTweet}
   */
  public static Optional<SimplifiedTweet> fromJson(String jsonStr)
  {
    try
    {
      // Parse JSON string using JsonParser
      JsonObject jsonObject = parser.parseString(jsonStr).getAsJsonObject();

      // Convert JsonObject to SimplifiedTweet using Gson
      SimplifiedTweet simplifiedTweet = gson.fromJson(jsonObject, SimplifiedTweet.class);

      return Optional.ofNullable(simplifiedTweet);
    }
    catch (JsonParseException | IllegalStateException e)
    {
      return Optional.empty();
    }
  }


  @Override
  public String toString()
  {
    return "";
  }
}
