package dtos;

import demo.facts.Pair;
import demo.facts.Rating;
import lombok.Getter;
import lombok.Setter;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
@Setter
public class UserRatingsDto {
    Set<Rating> ratings;
    float averageRating;

    public UserRatingsDto(Set<Rating> ratings) {
        this.ratings = ratings;
        this.averageRating = (float)ratings
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element.getRate(), Integer::sum) / ratings.size();
    }
    public float getCorrelationCoefficient(Set<Rating> primary, float primaryAvgRating) {
        List<Pair> pairs = new ArrayList<>();
        this.ratings.forEach(rating -> {
           Rating found = primary
                   .stream()
                   .filter(primaryRating -> rating == primaryRating)
                   .findAny()
                   .orElse(null);
           if (found != null) pairs.add(new Pair(rating.getRate(), found.getRate()));
        });

       float firstSum = pairs
               .stream()
               .reduce(
                       0.0F,
                       (subtotal, element) -> subtotal + ((element.getA() - this.averageRating) * (element.getB()) - primaryAvgRating),
                       Float::sum
               );
       float secondSum = pairs
               .stream()
               .reduce(
                       0.0F,
                       (subtotal, element) -> subtotal + (element.getA() - this.averageRating) * (element.getA() - this.averageRating),
                       Float::sum
               );
       float thirdSum = pairs
               .stream()
               .reduce(
                       0.0F,
                       (subtotal, element) -> subtotal + (element.getB() - primaryAvgRating) * (element.getB() - primaryAvgRating),
                       Float::sum
               );

       return firstSum/((float)Math.sqrt(secondSum) * (float)Math.sqrt(thirdSum));
    }
}
