package com.craft.tvshowme.domain.error;

public class TvShowsNotFoundException extends RuntimeException {
    public TvShowsNotFoundException() {
        super("Tv shows not found");
    }
}
