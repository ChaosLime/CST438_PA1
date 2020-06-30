package cst438;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class movieController {
  
  /*A result that holds the most recent ID just after it was inputed
  * from the form. Otherwise will appear to be empty. i.e. the recently added
  * will be empty as the default is 0.
  * TODO:determine the length of the database at 
  * start rather than setting if anything present, otherwise 0
  */
  long newestID = 0;
  
  @Autowired
  MovieRatingRepository movieRatingRepository;
  
  @GetMapping("/movies/new")
  public String createRating(Model model) {
    Rating rating = new Rating();
    model.addAttribute("rating", rating);
    return "rating_form";
  }
  
  @PostMapping("/movies")
  public String processRatingForm(@Valid Rating rating, BindingResult result, Model model) {
    if(result.hasErrors()){
      return "rating_form";
    }
    movieRatingRepository.save(rating);
    newestID = rating.getId();
    return ("redirect:/movies");
  }

  @GetMapping("/movies")
  public String getAllRatings(Model model) {
    //displays all ratings by title and chronological order desc
    Iterable<Rating> rating = movieRatingRepository.findAll();
    model.addAttribute("ratings", rating);
    //inputs value for the most recent new rating and returns it when added.
    model.addAttribute("mostRecentRating", newestID);
    
    return "rating_list";	
  }
}