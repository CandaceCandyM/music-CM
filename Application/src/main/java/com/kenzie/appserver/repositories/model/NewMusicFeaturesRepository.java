package com.kenzie.appserver.repositories.model;

import com.kenzie.appserver.repositories.model.NewMusicFeaturesRecord;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface NewMusicFeaturesRepository extends CrudRepository<NewMusicFeaturesRecord, String> {

}
