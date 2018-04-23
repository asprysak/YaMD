package pl.eninja.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(unique = true)
  private String title;
  private Integer year;
  // TODO add Director
  //  private Director director;
  // TODO add @OneToMany
  //  private List<Genre> genre;
  //  private List<Actor> actors;
  private Integer duration;
}
