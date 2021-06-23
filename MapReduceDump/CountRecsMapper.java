import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CountRecsMapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    String line = value.toString();
	/* String songs = "Somebody That I Used To Know, Call Me Maybe, We Are Young, Payphone, Lights, Glad You Came, Stronger (What Doesn't Kill You), We Found Love, Starships, 
	What Makes You Beautiful, Wild Ones, Set Fire To The Rain, Sexy And I Know It, Some Nights, Wide Awake, Good Feeling, Whistle, One More Night, Drive By, The Motto, [Thrift Shop],
	Blurred Lines, Radioactive, Harlem Shake, Can't Hold Us, Mirrors, Just Give Me A Reason, When I Was Your Man, Cruise, Roar, Locked Out Of Heaven, Ho Hey, Stay, Get Lucky,
	Royals, I Knew You Were Trouble., We Can't Stop, Wrecking Ball, Wake Me Up!, Suit & Tie, [Happy], Dark Horse, All Of Me, Fancy, Counting Stars, Talk Dirty, Rude, All About That Bass,
	Problem, Stay With Me, Timber, Pompeii, Shake It Off, Am I Wrong, Turn Down For What, The Monster, Say Something, Team, Let Her Go, Royals, [Uptown Funk (feat. Bruno Mars)], 
	Thinking Out Loud, See You Again, Trap Queen, Sugar, Shut Up And Dance, Blank Space, Watch Me, Earned It, The Hills, Cheerleader, Can't Feel My Face, Love Me Like You Do,
	Take Me To Church, Bad Blood, Lean On, Want To Want Me, Shake It Off, Where Are U Now, Fight Song, [Love Yourself], Sorry, One Dance, Work, Stressed Out, Panda, Hello, Don't Let Me Down,
	CAN'T STOP THE FEELING!, Closer, Cheap Thrills, 7 Years, Needed Me, My House, I Took A Pill In Ibiza, Work From Home, This Is What You Came For, Cake By The Ocean, Me, Myself & I, Ride,
	[Shape Of You], Despacito, That's What I Like, Humble., Something Just Like This, Bad And Boujee, Closer, Body Like A Back Road, Believer, Congratulations, Say You Won't Let Go, I'm The One,
	XO TOUR Llif3, Mask Off, Unforgettable, 24K Magic, Stay, Wild Thoughts, Black Beatles, Starboy, [God's Plan], Perfect, Meant To Be, Havana, Rockstar, Psycho, I Like It, The Middle,
	In My Feelings, Girls Like You, Nice For What, Lucid Dreams, Better Now, Finesse, Boo'd Up, New Rules, Sad!, Never Be The Same, Love Lies, No Tears Left To Cry, [Old Town Road], 
	Sunflower - Spider-Man: Into the Spider-Verse, Without Me, Bad Guy, Wow., Happier, 7 Rings, Talk, Sicko Mode, Sucker, High Hopes, Thank U, Next, Truth Hurts, Dancing With A Stranger,
	Senorita, I Don't Care, Eastside, Going Bad, Shallow, Better" */
	
	String songs2019 = "0F7FA14euOIX8KcbEturGH, 3KkXRkHbMCARz0aVfEt68P, 5p7ujcrUXASCNwRaWNHR1C, 2Fxmhks0bxGSBdJ92vM42m, 0fcq51a3gOI6gPvzc0YLsk, 2dpaYNEQHiRxtZbfNsse99, 6ocbgoVGwYJhOv1GgI9NsF, 0rTV5WefWd1J3OwIheTzxM, 2xLMifQCjDGFmkHkpNLD9h, 22vgEDb5hykfaTwLuskFGD, 1rqqCSm0Qe4I9rUvWncaom, 3e9HZxeyfWwjeyPAMmWSSQ, 3HWzoMvoF3TQfYg4UPszDq, 6Qs4SXO9dwPj5GKvVOv8Ki, 0TK2YIli7K1leLovkQiNik, 3HVWdVOQ0ZA45FuZGSfvns, 0d2iYfpKoM0QCKvcLCkBao, 2IRZnDFmlqMuOrYOLnZZyc, 2VxeLyX666F8uXCJ0dZF8B, 6zeeWid2sgw4lap2jV61PZ";    
	
	String songs2018 = "6DCZcSspjsKoFjzjrWoCdn, 0tgVpDi06FyKpA1z0VMD4v, 7iDa6hUg2VgEL1o1HjmfBn, 1rfofaqEpACxVEHIZBJe6W, 0e7ipj03S05BNilyu5bRzt, 3swc6WTsr7rl9DqQKQA55C, 58q2HKrzhC3ozto2nDdN4z, 09IStsImFySgyp0pIQdqAc, 2G7V7zsVDxg1yRsu7Ew9RJ, 6FRLCMO5TUHTexlWo8ym1W, 3CA9pLiwRIGtUBiMjbZmRw, 285pBltuF7vW8TeWk8hdRR, 7dt6x5M1jzdTEt8oCbisTK, 3Vo4wInECJQuz9BIBMOu8i, 0At2qAoaVjIwWNAqrscXli, 2ekn2ttSfGqwhhate0LSR0, 3ee8Jmje8o58CHK66QrVC2, 4eWQlBRaTjPPUlzacqEeoQ, 45Egmo7icyopuzJN0oMEdk, 2qT1uLXPVPzGgFOx4jtEuo";
	
	String songs2017 = "7qiZfU4dY1lWllzX7mPBI3, 6habFhsOp2NvshLv26DqMb, 0KKkJNfGyhkQ5aFogxQAPU, 7KXjTSCq5nL1LoYtL7XAwS, 6RUKPb4LETWmmr3iAEQktW, 4Km5HrUvYTaSUfiSGPJeQR, 7BKLCZ1jbUBVqRi2FVlTVw, 7mldq42yDuxiUNn08nvzHO, 0pqnGHJpmpxLKifKRmU6WP, 3a1lNhkSLSkpJE4MSHpDu9, 5uCax9HTNlzGybIStD3vDh, 1jYiIOC5d6soxkJP81fxq2, 7GX5flRQZVHRAGd6B4TmDO, 0VgkVdmE4gld66l8iyGjgx, 3B54sVLJ402zGa6Xm4YGNe, 6b8Be6ljOzmkOmFslEb23P, 6uBhi9gBXWjanegOb2Phh0, 45XhKYRRkyeqoW3teSOkCM, 6fujklziTHa8uoM5OQSfIo, 7MXVkk9YMctZqd1Srtv4MB";
	
	String songs2016 = "50kpGaPAhYJ3sGmk6vplg0, 09CtPGIpYB4BrO8qb1RGsF, 1zi7xx7UVEFkmKfv06H8x0, 72TFWvU3wUYdUuxejTTIzt, 3CRDbSIZ4r5MsZ0YwxuEkn, 5YEOzOojehCqxGQCcQiyR4, 4sPmO7WMQUAf45kwMOtONw, 1i1fxkWeaMmKEB4T7zqbzK, 1WkMMavIMc4JZ8cfMmxHkI, 7BKLCZ1jbUBVqRi2FVlTVw, 3S4px9f4lceWdKf0gWciFu, 5kqIPrATaCc2LqxVWzQGbk, 4pAl7FkDMNBsjykPXo91B3, 6Knv6wdA0luoMUuuoYi2i1, 1MtUq6Wp1eQ8PC6BbPCj8P, 4tCtwWceOPWzenK2HAIJSb, 0azC730Exh71aQlOt9Zj3y, 76hfruVvmfQbw0eYn1nmeC, 40YcuQysJ0KlGQTeGUosTC, 2Z8WuEywRWYTKe1NybPQEW";
	// No Can't Feel My Face and replaced with no.21 "679"
	String songs2015 = "32OlwWuMpZ6b0aN2RZOeMS, 34gCuhDGsG4bRPIf9bb02f, 2JzZzZUQj3Qff7wapcbKjc, 2d8JP84HNLKhmd6IYOoupQ, 2iuZJX9X9P0GKaE93xcPjk, 4kbj5MwxO1bq9wjT5g9HaA, 1p80LdxRV74UKvL8gnD7ky, 5RIVoVdkDLEygELLCniZFr, 2PIvq1pGrUjY007X5y1UpM, 7iTloMifzZo9ZNZKEe4V2V, 023OVLNzXhX0j7CxswUt6D, 2l8w0zZVn4AZNuzrht7MRT, 1CS7Sd1u5tWkstBhpssyjP, 273dCMFseLcVsoSWx59IoE, 1Lim1Py7xBgbAkAys3AGAG, 7oGZAicScQt96OAW4AruYy, 5xTtaWoae3wi06K5WfVUUH, 66hayvUbTotekKU3H4ta1f, 37f4ITSlgPX81ad2EvmVQr, 5NQbUaeTEOGdD6hHcre0dZ";
	//String songs = "Somebody That I Used To Know, Call Me Maybe, We Are Young, Payphone, Lights, Glad You Came, Stronger (What Doesn't Kill You), We Found Love, Starships, What Makes You Beautiful, Wild Ones, Set Fire To The Rain, Sexy And I Know It, Some Nights, Wide Awake, Good Feeling, Whistle, One More Night, Drive By, The Motto, [Thrift Shop], Blurred Lines, Radioactive, Harlem Shake, Can't Hold Us, Mirrors, Just Give Me A Reason, When I Was Your Man, Cruise, Roar, Locked Out Of Heaven, Ho Hey, Stay, Get Lucky, Royals, I Knew You Were Trouble., We Can't Stop, Wrecking Ball, Wake Me Up!, Suit & Tie, [Happy], Dark Horse, All Of Me, Fancy, Counting Stars, Talk Dirty, Rude, All About That Bass, Problem, Stay With Me, Timber, Pompeii, Shake It Off, Am I Wrong, Turn Down For What, The Monster, Say Something, Team, Let Her Go, Royals, [Uptown Funk (feat. Bruno Mars)], Thinking Out Loud, See You Again, Trap Queen, Sugar, Shut Up And Dance, Blank Space, Watch Me, Earned It, The Hills, Cheerleader, Can't Feel My Face, Love Me Like You Do, Take Me To Church, Bad Blood, Lean On, Want To Want Me, Shake It Off, Where Are U Now, Fight Song, [Love Yourself], Sorry, One Dance, Work, Stressed Out, Panda, Hello, Don't Let Me Down, CAN'T STOP THE FEELING!, Closer, Cheap Thrills, 7 Years, Needed Me, My House, I Took A Pill In Ibiza, Work From Home, This Is What You Came For, Cake By The Ocean, Me, Myself & I, Ride, [Shape Of You], Despacito, That's What I Like, Humble., Something Just Like This, Bad And Boujee, Closer, Body Like A Back Road, Believer, Congratulations, Say You Won't Let Go, I'm The One, XO TOUR Llif3, Mask Off, Unforgettable, 24K Magic, Stay, Wild Thoughts, Black Beatles, Starboy, [God's Plan], Perfect, Meant To Be, Havana, Rockstar, Psycho, I Like It, The Middle, In My Feelings, Girls Like You, Nice For What, Lucid Dreams, Better Now, Finesse, Boo'd Up, New Rules, Sad!, Never Be The Same, Love Lies, No Tears Left To Cry, [Old Town Road], Sunflower - Spider-Man: Into the Spider-Verse, Without Me, Bad Guy, Wow., Happier, 7 Rings, Talk, Sicko Mode, Sucker, High Hopes, Thank U, Next, Truth Hurts, Dancing With A Stranger, Senorita, I Don't Care, Eastside, Going Bad, Shallow, Better";
	String songs2014 = "60nZcImufyMA1MKQY3dcCH, 5jrdCoLpJSvHHorevXBATy, 3U4isOIWM3VvDubwSI3y7a, 3oiMJQAWVaxSubJ7b2VUtX, 6sy3LkhNFjJWlaeSMNwQ62, 6g6A7qNhTfUgOSH7ROOxTD, 6RtPijgfPKROxEzTHNRiDp, 5jE48hhRu8E6zBDPRSkEq7, 7vS3Y0IKjde7Xg85LWIEdP, 5Nm9ERjJZ5oyfXZTECKmRt, 3cHyrEgdyYRjgJKSOiOtcS, 4Ub8UsjWuewQrPhuepfVpd, 5xTtaWoae3wi06K5WfVUUH, 1fidCEsYlaVE3pHwKCvpFZ, 67awxiNHNyjMXhVgsHuIrs, 48RrDBpOSSl1aLVCalGl5C, 6Vc5wAMmXdKIAM7WUoEb7N, 3G6hD9B2ZHOsgf4WfNu7X1, 0JmiBCpWc1IAc0et7Xm7FL, 2dLLR6qlu5UJ5gk0dKz0h3";
	// In case two songs were similar but one was radio edit, the more popular one was chosen in this case "Get Lucky Radio Mix" was chosen over the normal one.
	String songs2013 = "3AYcyxEACnmE6d96RPubID, 0n4bITAu0Y0nigrz3MFJMb, 4G8gkOterJn0Ywt6uhqbhp, 01XFgRZfZI7oBagNf1Loml, 3bidbhpOYeV4knp8AIu8Xn, 4rHZZAmHpZrA3iH5zx8frV, 1mKXFLRA179hdOWQBwUk9e, 0nJW01T7XtvILxQgC5J7Wh, 0i5el041vd6nxrGEU8QRxy, 6F5c58TMEs1byxUstkzVeM, 3w3y8KPTfNeOKPiqUTakBh, 0W4Kpfp1w2xkY3PrV714B7, 1dEy9Pl81QopSxNsPxXQxv, 2Foc5Q5nqNiosCNqttzHof, 2dLLR6qlu5UJ5gk0dKz0h3, 6FB3v4YcR57y4tXFcdxI1E, 2y4lAQpi5VTNLu2ldeTdUH, 2vwlzO0Qp8kfEtzTsCXfyE, 4h8VwCb1MTGoLKueQ1WgbD, 6vt0I1cw1YmAIKDJvHVIM5";
	
	String songs2012 = "4wCmqSrbyCgxEXROQE6vtV, 3TGRqZ0a2l1LRblBkJoaDx, 7a86XRg84qjasly9f6bPSD, 1LmN9SSHISbtp9LoaR5ZVJ, 5aTsxlQlq0vIedDWZoqMWN, 3AGOgQzp0YcPH41u9p7dOp, 6D60klaHqbCl9ySc8VcRss, 6qn9YLKt13AGvpq9jfO8py, 1oHNvJVbFkexQc0BpQp7Y4, 4cluDES4hQEUhmXj6TXkSo, 1NpW5kyvO4XrNJ3rnfcNy3, 3CKCZ9pfwAfoMZlMncA1Nc, 0obBFrPYkSoBJbvHfUIhkv, 6t6oULCRS6hnI7rm0h5gwl, 5JLv62qFIS1DR3zGEcApRt, 2LEF1A8DOZ9wRYikWgVlZ8, 3bC1ahPIYt1btJzSSEyyrF, 4XNrMwGx1SqP01sqkGTDmo, 0KAiuUOrLTIkzkpfpn9jb9, 4Kz4RdRCceaA9VgTqBhBfa";
	
	String songs = songs2019+", "+songs2018+", "+songs2017+", "+songs2016+", "+songs2015+", "+songs2014+", "+songs2013+", "+songs2012;
	//String years = "2012,2013,2014,2015,2016,2017,2018,2019";
	
	String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
	// split on the comma only if that comma has zero, or an even number of quotes ahead of it.
	
	// 0-acousticness 1-artists 2-danceability 3-duration 4-energy 5-explicit 6-id 7-instrumentalness 8-key 9-liveness 10-loudness 11-mode 12-name 13-popularity 14-release_date
	// 15-speechniness 16-tempo 17-valence 18-year

	String ID = values[6];
	//values[0]=="acousticness" ||
	
	
	//Count all the data I filtered for
	if (songs.contains(ID)){
		String countRec = "Total records";
							
		context.write(new Text(countRec), new IntWritable(1));
	}
	/* -Count data before cleaning just comment out the above if statement and uncomment this below
	String countRec = "Total records";
	context.write(new Text(countRec), new IntWritable(1));
	*/
  }
}
