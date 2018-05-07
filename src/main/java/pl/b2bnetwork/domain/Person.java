package pl.b2bnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String surname;

  @OneToMany(mappedBy = "person",
          cascade= {CascadeType.ALL},
          fetch = FetchType.LAZY,
          targetEntity = CrewMember.class)
  private Set<CrewMember> crewMembers = new HashSet<>();

  private Person(Builder builder) {
    setId(builder.id);
    setName(builder.name);
    setSurname(builder.surname);
  }

  public void addCrewMember(CrewMember member) {
    crewMembers.add(member);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Person person = (Person) o;
    return Objects.equals(name, person.name) &&
            Objects.equals(surname, person.surname);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), name, surname);
  }

  public static final class Builder {

    private Long id;
    private String name;
    private String surname;

    public Builder() {
    }

    public Builder id(Long val) {
      id = val;
      return this;
    }

    public Builder name(String val) {
      name = val;
      return this;
    }

    public Builder surname(String val) {
      surname = val;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
  }
}
