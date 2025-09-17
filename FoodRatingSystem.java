// class FoodRatingSystem {
//     String[] foods;
//     String[] cuisines;
//     int[] ratings;

//     public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
//         this.foods = foods;
//         this.cuisines = cuisines;
//         this.ratings = ratings;
//     }

//     public void changeRating(String food, int newRating) {
//         for (int i = 0; i < this.foods.length; i++) {
//             if (this.foods[i].equals(food)) {
//                 this.ratings[i] = newRating;
//                 break;
//             }
//         }
//     }

//     public String highestRated(String cuisine) {
//         int maxindex = -1;
//         int maxrating =-1;
//         for (int i = 0; i < this.cuisines.length; i++) {
//             if (this.cuisines[i].equals(cuisine)) {
//                 if (this.ratings[i] > maxrating) {
//                     maxrating = this.ratings[i];
//                     maxindex =  i;
//                 }
//                 if(this.ratings[i] == maxrating){
//                     if( (this.foods[i]).compareTo(this.foods[maxindex]) <0 ){
//                         maxrating = this.ratings[i];
//                         maxindex = i;
//                     }
//                 }
//             }
//         }
//         return this.foods[maxindex];
//     }
// }

// /**
//  * Your FoodRatings object will be instantiated and called as such:
//  * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
//  * obj.changeRating(food,newRating);
//  * String param_2 = obj.highestRated(cuisine);
//  */


// good solution worked but time limit exceeded at 73th/78 testcase!

// oh well had to depend on gpt 

import java.util.*;

class FoodRatings {
    Map<String, Integer> foodToRating;
    Map<String, String> foodToCuisine;
    Map<String, TreeSet<Food>> cuisineToFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToRating = new HashMap<>();
        foodToCuisine = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodToRating.put(foods[i], ratings[i]);
            foodToCuisine.put(foods[i], cuisines[i]);

            cuisineToFoods.putIfAbsent(cuisines[i], new TreeSet<>());
            cuisineToFoods.get(cuisines[i]).add(new Food(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);

        // remove old Food object
        cuisineToFoods.get(cuisine).remove(new Food(food, oldRating));

        // update rating
        foodToRating.put(food, newRating);

        // add updated Food object
        cuisineToFoods.get(cuisine).add(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first().name;
    }

    static class Food implements Comparable<Food> {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        @Override
        public int compareTo(Food other) {
            if (this.rating != other.rating) {
                return Integer.compare(other.rating, this.rating); // higher first
            }
            return this.name.compareTo(other.name); // lexicographically smaller first
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Food)) return false;
            Food other = (Food) o;
            return this.name.equals(other.name) && this.rating == other.rating;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, rating);
        }
    }
}


//chatgpt prevails damn
