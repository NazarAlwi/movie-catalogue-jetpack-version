package com.learn.moviecataloguejetpackversion.utils;

import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;

import java.util.ArrayList;

public class FakeTvShowData {
    public static ArrayList<TvShowResponse> generateTvShowResponseList() {
        ArrayList<TvShowResponse> tvShowsResponse = new ArrayList<>();

        tvShowsResponse.add(new TvShowResponse("0000", "/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg", "Arrow", "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.", "5.8", "2012-10-10", "418.603", "/dXTyVDTIgeByvUOUEiHjbi8xX9A.jpg"));

        tvShowsResponse.add(new TvShowResponse("0001", "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg","Supernatural", "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",   "7.4","2005-09-13", "235.731", "/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg"));

        tvShowsResponse.add(new TvShowResponse("0002", "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg", "The Flash", "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.", "6.7" , "2014-10-07", "225.559", "/6ZdQTBy20HzWudZthAV7NkZWfIb.jpg"));

        tvShowsResponse.add(new TvShowResponse("0003", "/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg", "Fear the Walking Dead", "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.", "6.3", "2015-08-23", "325.071", "/7r4FieFH6Eh6S55hi8c9LOiFENg.jpg"));

        tvShowsResponse.add(new TvShowResponse("0004", "/yTZQkSsxUFJZJe67IenRM0AEklc.jpg", "The Simpsons", "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.", "7.1", "1989-12-17", "185.702", "/f5uNbUC76oowt5mt5J9QlqrIYQ6.jpg"));

        tvShowsResponse.add(new TvShowResponse("0005", "/g3JsScc7mQCfc3e5e5rXwu7xVVP.jpg", "See", "A virus has decimated humankind. Those who survived emerged blind. Centuries later when twins are born with the mythic ability to see, their father must protect his tribe against a threatened queen.", "7.9", "2019-11-01", "172.71", "/8TOkxONO3TEeJRuZWb0hG7SboyV.jpg"));

        tvShowsResponse.add(new TvShowResponse("0006", "/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg", "Family Guy", "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.", "6.5", "1999-01-31", "158.91", "/pH38r4TWTqq7Mcs6XAlwgzNUeJe.jpg"));

        tvShowsResponse.add(new TvShowResponse("0007", "/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg", "Riverdale", "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.", "7.2", "2017-01-26", "119.77", "/2IUpoKSP64r6rp2vBo0Fdk8a1UU.jpg"));

        tvShowsResponse.add(new TvShowResponse("0008", "/jnsvc7gCKocXnrTXF6p03cICTWb.jpg", "Grey's Anatomy", "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.", "6.4", "2005-03-27", "128.762", "/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg"));

        tvShowsResponse.add(new TvShowResponse("0009", "/v9zc0cZpy5aPSfAy6Tgb6I1zWgV.jpg","South Park", "Follows the misadventures of four irreverent grade-schoolers in the quiet, dysfunctional town of South Park, Colorado.", "7.8","1997-08-13", "117.581", "/mSDKNVvDfitFE6Fb6fSSl5DQmgS.jpg"));

        return tvShowsResponse;
    }

    public static ArrayList<TvShow> generateTvShowList() {
        ArrayList<TvShow> tvShows = new ArrayList<>();

        tvShows.add(new TvShow("0000", "/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg", "Arrow", "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.", "5.8", "2012-10-10", "418.603", "/dXTyVDTIgeByvUOUEiHjbi8xX9A.jpg", false));

        tvShows.add(new TvShow("0001", "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg","Supernatural", "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",   "7.4","2005-09-13", "235.731", "/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg", false));

        tvShows.add(new TvShow("0002", "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg", "The Flash", "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.", "6.7" , "2014-10-07", "225.559", "/6ZdQTBy20HzWudZthAV7NkZWfIb.jpg", false));

        tvShows.add(new TvShow("0003", "/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg", "Fear the Walking Dead", "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.", "6.3", "2015-08-23", "325.071", "/7r4FieFH6Eh6S55hi8c9LOiFENg.jpg", false));

        tvShows.add(new TvShow("0004", "/yTZQkSsxUFJZJe67IenRM0AEklc.jpg", "The Simpsons", "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.", "7.1", "1989-12-17", "185.702", "/f5uNbUC76oowt5mt5J9QlqrIYQ6.jpg", false));

        tvShows.add(new TvShow("0005", "/g3JsScc7mQCfc3e5e5rXwu7xVVP.jpg", "See", "A virus has decimated humankind. Those who survived emerged blind. Centuries later when twins are born with the mythic ability to see, their father must protect his tribe against a threatened queen.", "7.9", "2019-11-01", "172.71", "/8TOkxONO3TEeJRuZWb0hG7SboyV.jpg", false));

        tvShows.add(new TvShow("0006", "/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg", "Family Guy", "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.", "6.5", "1999-01-31", "158.91", "/pH38r4TWTqq7Mcs6XAlwgzNUeJe.jpg", false));

        tvShows.add(new TvShow("0007", "/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg", "Riverdale", "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.", "7.2", "2017-01-26", "119.77", "/2IUpoKSP64r6rp2vBo0Fdk8a1UU.jpg", false));

        tvShows.add(new TvShow("0008", "/jnsvc7gCKocXnrTXF6p03cICTWb.jpg", "Grey's Anatomy", "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.", "6.4", "2005-03-27", "128.762", "/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg", false));

        tvShows.add(new TvShow("0009", "/v9zc0cZpy5aPSfAy6Tgb6I1zWgV.jpg","South Park", "Follows the misadventures of four irreverent grade-schoolers in the quiet, dysfunctional town of South Park, Colorado.", "7.8","1997-08-13", "117.581", "/mSDKNVvDfitFE6Fb6fSSl5DQmgS.jpg", false));

        return tvShows;
    }
}
