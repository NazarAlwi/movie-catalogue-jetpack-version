package com.learn.moviecataloguejetpackversion.utils;

import com.learn.moviecataloguejetpackversion.data.source.local.entity.Movie;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;

import java.util.ArrayList;

public class FakeMovieData {
    public static Movie generateMovieById(Movie movie, boolean favorited) {
        movie.setFavorited(favorited);
        return movie;

    }

    public static ArrayList<MovieResponse> generateMovieResponseList() {
        ArrayList<MovieResponse> movieResponses = new ArrayList<>();

        movieResponses.add(new MovieResponse("0000", "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg", "Joker", "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.", "8.5", "2019-10-04", "534.771", "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg"));

        movieResponses.add(new MovieResponse("0001", "/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg","Terminator: Dark Fate", "More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race. Dani Ramos is living a simple life in Mexico City with her brother and father when a highly advanced and deadly new Terminator – a Rev-9 – travels back through time to hunt and kill her. Dani's survival depends on her joining forces with two warriors: Grace, an enhanced super-soldier from the future, and a battle-hardened Sarah Connor. As the Rev-9 ruthlessly destroys everything and everyone in its path on the hunt for Dani, the three are led to a T-800 from Sarah’s past that may be their last best hope.",   "6.6","2019-11-01", "374.6", "/a6cDxdwaQIFjSkXf7uskg78ZyTq.jpg"));

        movieResponses.add(new MovieResponse("0002", "/tBuabjEqxzoUBHfbyNbd8ulgy5j.jpg", "Maleficent: Mistress of Evil", "Maleficent and her goddaughter Aurora begin to question the complex family ties that bind them as they are pulled in different directions by impending nuptials, unexpected allies, and dark new forces at play.", "7.2" , "2019-10-18", "214.876", "/skvI4rYFrKXS73BJxWGH54Omlvv.jpg"));

        movieResponses.add(new MovieResponse("0003", "/jpfkzbIXgKZqCZAkEkFH2VYF63s.jpg", "Cars", "Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters.", "6.7", "2006-06-09", "121.893", "/a1MlbLBk5Sy6YvMbSuKfwGlDVlb.jpg"));

        movieResponses.add(new MovieResponse("0004", "/ePXuKdXZuJx8hHMNr2yM4jY2L7Z.jpg", "El Camino: A Breaking Bad Movie", "In the wake of his dramatic escape from captivity, Jesse Pinkman must come to terms with his past in order to forge some kind of future.", "7.1", "2019-10-11", "108.112", "/ijiE9WoGSwSzM16zTxvUneJ8RXc.jpg"));

        movieResponses.add(new MovieResponse("0005", "/g4z7mDmJmx23vsVg6XNWcnXb6gc.jpg", "47 Meters Down: Uncaged", "A group of backpackers diving in a ruined underwater city discover that they have stumbled into the territory of the ocean's deadliest shark species.", "5.1", "2019-08-16", "107.197", "/3uG3aOhEzFCjcQulsJQiAzLSrw8.jpg"));

        movieResponses.add(new MovieResponse("0006", "/pIcV8XXIIvJCbtPoxF9qHMKdRr2.jpg", "Zombieland: Double Tap", "Columbus, Tallahassee, Wichita, and Little Rock move to the American heartland as they face off against evolved zombies, fellow survivors, and the growing pains of the snarky makeshift family.", "7.4", "2019-10-18", "106.325", "/jCCdt0e8Xe9ttvevD4S3TSMNdH.jpg"));

        movieResponses.add(new MovieResponse("0007", "/tximyCXMEnWIIyOy9STkOduUprG.jpg", "Good Boys", "A group of young boys on the cusp of becoming teenagers embark on an epic quest to fix their broken drone before their parents get home.", "6.6", "2019-08-16", "122.885", "/zIZv4pPJRg3YTnWWuotwXnYu1fM.jpg"));

        movieResponses.add(new MovieResponse("0008", "/2bXbqYdUdNVa8VIWXVfclP2ICtT.jpg", "The Lion King", "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.", "7.1", "2019-07-19", "139.524", "/nRXO2SnOA75OsWhNhXstHB8ZmI3.jpg"));

        movieResponses.add(new MovieResponse("0009", "/vn94LlNrbUWIZZyAdmvUepFBeaY.jpg","Ip Man 4: The Finale", "Ip Man 4 is an upcoming Hong Kong biographical martial arts film directed by Wilson Yip and produced by Raymond Wong. It is the fourth in the Ip Man film series based on the life of the Wing Chun grandmaster of the same name and features Donnie Yen reprising the role. The film began production in April 2018 and ended in July the same year.", "0","2019-12-20", "92.996", "/ekP6EVxL81lZ4ivcqPsoZ72rY0h.jpg"));

        return movieResponses;
    }

