package org.wecancodeit.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    MapCategoryStorage categoryStorage;

    public Populator(MapCategoryStorage categoryStorage){
        this.categoryStorage = categoryStorage;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Populator runnig...");

        Category russetCategory = new Category("Russet","Russet description");
        Category fingerlingCategory = new Category("Fingerling","Fingerling description");
        Category yellowCategory = new Category("Yellow","I'am yellow");
        Category whiteCategory = new Category("White","It is white");
        categoryStorage.storeCategory(russetCategory);
        categoryStorage.storeCategory(yellowCategory);
        categoryStorage.storeCategory(whiteCategory);
        categoryStorage.storeCategory(fingerlingCategory);
       }
}
