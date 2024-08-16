package org.example;

import io.restassured.response.Response;

import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class SpotifyAutomation
{
   String Token = "BQAycGGE7YReU7m8WH__lcTQODOnm3dV1fFh2_W_EPTuJeAvzRvKAMU_hrZAbpzEV4_lTR8ARWsUHfYnmhSKcQos-8RkpxOdde2BAlg-z9Q51SN6F4u_bQ-dQk4SpOjM22DHKqJJY-nDuVStJpU0zmDCRpJtHkH-1-Pa23LM-fXtoYOXp-lKyQssWL7Na7nwKpxvRrGqpcugwpYQcjRSlmZklUEEwGmyo4l9jFiARsjnkl--Ibyd2L6nTmKoMj62WbMnLGw4c8DD4fRB11M1brxBhwqZb1ITiU5OempZvVspgdT_lr8sMx29oOihJr_P4-IckTJQFYjDwqI0u4s";
  //USERS
 String userid;
 String snapshotId = null;

    @Test
    public void Get_Current_User_Profile()
   {
      Response response = given()
       .header("accept","*/*")
           .header("Content-Type","application/json")
              .header("Authorization", "Bearer " +Token)
              .when()
              .get("https://api.spotify.com/v1/me");
      response.prettyPrint();
      response.then().statusCode(200);
   }

   @Test
   public void Get_users_top_items()
   {
      Response response = given()
              .header("accept","*/*")
              .header("Content-Type","application/json")
              .header("Authorization", "Bearer " +Token)
              .when()
              .get("https://api.spotify.com/v1/me/top/artists");
      response.prettyPrint();
      response.then().statusCode(200);
   }

   @Test
   public void Get_users_profile()
   {
      Response response = given()
              .header("accept","*/*")
              .header("Content-Type","application/json")
              .header("Authorization", "Bearer " +Token)
              .when()
              .get("https://api.spotify.com/v1/users/6ynklsrp7kicqsrraoets7h4e");
      response.prettyPrint();
      response.then().statusCode(200);
   }

   @Test (priority =1)
   public void follow_playlist()
   {
      Response response = given()
              .header("accept","*/*")
              .header("Content-Type","application/json")
              .header("Authorization", "Bearer " +Token)
              .body("{\n" +
                      "    \"public\": false\n" +
                      "}")
              .when()
              .put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
      response.prettyPrint();
      response.then().statusCode(200);
   }

   @Test (priority =2)
   public void unfollow_playlist()
   {
      Response response = given()
              .header("accept","*/*")
              .header("Content-Type","application/json")
              .header("Authorization", "Bearer " +Token)
              .when()
              .delete("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
      response.prettyPrint();
      response.then().statusCode(200);
   }
   @Test
   public void Get_followed_artist()
   {
      Response response = given()
              .header("accept","*/*")
              .header("Content-Type","application/json")
              .header("Authorization", "Bearer " +Token)
              .when()
              .get("https://api.spotify.com/v1/me/following?type=artist");
      response.prettyPrint();
      response.then().statusCode(200);
   }
//Follow Artists or Users
   @Test (priority =1)
        public void follow_artists()
{
   Response response = given()
           .header("accept","*/*")
           .header("Content-Type","application/json")
           .header("Authorization", "Bearer " +Token)
           .body("{\n" +
                   "    \"ids\": [\n" +
                   "        \"4E5oyNFcB3uXLkLdjYmP9Z\"\n" +
                   "    ]\n" +
                   "}")
           .when()
           .put("https://api.spotify.com/v1/me/following?type=artist&ids=4E5oyNFcB3uXLkLdjYmP9Z");
   response.prettyPrint();
   response.then().statusCode(204);
}

   @Test (priority =2)
   public void unfollow_artists()
   {
      Response response = given()
              .header("accept","*/*")
              .header("Content-Type","application/json")
              .header("Authorization", "Bearer " +Token)
              .body("{\n" +
                      "    \"ids\": [\n" +
                      "        \"1vCWHaC5f2uS3yhpwWbIA6\"\n" +
                      "    ]\n" +
                      "}")
              .when()
              .delete("https://api.spotify.com/v1/me/following?type=artist&ids=1vCWHaC5f2uS3yhpwWbIA6");
      response.prettyPrint();
      response.then().statusCode(204);
   }

   @Test
   public void check_if_users_follow_artist()
   {
      Response response = given()
              .header("accept","*/*")
              .header("Content-Type","application/json")
              .header("Authorization", "Bearer " +Token)
              .when()
              .get("https://api.spotify.com/v1/me/following/contains?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx");
      response.prettyPrint();
      response.then().statusCode(200);
   }

   @Test
   public void check_if_current_user_follow_playlist()
   {
      Response response = given()
              .header("accept","*/*")
              .header("Content-Type","application/json")
              .header("Authorization", "Bearer " +Token)
              .when()
              .get("https://api.spotify.com/v1/playlists/1jqTP9lInzS2rLR94HDGot/followers/contains");
      response.prettyPrint();
      response.then().statusCode(200);
   }
//TRACKS
@Test
public void get_track()
{
   Response response = given()
           .header("accept","*/*")
           .header("Content-Type","application/json")
           .header("Authorization", "Bearer " +Token)
           .when()
           .get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl");
   response.prettyPrint();
   response.then().statusCode(200);
}
   @Test
   public void get_several_track()
   {
      Response response = given()
              .header("accept","*/*")
              .header("Content-Type","application/json")
              .header("Authorization", "Bearer " +Token)
              .when()
              .get("https://api.spotify.com/v1/tracks?ids=01npLGQTbZBIHVRcXJbLzR");
      response.prettyPrint();
      response.then().statusCode(200); //400
       Assert.assertEquals(response.statusCode(),200);
   }

    @Test
    public void get_users_saved_tracks()
    {
        Response response = given()
                .header("accept","*/*")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .when()
                .get("https://api.spotify.com/v1/me/tracks");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test (priority =1)
    public void save_tracks_for_current_user()
    {
        Response response = given()

                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"1cWLSVxcigTAH7EEQjHkpR\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/me/tracks?ids=1cWLSVxcigTAH7EEQjHkpR");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test (priority =2)
    public void remove_users_save_tracks()
    {
        Response response = given()

                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"3QJsSWa0Xo8MfaRn1gr4Be\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .delete("https://api.spotify.com/v1/me/tracks?ids=3QJsSWa0Xo8MfaRn1gr4Be");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void check_users_saved_tracks()
    {
        Response response = given()
                .header("accept","*/*")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .when()
                .get("https://api.spotify.com/v1/me/tracks/contains?ids=74VsWsXgCd3hZSSQiAzocv");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void get_several_tracks_audio_features()
    {
        Response response = given()
                .header("accept","*/*")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .when()
                .get("https://api.spotify.com/v1/audio-features?ids=0d3AAUuuQ3Br9J1krTWJnd");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void get_tracks_audio_features()
    {
        Response response = given()
                .header("accept","*/*")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .when()
                .get("https://api.spotify.com/v1/audio-features/6XFGKGOjlwXWm12DHV1CWc");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void get_tracks_audio_analysis()
    {
        Response response = given()
                .header("accept","*/*")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .when()
                .get("https://api.spotify.com/v1/audio-analysis/6XFGKGOjlwXWm12DHV1CWc");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void get_recommendations()
    {
        Response response = given()
                .header("accept","*/*")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .when()
                .get("https://api.spotify.com/v1/recommendations?seed_artists=4NHQUGzhtTLFvgF5SZesLK&seed_genres=classical%2Ccountry&seed_tracks=0c6xIDDpzE81m2q797ordA");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    //Shows
    @Test
    public void get_show()
    {
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .when()
                .get("https://api.spotify.com/v1/shows/6ZcvVBPQ2ToLXEWVbaw59P ");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void get_several_shows()
    {
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .when()
                .get("https://api.spotify.com/v1/shows?ids=6ZcvVBPQ2ToLXEWVbaw59P%2C2vhxApfLLtI8yCd7hqPokR");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void get_show_episodes()
    {
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .when()
                .get("https://api.spotify.com/v1/shows/3ptiw7nOKh5vsMoar79YGc/episodes");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void get_users_saved_shows()
    {
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .when()
                .get("https://api.spotify.com/v1/shows/3ptiw7nOKh5vsMoar79YGc/episodes");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test (priority = 1)
    public void save_shows_for_current_user()
    {
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .when()
                .put("https://api.spotify.com/v1/me/shows?ids=2vhxApfLLtI8yCd7hqPokR");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test (priority = 2)
    public void remove_users_saved_shows()
    {
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .when()
                .delete("https://api.spotify.com/v1/me/shows?ids=2vhxApfLLtI8yCd7hqPokR");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void check_users_saved_shows()
    {
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " +Token)
                .when()
                .get("https://api.spotify.com/v1/me/shows/contains?ids=3ptiw7nOKh5vsMoar79YGc");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    //SEARCH
    @Test
    public void searchForItem(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+Token)
                .when()
                .get("https://api.spotify.com/v1/search?q=remaster%2520track%3ADoxy%2520artist%3AMiles%2520Davis&type=album");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    //PLAYLIST
    @Test (priority = 1)
    public void getPlaylist(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " +Token)
                .when()
                .get("https://api.spotify.com/v1/playlists/1jqTP9lInzS2rLR94HDGot");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void changePlaylistDetails(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .body("{\n" +
                        "    \"name\": \"Updated Playlist Name\",\n" +
                        "    \"description\": \"hello updation done\",\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/1jqTP9lInzS2rLR94HDGot");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void getPlaylistItems(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+Token)
                .when()
                .get("https://api.spotify.com/v1/playlists/1jqTP9lInzS2rLR94HDGot/tracks");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void updatePlaylistItems(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .body("{\n" +
                        "    \"range_start\": 1,\n" +
                        "    \"insert_before\": 3,\n" +
                        "    \"range_length\": 2\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/1jqTP9lInzS2rLR94HDGot/tracks");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test (priority = 1)
    public void addItemsToPlaylist(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .body("{\n" +
                        "    \"uris\": [\n" +
                        "        \"spotify:track:3qkFIjYRInFasy2jeDZPgm\"\n" +
                        "    ],\n" +
                        "    \"position\": 0\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/playlists/1jqTP9lInzS2rLR94HDGot/tracks");
        response.prettyPrint();
        snapshotId = response.path("snapshot_id");
        response.then().statusCode(201);
        Assert.assertEquals(response.statusCode(),201);
    }
    @Test (priority = 2)
    public void removePlaylistItems(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .body("{\n" +
                        "    \"tracks\": [\n" +
                        "        {\n" +
                        "            \"uri\": \"spotify:track:3qkFIjYRInFasy2jeDZPgm\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"snapshot_id\": \""+snapshotId+"\"\n" +
                        "}")
                .when()
                .delete("https://api.spotify.com/v1/playlists/1jqTP9lInzS2rLR94HDGot/tracks");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void getCurrentUsersPlaylist(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .when()
                .get("https://api.spotify.com/v1/me/playlists");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void getUsersPlaylist(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .when()
                .get("https://api.spotify.com/v1/users/6ynklsrp7kicqsrraoets7h4e/playlists");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void createPlaylist(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .body("{\n" +
                        "    \"name\": \"NewPlaylist\",\n" +
                        "    \"description\": \"New playlist description\",\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/6ynklsrp7kicqsrraoets7h4e/playlists");
        response.prettyPrint();
        response.then().statusCode(201);
        Assert.assertEquals(response.statusCode(),201);
    }
    @Test
    public void getFeaturedPlaylist(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .when()
                .get("https://api.spotify.com/v1/browse/featured-playlists");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void getCategoryPlaylist(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .when()
                .get("https://api.spotify.com/v1/browse/categories/dinner/playlists");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void getPlaylistCoverImage(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .when()
                .get("https://api.spotify.com/v1/playlists/55iZeuVm3P7LWwEOjK02jm/images");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
//    @Test
//    public void addCustomPlaylistCoverImage(){
//        Response response = given()
//                .header("accept","application/json")
//                .header("Content-Type","application/json")
//                .header("Authorization","Bearer "+ Token)
//                .when()
//                .put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/images");
//        response.prettyPrint();
//        response.then().statusCode(200);
//        Assert.assertEquals(response.statusCode(),200);
//    }
//MARKET
@Test
public void getAvailableMarkets(){
    Response response = given()
            .header("accept","application/json")
            .header("Content-Type","application/json")
            .header("Authorization","Bearer "+ Token)
            .when()
            .get("https://api.spotify.com/v1/markets");
    response.prettyPrint();
    response.then().statusCode(200);
    Assert.assertEquals(response.statusCode(),200);
}
//GENRES
@Test
public void getAvailableGenreSeeds(){
    Response response = given()
            .header("accept","application/json")
            .header("Content-Type","application/json")
            .header("Authorization","Bearer "+ Token)
            .when()
            .get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
    response.prettyPrint();
    response.then().statusCode(200);
    Assert.assertEquals(response.statusCode(),200);
}
//EPISODES

    @Test
    public void getEpisodes(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .when()
                .get("https://api.spotify.com/v1/episodes/4UfTmqAxWHMBW01jM5auG3");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void getSeveralEpisodes(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .when()
                .get("https://api.spotify.com/v1/episodes?ids=799kwCyVsKDOOfDtbpVOQQ");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void getUserSavedEpisodes(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .when()
                .get("https://api.spotify.com/v1/me/episodes");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test (priority = 1)
    public void saveEpisodeForCurrentUser(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"4v1mdR7dvna5InxcgC4hix\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/me/episodes?ids=4v1mdR7dvna5InxcgC4hix");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test (priority = 2)
    public void removeUserSavedEpisodes(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"4v1mdR7dvna5InxcgC4hix\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .delete("https://api.spotify.com/v1/me/episodes?ids=4v1mdR7dvna5InxcgC4hix");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void checkUserSavedEpisodes(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .when()
                .get("https://api.spotify.com/v1/me/episodes/contains?ids=4v1mdR7dvna5InxcgC4hix");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    //CHAPTER
//    @Test
//    public void getAChapter() //premium subsciption required
//    {
//        Response response = given()
//                .header("accept","application/json")
//                .header("Content-Type","application/json")
//                .header("Authorization","Bearer "+ Token)
//                .when()
//                .get("https://api.spotify.com/v1/chapters/0D5wENdkdwbqlrHoaJ9g29");
//        response.prettyPrint();
//        response.then().statusCode(200);
//     //   Assert.assertEquals(response.statusCode(),200);
//    }
//    @Test
//    public void getSeveralChapter() //premium subsciption required
//     {
//        Response response = given()
//                .header("accept","application/json")
//                .header("Content-Type","application/json")
//                .header("Authorization","Bearer "+ Token)
//                .when()
//                .get("https://api.spotify.com/v1/chapters?ids=0IsXVP0JmcB2adSE338GkK%2C3ZXb8FKZGU0EHALYX6uCzU%2C0D5wENdkdwbqlrHoaJ9g29");
//        response.prettyPrint();
//        response.then().statusCode(200);
//        Assert.assertEquals(response.statusCode(),200);
//    }
    //CATEGORIES

    @Test
    public void getSeveralBrowseCategories(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .when()
                .get("https://api.spotify.com/v1/browse/categories");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void getSingleBrowseCategories(){
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+ Token)
                .when()
                .get("https://api.spotify.com/v1/browse/categories/dinner");
        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }
}
