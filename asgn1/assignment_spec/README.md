#Yik My Professor (working title)

##People in class 9/16/14
- Emily Crowe
- Michael Schoenfield
- MingYang Lu

##Overview

This application will be an open, anonymous Twitter/Yik Yak hybrid for campus-specific professor and class commentary by students. When a user first opens the application, he or she is assigned a unique ID, not for personal use or public identification, but rather for administrative moderation of posts and upvotes/downvotes. 

A post will take the form of a short- to medium-length comment regarding a specific professor, TA, or class. After the post is sent to a central database and disseminated to other phones, it will be displayed in a Reddit/Yik Yak style, and other users may upvote, downvote, or flag inappropriate posts for review.  The app need not completely live, but rather update every hour, half-hour, etc. 

##User Stories for 9/25/14
1. As a contributor, I want to be able to post comments regarding a Vandy professor or class and have them stored on my phone so that I can see my own posts while the app is running.
2. As a contributor, I want my posts to be anonymous and disappear when the app is closed so that I don't have to see old rants.
3. As a contributor, I want to be able to have a form field to enter a professor's name so that I can associate my post with a professor and/or class when I create it.
6. As a contributor, I want to be able to see all my posts on one screen.
10. As a user, I want to be able to see the date and time a post was made.

##User Stories
1. As a contributor, I want to be able to post comments (anecdotes/raves/complaints/reviews) regarding a Vandy professor or class.
2. As a contributor, I want my posts to be anonymous.
3. As a contributor, I want to be able to associate my post with a professor and/or class.
4. As a contributor, I want to be able to add professors/classes to a database.
5. As a contributor, I want to be able to get push notifications when someone upvotes or downvotes my post.
6. As a contributor, I want to be able to see all my past posts in one place.
7. (optional) As a contributor, I would like to be able to post GIFs/memes in addition to text. 
8. As a user, I want to be able to upvote or downvote posts.
9. As a user, I don't want to see posts with ratings (# of upvotes - # of downvotes) below a certain threshold.
10. As a user, I want to be able to see the date and time a post was made.
11. (optional) As a user, I want to be able to flag inappropriate or non-salient posts for review/removal, and as a moderator of the app, I want to be able to hide posts which have been flagged for review.
12. As a user, I want to be able to search for specific professors/classes and filter by department/class/professor/etc. 
13. As a user, when I open the app, I want to be able to view the votes according to most recent, trending, and top posts per month/week/day/all-time.
14. As a user, I want users to only be able to upvote or downvote a post once.

##Possibly Heplful Information
- Check out https://parse.com/ for a possible mobile-cloud platform.

##Evaluation Rubrics
These rubrics comprise 130 points plus 25 optional points for the completion of extra features.

1. (20 pts) - As a contributor, I want to be able to post comments (anecdotes/raves/complaints/reviews) regarding a Vandy professor or class. Evaluation process:
    * Open the application (5 pts). Write a post (5 pts). Submit the post and be able to view on local device (5 pts). Be able to view the comment on other devices (10 pts).

2. (10 pts) - As a contributor, I want my posts to be anonymous. Evaluation process: 
    * Note: not for personal use, but rather keeping track of posts for push notifications and moderation.
    * Open the application and make a post. No login or identifying information should be asked of the user.

3. (10 pts) - As a contributor, I want to be able to associate my post with a professor and/or class. Evaluation process:
    * Open the application and write a post. Before submitting the post, select a professor and/or class "tag" (5 pts). After posting, these "tags" should be visible in association with the post (5 pts). Also may want to consider comments about departments in general, but this is an extra feature.

4. (20 pts) - As a contributor, I want to be able to add professors/classes to a database. Evaluation process: 
    * Open the application and write a post. Add a new professor and class to the database (5 pts). This addition should be designed to prevent duplicates (e.g. field for department, field for class number, etc.) (5 pts). Tag post with the newly added professor and class. After making the post, confirm that these tags are associated with it and visible on device (5 pts). Make a post on a different device using the tags to confirm the addition is available for use on other devices (5 pts).

5. (5 pts) - As a contributor, I want to be able to get push notifications when someone upvotes or downvotes my post. Evaluation process: 
    * Open the application on device A. Make a post. On device B, upvote or downvote the post. Device A should get a push notification regarding that upvote or downvote.

6. (5 pts) - As a contributor, I want to be able to see all my past posts in one place. Evaluation process: 
    * Open the application. Navigate to page which shows all past posts made by this device.

7. (15 _optional_ pts) - As a contributor, I would like to be able to post GIFs/memes in addition to text. Evaluation process:
    * Open the application write a post, attach an image and submit. GIFs should animate on the timeline of all posts (10 pts), memes should be visible in association with the post (5 pts).
8. (10 pts) - As a user, when I open the app, I want to be able to view posts according to most recent, trending, and top posts per month/week/day/all time. Evaluation process: 
    * Open the application. View posts made by all users according to at least the most recent posts and top posts of all time. 

9. (5 pts) - As a user, I want to be able to see the date and time a post was made. Evaluation process: 
    * Open the application and be able to see the date and time of a post by the current device (2 pts) and by others (3 pts).

10. (10 _optional_ pts) - As a user, I want to be able to flag inappropriate or non-salient posts for review/removal and as a moderator of the app, I want to be able to hide posts which have been flagged for review. Evaluation process:
    * Open the application and flag a post for review (4 pts). Should be able to undo flagging (1 pt). 
    * Open the app as a moderator. View all flagged posts and approve or hide/delete them. (5 pts)

11. (10 pts) - As a user, I want to be able to search for specific professors/classes and filter by department/class/professor/etc.  Evaluation process: 
    * Open the application and use a search bar and/or filter functionality to limit visible posts to department, class, professor, college (A&S, VUSE, Blair, Peabody).

12. (15 pts) - As a user, I want to be able to upvote or downvote posts. Evaluation process: 
    * Open the app. Upvote a post and downvote a different post (5 pts). Each action should update the total vote count on the device (5 pts) and on other devices (5 pts). 

13. (10 pts) - As a user, I don't want to see posts with ratings (# of upvotes - # of downvotes) below a certain threshold. Evaluation process: 
    * Open the app and downvote a post. If the post's votes are below a set threshold, the post should not be visible on the device (5 pts) and on other devices (5 pts). This threshold should be able to be easily changed on a global scale for convenience as the user base grows and fluctuates.

14. (10 pts) - As a user or moderator, I want users to only be able to upvote or downvote a post once.
    * Open the application and upvote a post. Trying to upvote again will remove the vote. A downvote will switch vote from upvote to downvote. 