    public static ArrayList<Movie> generateMovieList() {
        ArrayList<Movie> movie = new ArrayList<>();

        movie.add(new Movie("0000", "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg", "Joker", "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.", "8.5", "2019-10-04", "534.771", "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg", false));

        movie.add(new Movie("0001", "/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg","Terminator: Dark Fate", "More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race. Dani Ramos is living a simple life in Mexico City with her brother and father when a highly advanced and deadly new Terminator – a Rev-9 – travels back through time to hunt and kill her. Dani's survival depends on her joining forces with two warriors: Grace, an enhanced super-soldier from the future, and a battle-hardened Sarah Connor. As the Rev-9 ruthlessly destroys everything and everyone in its path on the hunt for Dani, the three are led to a T-800 from Sarah’s past that may be their last best hope.",   "6.6","2019-11-01", "374.6", "/a6cDxdwaQIFjSkXf7uskg78ZyTq.jpg", false));

        movie.add(new Movie("0002", "/tBuabjEqxzoUBHfbyNbd8ulgy5j.jpg", "Maleficent: Mistress of Evil", "Maleficent and her goddaughter Aurora begin to question the complex family ties that bind them as they are pulled in different directions by impending nuptials, unexpected allies, and dark new forces at play.", "7.2" , "2019-10-18", "214.876", "/skvI4rYFrKXS73BJxWGH54Omlvv.jpg", false));

        movie.add(new Movie("0003", "/jpfkzbIXgKZqCZAkEkFH2VYF63s.jpg", "Cars", "Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters.", "6.7", "2006-06-09", "121.893", "/a1MlbLBk5Sy6YvMbSuKfwGlDVlb.jpg", false));

        movie.add(new Movie("0004", "/ePXuKdXZuJx8hHMNr2yM4jY2L7Z.jpg", "El Camino: A Breaking Bad Movie", "In the wake of his dramatic escape from captivity, Jesse Pinkman must come to terms with his past in order to forge some kind of future.", "7.1", "2019-10-11", "108.112", "/ijiE9WoGSwSzM16zTxvUneJ8RXc.jpg", false));

        movie.add(new Movie("0005", "/g4z7mDmJmx23vsVg6XNWcnXb6gc.jpg", "47 Meters Down: Uncaged", "A group of backpackers diving in a ruined underwater city discover that they have stumbled into the territory of the ocean's deadliest shark species.", "5.1", "2019-08-16", "107.197", "/3uG3aOhEzFCjcQulsJQiAzLSrw8.jpg", false));

        movie.add(new Movie("0006", "/pIcV8XXIIvJCbtPoxF9qHMKdRr2.jpg", "Zombieland: Double Tap", "Columbus, Tallahassee, Wichita, and Little Rock move to the American heartland as they face off against evolved zombies, fellow survivors, and the growing pains of the snarky makeshift family.", "7.4", "2019-10-18", "106.325", "/jCCdt0e8Xe9ttvevD4S3TSMNdH.jpg", false));

        movie.add(new Movie("0007", "/tximyCXMEnWIIyOy9STkOduUprG.jpg", "Good Boys", "A group of young boys on the cusp of becoming teenagers embark on an epic quest to fix their broken drone before their parents get home.", "6.6", "2019-08-16", "122.885", "/zIZv4pPJRg3YTnWWuotwXnYu1fM.jpg", false));

        movie.add(new Movie("0008", "/2bXbqYdUdNVa8VIWXVfclP2ICtT.jpg", "The Lion King", "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.", "7.1", "2019-07-19", "139.524", "/nRXO2SnOA75OsWhNhXstHB8ZmI3.jpg", false));

        movie.add(new Movie("0009", "/vn94LlNrbUWIZZyAdmvUepFBeaY.jpg","Ip Man 4: The Finale", "Ip Man 4 is an upcoming Hong Kong biographical martial arts film directed by Wilson Yip and produced by Raymond Wong. It is the fourth in the Ip Man film series based on the life of the Wing Chun grandmaster of the same name and features Donnie Yen reprising the role. The film began production in April 2018 and ended in July the same year.", "0","2019-12-20", "92.996", "/ekP6EVxL81lZ4ivcqPsoZ72rY0h.jpg", false));

        return movie;
    }
}
