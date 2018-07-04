package pl.b2bnetwork.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class CrewMemberId implements Serializable {

    private Long person;
    private Long movie;
    private Position position;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrewMemberId that = (CrewMemberId) o;
        return Objects.equals(person, that.person) &&
                Objects.equals(movie, that.movie) &&
                position == that.position;
    }

    @Override
    public int hashCode() {

        return Objects.hash(person, movie, position);
    }
}
