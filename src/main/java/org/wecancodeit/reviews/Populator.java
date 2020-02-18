package org.wecancodeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    CategoryStorage categoryStorage;

    public Populator(CategoryStorage categoryStorage){
        this.categoryStorage = categoryStorage;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Populator running...");

        categoryStorage.storeCategory(new Category("Russet", "this is a description"));
        categoryStorage.storeCategory(new Category("White", "This is also a description"));
       }
}
