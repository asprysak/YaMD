package pl.b2bnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CrewMemberId.class)
@Table(name = "crew_member")
public class CrewMember {

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @Id
    @Enumerated(value = EnumType.STRING)
    @Column(name = "position")
    private Position position;
}
