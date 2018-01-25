package com.vahundos.to;

public class RestaurantWithVoteTo extends RestaurantTo {

    private final int voteCount;

    public RestaurantWithVoteTo(int id, String name, int voteCount) {
        super(id, name);
        this.voteCount = voteCount;;
    }

    public int getVoteCount() {
        return voteCount;
    }

    @Override
    public String toString() {
        return "RestaurantWithVoteTo{" +
                "voteCount=" + voteCount +
                "} " + super.toString();
    }
}
