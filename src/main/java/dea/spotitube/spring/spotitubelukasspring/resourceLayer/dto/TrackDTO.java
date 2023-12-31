package dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto;

import java.time.LocalDate;

public class TrackDTO {
    private int id;
    private String title;
    private String performer;
    private int duration;
    private String album;
    private int playcount;
    private LocalDate publicationDate;
    private String description;
    private boolean offlineAvailable;

    public TrackDTO(int id, String title, String performer, int duration, String album, int playcount, LocalDate publicationDate, String description, boolean offlineAvailable) {
        this.id = id;
        this.title = title;
        this.performer = performer;
        this.duration = duration;
        this.album = album;
        this.playcount = playcount;
        this.publicationDate = publicationDate;
        this.description = description;
        this.offlineAvailable = offlineAvailable;
    }

    public TrackDTO(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getPlaycount() {
        return playcount;
    }

    public void setPlaycount(int playcount) {
        this.playcount = playcount;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOfflineAvailable() {
        return offlineAvailable;
    }

    public void setOfflineAvailable(boolean offlineAvailable) {
        this.offlineAvailable = offlineAvailable;
    }

    @Override
    public String toString() {
        return "TrackDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", performer='" + performer + '\'' +
                ", duration=" + duration +
                ", album='" + album + '\'' +
                ", playcount=" + playcount +
                ", publicationDate=" + publicationDate +
                ", description='" + description + '\'' +
                ", offlineAvailable=" + offlineAvailable +
                '}';
    }
}
