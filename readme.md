Students Name:   
Na Luo  
Eddie Tsai

### Adjustment
1. We split the previous ReadFile class and store the data in a seperated DataSet class, and we change ReadFile to an interface, which is implemented by other classes. In this case, we can read different format files by only changing the classes that implement ReadFile interface. If we did this in m2, it will be easy for us to read different format files in m3.
2. We add an Predictor interface, and there are several classes that use different predict ways implementing this interface. So user can choose the predict way they prefer, and it will be easy to change the code if we want to add new predict way. If we did this in m2, we can add BaselinePredictor more easily.
3. We add a CosineSimilarity class, which computes the similarity between users by using Cosine Similarity. Since we have the RelationFomula interface in m2, it is easy for us to add this class.
4. We also implement **factory design pattern** and use Generator method, which is very helpful.
In a word, design is very important for programming. Good design will help us change the code easily and make the code more reusable.

---
### Design
In this project, we've implemented the following classes:
1. **Item**: implements the Item object, which records the name, ID and user's rating for the Item. (We can add more attributes for this item if needed in the future, like genre)
2. **User**: implements the User object, which contains the ID of an user and the user's rating for the items.
3. **ReadMovie**: reads in a file and store the data. The file should has the same format as "rating.dat".
4. **ReadBook**: reads in a file and store the data. The file should has the same format as "BX-Book-Ratings.csv".
5. **ReadSmallMovie**: reads in a file and store the data. The file should has the same format as "ratings.csv".
6. **DataSet**: which stores data reading from files and provides data for other classes.
7. **CosineSimilarity**: calculates the similarity between users according to the Cosine Similarity, and this class implements from RelationFormula interface.
8. **Pearson**: calculates the similarity between users according to the user's rating for Items, and this class implements from RelationFormula interface.
9. **Neighborhood**: finds the neighbors for a given user according to a threshold for similarity.
10. **CFPredictor**: predicts the user's preference for an item by using Collaborative Filtering.
11. **BaselinePredictor**: predicts the user's preference for an item by using Baseline Predictor.
12. **Recommender**: generates the recommendation list for an user.
13. **Main**: asks users for an input, and print the predict results according to user's input.

In this project, we've implemented an interface:
1. **ReadFile**: we can implement the interface to read different format files.
2. **RelationFormula**: we can implement the interface to calculate the similarity between two users, but the way we calculate the similarity can be different. 
3. **Predictor**: we can implement the interface to predict the preference in different way, and user can change the way they want to use.


---
### Program Instructions ###
* User can go to Main.java, and execute the main method. 
* You will be asked to input a file name.
* Then you can choose the way to predict and the way to count similarity.
* After that, you will have two options:
	1. The first one is that you can get a user's predicted preference for a movie by inputting the user id and movie id.
	2. The second one is that you can get a list of recommended movies for a user by inputting the user id.
	You will be asked to input some constraints, like user ID or item ID, after choosing one option.

	Finally, you will get the predictor or recommendation result.

 
