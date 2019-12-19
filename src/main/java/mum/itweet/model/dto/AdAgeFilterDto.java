package mum.itweet.model.dto;

public class AdAgeFilterDto {
    private int AgeFrom;
    private int AgeTo;

    public AdAgeFilterDto(int AgeFrom, int AgeTo) {
        this.AgeFrom = AgeFrom;
        this.AgeTo = AgeTo;
    }

    public int getAgeFrom() {
        return AgeFrom;
    }

    public void setAgeFrom(int ageFrom) {
        this.AgeFrom = ageFrom;
    }

    public AdAgeFilterDto() {
    }

    public int getAgeTo() {
        return AgeTo;
    }

    public void setAgeTo(int ageTo) {
        this.AgeTo = ageTo;
    }
}
