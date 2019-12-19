package mum.itweet.model.dto;

public class AdGenderFilterDto {
    private String gender ;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AdGenderFilterDto(String gender) {
        this.gender = gender;
    }

    public AdGenderFilterDto() {
    }
}
