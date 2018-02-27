package net.minecraft.api.entity;

import net.minecraft.api.entity.type.StatisticType;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
public class StatisticEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private StatisticType type;

    private String value;

    public StatisticEntity() {
    }

    public StatisticEntity(StatisticType type, String value) {
        this.type = type;
        setValue(value);
    }

    public StatisticEntity(StatisticType type, int value) {
        this.type = type;
        setIntValue(value);
    }

    public StatisticEntity(StatisticType type, boolean value) {
        this.type = type;
        setBooleanValue(value);
    }

    public int getId() {
        return id;
    }

    public StatisticType getType() {
        return type;
    }

    public void setType(StatisticType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIntValue() {
        return new Integer(value);
    }

    public void setIntValue(int value) {
        this.value = String.valueOf(value);
    }

    public boolean getBooleanValue() {
        return Boolean.valueOf(value);
    }

    public void setBooleanValue(boolean value) {
        this.value = String.valueOf(value);
    }
}
