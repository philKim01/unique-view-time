# unique-view-time
MVP: 2 classes (ViewFragment & UniqueViewTime) UniqueViewTime contains a method that calculates the UVT given an array of View Fragments Junit testing for the UVT calculating method

08/20/2021 Update I turned it into a database that holds 2 tables currently (Video and ViewFragment) you can post view fragments if you supply a video ID. You can then use a get route by supplying said video ID in order to recieve the UVT for the video. I took out the junit testing because I didnt look into junit testing routes. Instead, I opted to just manually test the routes using Insomnia. There are a few bugs that I realize exists such as if for some reason someone posted a view fragment with an end time thats less than the start time then it would return a negative number and reduce the UVT. I feel like that would be taken care in the front end or there would be some form of security that wouldnt let users manually post view fragments.

Instructions to run:

This very well might have been bad practice but I took the target folder off of my .gitignore file. To run the program you should now be able to cd into the target folder and run the unique-view-time jar file.
To call the api's I just used postman/insomnia by sending requests to http://localhost:8080/api/
To get a video's UTV you can send a GET request to http://localhost:8080/api/video/:videoId
You can create a Video by sending a POST request to http://localhost:8080/api/video/ with a json object containing a "url" key.
You can add video fragments to a Video by sending a POST request to http://localhost:8080/api/viewfragments/:videoId with a json object with a "startTime" and "endTime" key that holds a int value that would be the time in milliseconds. The "videoId" path variable would be the id of the video that you want to add the view fragment to.

I apologize if this readme is written incorrectly. I wasnt sure what goes into a readme file.
