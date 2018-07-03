package pl.b2bnetwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.b2bnetwork.model.*;
import pl.b2bnetwork.repository.MovieRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class DbInitializer implements CommandLineRunner {

    private MovieRepository movieRepository;

    @Autowired
    public DbInitializer(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... strings) {

        Set<Genre> matrixGenres = new HashSet<>();
        matrixGenres.add(Genre.SCI_FI);
        matrixGenres.add(Genre.DRAMAT);
        matrixGenres.add(Genre.ACTION);

        Set<Award> matrixAwards = new HashSet<>();
        matrixAwards.add(Award.OSCARS);
        matrixAwards.add(Award.BAFTA);

        Set<String> matrixCountries = new HashSet<>();
        matrixCountries.add("USA");
        matrixCountries.add("Australia");

        String MatrixDescription = "A computer hacker learns from mysterious rebels about the true nature " +
                "of his reality and his role in the war against its controllers.";

        Movie matrix = Movie.builder()
                .title("Matrix")
                .year(1993)
                .runtime(135)
                .genres(matrixGenres)
                .awards(matrixAwards)
                .countries(matrixCountries)
                .description(MatrixDescription)
                .build();

        Person lWachowski = new Person.Builder().name("Laurence").surname("Wachowski").build();
        Person kReeves = new Person.Builder().name("Keanu").surname("Reeves").build();
        Person lFishburne = new Person.Builder().name("Laurence").surname("Fishburne").build();
        Person caMoss = new Person.Builder().name("Carrie-Anne").surname("Moss").build();
        Person aWachowski = new Person.Builder().name("Andrew").surname("Wachowski").build();

        Set<CrewMember> matrixMembers = new HashSet<>();
        CrewMember aWachowskiDirMatrix = CrewMember.builder()
                .person(aWachowski)
                .movie(matrix)
                .position(Position.DIRECTOR)
                .build();
        matrixMembers.add(aWachowskiDirMatrix);

        CrewMember aWachowskiWriterMatrix = CrewMember.builder()
                .person(aWachowski)
                .movie(matrix)
                .position(Position.WRITER)
                .build();
        matrixMembers.add(aWachowskiWriterMatrix);

        CrewMember kReevesActorMatrix = CrewMember.builder()
                .person(kReeves)
                .movie(matrix)
                .position(Position.ACTOR)
                .build();
        matrixMembers.add(kReevesActorMatrix);

        CrewMember lWachowskiDirMatrix = CrewMember.builder()
                .person(lWachowski)
                .movie(matrix)
                .position(Position.DIRECTOR)
                .build();
        matrixMembers.add(lWachowskiDirMatrix);

        CrewMember lWachowskiWriterMatrix = CrewMember.builder()
                .person(lWachowski)
                .movie(matrix)
                .position(Position.WRITER)
                .build();
        matrixMembers.add(lWachowskiWriterMatrix);

        CrewMember lFishburneActorMatrix = CrewMember.builder()
                .person(lFishburne)
                .movie(matrix)
                .position(Position.ACTOR)
                .build();
        matrixMembers.add(lFishburneActorMatrix);

        CrewMember caMossActorMatrix = CrewMember.builder()
                .person(caMoss)
                .movie(matrix)
                .position(Position.ACTOR)
                .build();
        matrixMembers.add(caMossActorMatrix);
        matrix.setCrewMembers(matrixMembers);

        Set<Genre> twelveAngryMenGenres = new HashSet<>();
        twelveAngryMenGenres.add(Genre.DRAMAT);

        Set<Award> twelveAngryMenAwards = new HashSet<>();
        twelveAngryMenAwards.add(Award.OSCARS);
        twelveAngryMenAwards.add(Award.BAFTA);
        twelveAngryMenAwards.add(Award.GOLDENGLOBE);

        Set<String> twelveAngryMenCountries = new HashSet<>();
        twelveAngryMenCountries.add("USA");

        String twelveAngryMenDescription = "A jury holdout attempts to prevent a miscarriage of justice " +
                "by forcing his colleagues to reconsider the evidence.";

        Movie twelveAngryMen = Movie.builder()
                .title("12 Angry Men")
                .year(1957)
                .runtime(96)
                .genres(twelveAngryMenGenres)
                .awards(twelveAngryMenAwards)
                .countries(twelveAngryMenCountries)
                .description(twelveAngryMenDescription)
                .build();

        Person qTarantino = new Person.Builder().name("Reginald").surname("Rose").build();
        Person rRose = new Person.Builder().name("Reginald").surname("Rose").build();
        Person sLumet = new Person.Builder().name("Sidney").surname("Lumet").build();
        Person lCobb = new Person.Builder().name("Lee").surname("Cobb").build();
        Person mBalsam = new Person.Builder().name("Martin").surname("Balsam").build();
        Person hFonda = new Person.Builder().name("Henry").surname("Fonda").build();

        Set<CrewMember> twelveAngryMenMembers = new HashSet<>();
        twelveAngryMenMembers.add(CrewMember.builder()
                .person(qTarantino)
                .movie(twelveAngryMen)
                .position(Position.DIRECTOR)
                .build());
        twelveAngryMenMembers.add(CrewMember.builder()
                .person(rRose)
                .movie(twelveAngryMen)
                .position(Position.WRITER)
                .build());
        twelveAngryMenMembers.add(CrewMember.builder()
                .person(sLumet)
                .movie(twelveAngryMen)
                .position(Position.ACTOR)
                .build());
        twelveAngryMenMembers.add(CrewMember.builder()
                .person(lCobb)
                .movie(twelveAngryMen)
                .position(Position.ACTOR)
                .build());
        twelveAngryMenMembers.add(CrewMember.builder()
                .person(mBalsam)
                .movie(twelveAngryMen)
                .position(Position.ACTOR)
                .build());
        twelveAngryMenMembers.add(CrewMember.builder()
                .person(hFonda)
                .movie(twelveAngryMen)
                .position(Position.ACTOR)
                .build());
        twelveAngryMen.setCrewMembers(twelveAngryMenMembers);

        Set<Genre> pulpFictionGenres = new HashSet<>();
        pulpFictionGenres.add(Genre.ACTION);
        pulpFictionGenres.add(Genre.BLACK_COMEDY);

        Set<Award> pulpFictionAwards = new HashSet<>();
        pulpFictionAwards.add(Award.OSCARS);
        pulpFictionAwards.add(Award.GOLDENGLOBE);

        Set<String> pulpFictionCountries = new HashSet<>();
        pulpFictionCountries.add("USA");

        String pulpFictionDescription = "The lives of two mob hitman, a boxer, a gangster's wife, " +
                "and a pair of diner bandits intertwine in four tales of violence and redemption.";

        Movie pulpFiction = Movie.builder()
                .title("Pulp Fiction")
                .year(1994)
                .runtime(154)
                .genres(pulpFictionGenres)
                .awards(pulpFictionAwards)
                .countries(pulpFictionCountries)
                .description(pulpFictionDescription)
                .build();

        Set<CrewMember> pulpFictionMembers = new HashSet<>();
        Person jTravolta = new Person.Builder().name("John").surname("Travolta").build();
        Person sJackson = new Person.Builder().name("Samuel").surname("Jackson").build();
        Person bWillis = new Person.Builder().name("Bruce").surname("Willis").build();
        Person uThurman = new Person.Builder().name("Uma").surname("Thurman").build();

//        pulpFictionMembers.add(CrewMember.builder()
//                .person(qTarantino)
//                .movie(pulpFiction)
//                .position(Position.DIRECTOR)
//                .build());
//
///       pulpFictionMembers.add(CrewMember.builder()
//                .person(qTarantino)
//                .movie(pulpFiction)
//                .position(Position.WRITER)
//                .build());

        pulpFictionMembers.add(CrewMember.builder()
                .person(jTravolta)
                .movie(pulpFiction)
                .position(Position.ACTOR)
                .build());

        pulpFictionMembers.add(CrewMember.builder()
                .person(sJackson)
                .movie(pulpFiction)
                .position(Position.ACTOR)
                .build());

        pulpFictionMembers.add(CrewMember.builder()
                .person(bWillis)
                .movie(pulpFiction)
                .position(Position.ACTOR)
                .build());

        pulpFictionMembers.add(CrewMember.builder()
                .person(uThurman)
                .movie(pulpFiction)
                .position(Position.ACTOR)
                .build());

        pulpFiction.setCrewMembers(pulpFictionMembers);

        String johnWickDescription = "An ex-hitman comes out of retirement to track down the gangsters " +
                "that killed his dog and took everything from him. ";
        Set<Genre> johnWickGenres = new HashSet<>();
        johnWickGenres.add(Genre.ACTION);
        johnWickGenres.add(Genre.CRIME);
        johnWickGenres.add(Genre.THRILLER);

        Set<Award> johnWickAwards = new HashSet<>();
        johnWickAwards.add(Award.GOLDEN_SCHMOES);

        Set<String> johnWickCountries = new HashSet<>();
        johnWickCountries.add("USA");
        johnWickCountries.add("China");

        Movie johnWick = Movie.builder()
                .title("John Wick")
                .year(2014)
                .runtime(101)
                .genres(johnWickGenres)
                .awards(johnWickAwards)
                .countries(johnWickCountries)
                .description(johnWickDescription)
                .build();

        Person dLeitch = new Person.Builder().name("David").surname("Leitch").build();
        Person chStahelski = new Person.Builder().name("Chad").surname("Stahelski").build();
        Person dKolstad = new Person.Builder().name("Derek").surname("Kolstad").build();
        Person mNyqvistt = new Person.Builder().name("Michael").surname("Nyqvistt").build();

        Set<CrewMember> johnWickMembers = new HashSet<>();
        johnWickMembers.add(CrewMember.builder().person(dLeitch).movie(johnWick).position(Position.DIRECTOR).build());
        johnWickMembers.add(CrewMember.builder().person(chStahelski).movie(johnWick).position(Position.DIRECTOR).build());
        johnWickMembers.add(CrewMember.builder().person(dKolstad).movie(johnWick).position(Position.WRITER).build());
        johnWickMembers.add(CrewMember.builder().person(mNyqvistt).movie(johnWick).position(Position.ACTOR).build());
//        johnWickMembers.add(CrewMember.builder().person(kReeves).movie(johnWick).position(Position.ACTOR).build());
        johnWick.setCrewMembers(johnWickMembers);

        this.movieRepository.save(matrix);
        this.movieRepository.save(johnWick);
        this.movieRepository.save(twelveAngryMen);
        this.movieRepository.save(pulpFiction);

    }
}
