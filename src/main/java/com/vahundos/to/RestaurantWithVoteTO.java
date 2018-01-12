package com.vahundos.to;

public class RestaurantWithVoteTO extends RestaurantTO {

    private final int voteCount;

    public RestaurantWithVoteTO(int id, String name, int voteCount) {
        super(id, name);
        this.voteCount = voteCount;;
    }

    public int getVoteCount() {
        return voteCount;
    }

    @Override
    public String toString() {
        return "RestaurantWithVoteTO{" +
                "voteCount=" + voteCount +
                "} " + super.toString();
    }
}
