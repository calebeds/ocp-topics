package annotations;

@interface Team {
    String value() default "Soccer";
    int numPlayers() default 2;
}

class Sport {
    @Team(numPlayers = 6, value = "Volleyball")
    void beach() {}
    @Team(value = "Tennis")
    void strawberriesAndCream() {}
}

@interface Quiz {
    String[] topics();
}

class Competitor {
    @Quiz(topics = {"General Knowledge", "Music"}) String favoriteTopic;
    @Quiz(topics = {"Sport"}) String leastFavoriteTopic;
    @Quiz(topics = "Sport") String leastOtherFavoriteTopic;
}

@interface Colors {
    String[] value();
}

class TestRainbow {
    @Colors(value = {"Red"}) String color1;
    @Colors(value = "Red") String color2;
    @Colors({"Red"}) String color3;
    @Colors("Red") String color4;
}

class Shorthand {
}
