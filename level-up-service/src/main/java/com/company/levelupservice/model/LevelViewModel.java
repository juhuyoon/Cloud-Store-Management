package com.company.levelupservice.model;

import java.time.LocalDate;
import java.util.Objects;

public class LevelViewModel {

    private int level_up_id;
    private int customer_id;
    private Integer points;
    private LocalDate member_date;

    public LevelViewModel(int level_up_id, int customer_id, Integer points, LocalDate member_date) {
        this.level_up_id = level_up_id;
        this.customer_id = customer_id;
        this.points = points;
        this.member_date = member_date;
    }

    public LevelViewModel(int customer_id, Integer points, LocalDate member_date) {
        this.customer_id = customer_id;
        this.points = points;
        this.member_date = member_date;
    }

    public LevelViewModel(){}

    public int getLevel_up_id() {
        return level_up_id;
    }

    public void setLevel_up_id(int level_up_id) {
        this.level_up_id = level_up_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public LocalDate getMember_date() {
        return member_date;
    }

    public void setMember_date(LocalDate member_date) {
        this.member_date = member_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelViewModel that = (LevelViewModel) o;
        return level_up_id == that.level_up_id &&
                customer_id == that.customer_id &&
                points.equals(that.points) &&
                member_date.equals(that.member_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level_up_id, customer_id, points, member_date);
    }

    @Override
    public String toString() {
        return "LevelViewModel{" +
                "level_up_id=" + level_up_id +
                ", customer_id=" + customer_id +
                ", points=" + points +
                ", member_date=" + member_date +
                '}';
    }
}
