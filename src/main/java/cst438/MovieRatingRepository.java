package cst438;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import antlr.collections.List;

public interface MovieRatingRepository extends CrudRepository<Rating, Long> {
  @Query("select m from Rating m order by title, date desc")
  List findAllMovieRatingsOrderByTitleDateDesc();
}
