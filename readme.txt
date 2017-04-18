Students Name: Na Luo
               Eddie

*************************
Design
In this project, we've implemented the following classes:
	1. Movie, implements the Movie object, which records the name and the ID of an Movie. (We can add more attributes for this item if needed in the future, like genre)
	2. User, implements the User object, which contains the ID of an user and the user's rating for the items.
	3. ReadMovie, reads in a file and stores the user and item data in hashmap.
	4. Pearson, caculates the similarity between users according to the user's rating for Items, and this class implements from RelationFormula interface.
	5. Neighborhood, finds the neighboors for a given user according to a threshold for similarity.
	6. Predictor, predicts the user's preference for an item.
	7. Recommender, generates the recommandation list for an user.
    8. Main: asks users for an input, and print the predict results according to user's input.

In this project, we've implented an interface:
	1. RelationFormula, we can implements the interface to caculate the similarity between two users, but the way we caculate the similarity can be different. 

************************
Program Instruction
You should go to Main.java, and there's a main method. 
Start the program, and you will have two options.
The first one is that you can get a user's predicted preference for a movie by inputting the user id and movie id.
The second one is that you can get a list of recommended movies for a user by inputting the user id.

************************
Others
Our movie recommendation result is the same as the one on piazza, while the predicted preference value is slightly different from the one on the piazza, because we implement PriorityQueue to find the neighbors and recommend movies, and the break tie of similarity between users causes the little difference.
 