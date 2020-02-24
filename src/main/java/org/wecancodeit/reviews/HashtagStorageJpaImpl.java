package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.Models.Hashtag;

import java.util.Collection;

@Service
public class HashtagStorageJpaImpl implements HashtagStorage {

   private HashtagRepository hashtagRepository;


    public HashtagStorageJpaImpl(HashtagRepository hashtagRepository) {
        this.hashtagRepository=hashtagRepository;
    }

    @Override
    public Collection<Hashtag> findAllHashtags(){

        return (Collection<Hashtag>) hashtagRepository.findAll();
    }

    @Override
    public void storeHashtag(Hashtag hashtag){

        hashtagRepository.save(hashtag);
    }

    @Override
    public Hashtag findHashtagById(Long hashtagToFind){
        return hashtagRepository.findById(hashtagToFind).get();
    }
}
