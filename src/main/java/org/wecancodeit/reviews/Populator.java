package org.wecancodeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Populator implements CommandLineRunner {

    CategoryStorage categoryStorage;
    ReviewStorage reviewStorage;


    public Populator(CategoryStorage categoryStorage, ReviewStorage reviewStorage){
        this.categoryStorage = categoryStorage;
        this.reviewStorage = reviewStorage;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Populator running...");

        Category russet = new Category("Russet", "A large potato with dark brown skin and few eyes");
        categoryStorage.storeCategory(russet);
        Category white = new Category("White", "A potato with smooth skin, few eyes and a bright white appearance");
        categoryStorage.storeCategory(white);
        Category red = new Category("Red", "A smaller potato with deep red skin and light brown markings");
        categoryStorage.storeCategory(red);
        Category blue  = new Category("Blue", "A large and oblong potato with blue skin and purple flesh");
        categoryStorage.storeCategory(blue);
        Category yellow  =  new Category("Yellow", "A potato with skin and flesh that is yellow or golden");
        categoryStorage.storeCategory(yellow);
        Category fingerling = new Category("Fingerling", "A small finger shaped potato that grows small and narrow");
        categoryStorage.storeCategory(fingerling);

        Review firstReview = new Review("Brad", 4, new Date(), " is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it", russet, "Really good potato",#);
        reviewStorage.storeReview(firstReview);
        Review secondReview = new Review("John", 5, new Date(), " is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled ", yellow, "yellow");
        reviewStorage.storeReview(secondReview);
        Review thirdReview = new Review("John", 5, new Date(), " is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it ", russet, "russet");
        reviewStorage.storeReview(thirdReview);
       }
}
