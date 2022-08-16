package com.craft.tvshowme.domain.error;

public class TvShowNotFoundException extends RuntimeException {
    public TvShowNotFoundException() {
        super("Tv show not found");
    }
}
