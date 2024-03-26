#The below code defines a class `FoodRatings` which maintains a data structure to store and retrieve food ratings based on their cuisine. 

#It allows for changing the ratings of foods and retrieving the highest-rated food for a given cuisine.

from sortedcontainers import SortedSet

class FoodRatings:
  def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]): #The `__init__` method initializes the `FoodRatings` object. It takes three lists as input: `foods`, `cuisines`, and `ratings`. It creates several data structures to store food ratings:
    self.cuisineToRatingAndFoods = collections.defaultdict(
        lambda: SortedSet(key=lambda x: (-x[0], x[1]))) #`cuisineToRatingAndFoods`: A defaultdict with SortedSet values, where each SortedSet contains tuples of the form `(rating, food)` sorted by rating in descending order and then by food name alphabetically. This data structure maps each cuisine to its corresponding food ratings and names.

    self.foodToCuisine = {} #`foodToCuisine`: A dictionary that maps each food to its cuisine.

    self.foodToRating = {} #`foodToRating`: A dictionary that maps each food to its rating.
   #For each food, cuisine, and rating provided in the input lists, it populates these data structures accordingly.

    for food, cuisine, rating in zip(foods, cuisines, ratings):
      self.cuisineToRatingAndFoods[cuisine].add((rating, food))
      self.foodToCuisine[food] = cuisine
      self.foodToRating[food] = rating

  def changeRating(self, food: str, newRating: int) -> None:
    cuisine = self.foodToCuisine[food]
    oldRating = self.foodToRating[food]
    ratingAndFoods = self.cuisineToRatingAndFoods[cuisine]
    ratingAndFoods.remove((oldRating, food))
    ratingAndFoods.add((newRating, food))
    self.foodToRating[food] = newRating
    #The `changeRating` method updates the rating of a given food. It takes the name of the food (`food`) and the new rating (`newRating`) as input. It first retrieves the cuisine of the food using the `foodToCuisine` dictionary. Then, it removes the old rating-food tuple from the corresponding SortedSet in `cuisineToRatingAndFoods` and adds a new tuple with the updated rating. Finally, it updates the rating of the food in the `foodToRating` dictionary.

  def highestRated(self, cuisine: str) -> str:
    return self.cuisineToRatingAndFoods[cuisine][0][1]
    #The `highestRated` method retrieves the highest-rated food for a given cuisine. It takes the cuisine name (`cuisine`) as input and returns the name of the food with the highest rating for that cuisine. It does this by accessing the SortedSet corresponding to the cuisine in the `cuisineToRatingAndFoods` dictionary and retrieving the first element (which is the highest-rated food) from the set.

# Your FoodRatings object will be instantiated and called as such:
# obj = FoodRatings(foods, cuisines, ratings)
# obj.changeRating(food,newRating)
# param_2 = obj.highestRated(cuisine)

    #Overall, this class efficiently organizes food ratings by cuisine and allows for easy retrieval of the highest-rated food for a given cuisine. The use of SortedSet ensures that foods are sorted by rating, making it efficient to retrieve the highest-rated food. Additionally, the use of dictionaries enables fast lookup of cuisine, rating, and food information.