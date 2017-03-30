package graffiti.repo;

import org.springframework.data.repository.CrudRepository;
import graffiti.data.Picture;
/**
 * Created by WagnerMestrinho on 3/3/17.
 */

public interface PictureRepo extends CrudRepository<Picture, Long> {
}
