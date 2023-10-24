package org.launchcode.summerbucketlist.data;

import org.launchcode.summerbucketlist.models.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity,Integer> {
}
