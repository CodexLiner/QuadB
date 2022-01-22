package com.example.quadb.MyModels;

import java.util.List;

public class model {
    String id , url , name , type , language , status, runtime , averageRuntime , premiered ,
    ended , officialSite , weight  , dvdCountry , summary , updated ;
    List<String> genres;
    schedule schedule;
    rating rating;
    image image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getAverageRuntime() {
        return averageRuntime;
    }

    public void setAverageRuntime(String averageRuntime) {
        this.averageRuntime = averageRuntime;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    public String getOfficialSite() {
        return officialSite;
    }

    public void setOfficialSite(String officialSite) {
        this.officialSite = officialSite;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDvdCountry() {
        return dvdCountry;
    }

    public void setDvdCountry(String dvdCountry) {
        this.dvdCountry = dvdCountry;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public com.example.quadb.MyModels.schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(com.example.quadb.MyModels.schedule schedule) {
        this.schedule = schedule;
    }

    public com.example.quadb.MyModels.rating getRating() {
        return rating;
    }

    public void setRating(com.example.quadb.MyModels.rating rating) {
        this.rating = rating;
    }

    public com.example.quadb.MyModels.image getImage() {
        return image;
    }

    public void setImage(com.example.quadb.MyModels.image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "model{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", language='" + language + '\'' +
                ", status='" + status + '\'' +
                ", runtime='" + runtime + '\'' +
                ", averageRuntime='" + averageRuntime + '\'' +
                ", premiered='" + premiered + '\'' +
                ", ended='" + ended + '\'' +
                ", officialSite='" + officialSite + '\'' +
                ", weight='" + weight + '\'' +
                ", dvdCountry='" + dvdCountry + '\'' +
                ", summary='" + summary + '\'' +
                ", updated='" + updated + '\'' +
                ", genres=" + genres +
                ", schedule=" + schedule +
                ", rating=" + rating +
                ", image=" + image +
                '}';
    }
}
