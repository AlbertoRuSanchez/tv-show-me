package com.craft.tvshowme.application.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GenreDTO {

    ACTION_AND_ADVENTURE("Action and Adventure"),
    ANIMATION("Animation"),
    COMEDY("Comedy"),
    CRIME("Crime"),
    DOCUMENTARY("Documentary"),
    DRAMA("Drama"),
    FAMILY("Family"),
    KIDS("Kids"),
    MYSTERY("Mystery"),
    NEWS("News"),
    REALITY("Reality"),
    SCIFI_AND_FANTASY("Sci-Fi and Fantasy"),
    SOAP("Soap"),
    TALK("Talk"),
    WAR_AND_POLITICS("War And Politics"),
    WESTERN("Western"),
    UNKNOWN("Unknown");

    GenreDTO(String description){
        this.description = description;
    }
    private String description;

    @JsonValue
    public String getDescription() {
        return description;
    }
}
