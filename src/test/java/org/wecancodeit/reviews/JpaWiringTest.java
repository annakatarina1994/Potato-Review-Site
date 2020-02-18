package org.wecancodeit.reviews;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
public class JpaWiringTest {
@Autowired
    private CategoryRepository categoryRepo;
@Autowired
    private ReviewRepository reviewRepo;

@Test
public void categoryShouldHaveListOfReviews(){
    Category testCategory = new Category("Test Category", "Description");
    Review testReview = new Review("Test Author", 2, new Date(), "review text", testCategory,"Good" );

    categoryRepo.save(testCategory);
    reviewRepo.save(testReview);
}
}
