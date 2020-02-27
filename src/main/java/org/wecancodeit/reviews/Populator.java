package org.wecancodeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Populator implements CommandLineRunner {

    CategoryStorage categoryStorage;
    ReviewStorage reviewStorage;
    HashtagStorage hashtagStorage;

    public Populator(CategoryStorage categoryStorage, ReviewStorage reviewStorage, HashtagStorage hashtagStorage){
        this.categoryStorage = categoryStorage;
        this.reviewStorage = reviewStorage;
        this.hashtagStorage = hashtagStorage;
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

        Review firstReview = new Review("Brad", 4, "Very versatile potato. This is the only thing I've eaten for the past month. I had to take off a point because I'm getting sick of them", russet, "A tater for every occasion ");
        reviewStorage.storeReview(firstReview);
        Review secondReview = new Review("Wilbur", 5, "I loved it. I mashed them all up and ate them with a side of whiskey. Great flavor! ", yellow, "Excellent");
        reviewStorage.storeReview(secondReview);
        Review thirdReview = new Review("Big Hungry Joe", 5, "I'm a big hungry man. I really enjoy these potatoes because they can be huge and taste great ", russet, "Great!");
        reviewStorage.storeReview(thirdReview);
        Review fourthReview = new Review("Gretel", 3, "They were good and everything, nothing too special. Vey standard", yellow, "Just ok");
        reviewStorage.storeReview(fourthReview);
        Review fifthReview = new Review("Bort", 1,  "I had no idea how to prepare this potato, there were no instructions! Now my uncle is in the hospital", blue, "NO INSTRUCTIONS");
        reviewStorage.storeReview(fifthReview);
        Review sixthReview = new Review("Gillian", 4,  " Never heard of a blue potato until now, surprised! Might definately try again.", blue, "Not bad!");
        reviewStorage.storeReview(sixthReview);
        Review seventhReview = new Review("Henry", 5, "What a darn tasty tater! I love them so much. My dog does not enjoy them so much. ", red, "WOW");
        reviewStorage.storeReview(seventhReview);
        Review eighthReview = new Review("Bimmy", 3, "I didn't like it, too bitter. However, my neighbor choked on one, and he's a jerk. High Five! ", red, "meh");
        reviewStorage.storeReview(eighthReview);
        Review ninthReview = new Review("MaryBeth", 1,  "Had these on the side of fermented fish. These potatoes made me feel very ill, would not recommend ", white, "made me sick");
        reviewStorage.storeReview(ninthReview);
        Review tenthReview = new Review("Sam", 5, "I love all potatoes, my favorite food. Boil 'em, mash 'em, stick 'em in a stew", white, "lovely");
        reviewStorage.storeReview(tenthReview);
        Review eleventhReview = new Review("Mark", 2, "I was eating these in a dark cave and accidentally ate one of my fingers", fingerling, "ouch");
        reviewStorage.storeReview(eleventhReview);
        Review twelfthReview = new Review("Mr. Moppet", 4, "My great grandpa's friend brought me a sack of these back from his trip to Machu Pichu. Highly recommended", fingerling, "very tasty");
        reviewStorage.storeReview(twelfthReview);

        Hashtag goodTag = new Hashtag("good");
        hashtagStorage.storeHashtag(goodTag);
        firstReview.addHashtag(goodTag);
        reviewStorage.storeReview(firstReview);
        Hashtag soGoodTag = new Hashtag("SoGood");
        hashtagStorage.storeHashtag(soGoodTag);
        secondReview.addHashtag(soGoodTag);
        reviewStorage.storeReview(secondReview);
        Hashtag filling = new Hashtag("filling");
        hashtagStorage.storeHashtag(filling);
        thirdReview.addHashtag(filling);
        reviewStorage.storeReview(thirdReview);
        Hashtag meh = new Hashtag("meh");
        hashtagStorage.storeHashtag(meh);
        fourthReview.addHashtag(meh);
        reviewStorage.storeReview(fourthReview);
        Hashtag confused = new Hashtag("confused");
        hashtagStorage.storeHashtag(confused);
        fifthReview.addHashtag(confused);
        reviewStorage.storeReview(fifthReview);
        Hashtag fun = new Hashtag("fun");
        hashtagStorage.storeHashtag(fun);
        sixthReview.addHashtag(fun);
        reviewStorage.storeReview(sixthReview);
        Hashtag notForDog = new Hashtag("NotForDogs");
        hashtagStorage.storeHashtag(notForDog);
        seventhReview.addHashtag(notForDog);
        reviewStorage.storeReview(seventhReview);
        Hashtag bitter = new Hashtag("bitter");
        hashtagStorage.storeHashtag(bitter);
        eighthReview.addHashtag(bitter);
        reviewStorage.storeReview(eighthReview);
        Hashtag sick = new Hashtag("sick");
        hashtagStorage.storeHashtag(sick);
        ninthReview.addHashtag(sick);
        reviewStorage.storeReview(ninthReview);
        tenthReview.addHashtag(soGoodTag);
        reviewStorage.storeReview(tenthReview);
        Hashtag paintato = new Hashtag("paintato");
        hashtagStorage.storeHashtag(paintato);
        eleventhReview.addHashtag(paintato);
        reviewStorage.storeReview(eleventhReview);
        Hashtag tasty = new Hashtag("tasty");
        hashtagStorage.storeHashtag(tasty);
        twelfthReview.addHashtag(tasty);
        reviewStorage.storeReview(twelfthReview);
       }
}
