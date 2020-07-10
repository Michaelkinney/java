package songs;

class Song {
    private String title;
    private Double duration;

    public Song(String title, Double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }
}


/*
**Song Player w/ Java Classes**
     - **Song class** 
       - Title
       - Duration
     - **A song must exist in an album before it can be added to the playlist (so you can only play songs that you own.)**
*/
