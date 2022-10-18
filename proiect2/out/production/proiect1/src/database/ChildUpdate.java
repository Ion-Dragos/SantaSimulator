package database;

import enums.Category;
import enums.ElvesType;

import java.util.ArrayList;

public final class ChildUpdate {

    private int id;
    private Double niceScore;
    private ArrayList<Category> giftPreferences;
    private ElvesType elf;

    public ChildUpdate(final int id,
                       final Double niceScore,
                       final ArrayList<Category> giftPreferences,
                       final ElvesType elf) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftPreferences = giftPreferences;
        this.elf = elf;
    }
    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public ArrayList<Category> getGiftPreferences() {
        return giftPreferences;
    }

    public void setGiftPreferences(final ArrayList<Category> giftPreferences) {
        this.giftPreferences = giftPreferences;
    }

    public ElvesType getElf() {
        return elf;
    }

    public void setElf(final ElvesType elf) {
        this.elf = elf;
    }


}
