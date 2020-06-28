package com.test7Optional;

import java.util.Optional;

//注意：Optional 不能被序列化
public class NewMan {

    private Optional<Goddness> godness = Optional.empty();

    private Goddness god;

    public Optional<Goddness> getGod(){
        return Optional.of(god);
    }

    public NewMan() {
    }

    public NewMan(Optional<Goddness> godness) {
        this.godness = godness;
    }

    public Optional<Goddness> getGodness() {
        return godness;
    }

    public void setGodness(Optional<Goddness> godness) {
        this.godness = godness;
    }

    @Override
    public String toString() {
        return "NewMan [godness=" + godness + "]";
    }

}