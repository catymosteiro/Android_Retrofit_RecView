package edu.upc.dsa.tracks.IO;

public class Usuario {

    private String avatar_url;
    private String name;
    private int following;
    private int followers;
    private int repositorios;
    private String repositorios_url;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = following;
    }

    public int getRepositorios() {
        return repositorios;
    }

    public void setRepositorios(int repositorios) {
        this.repositorios = repositorios;
    }

    public String getRepositorios_url() {
        return repositorios_url;
    }

    public void setRepositorios_url(String repositorios_url) {
        this.repositorios_url = repositorios_url;
    }

    @Override
    public String toString() {
        return "ResponseUsuario{" +
                "avatar_url='" + avatar_url + '\'' +
                ", following=" + following +
                ", followers='" + followers + '\'' +
                ", repositorios_url='" + repositorios_url + '\'' +
                ", repositorios=" + repositorios +
                ", name='" + name + '\'' +
                '}';
    }
}
