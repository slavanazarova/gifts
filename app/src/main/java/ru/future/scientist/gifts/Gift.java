package ru.future.scientist.gifts;

import java.util.Objects;

public class Gift {
    private long id;
    private String name;
    private String note;
    private String pathImage;
    private boolean reserved;

    public Gift(String name, String note, String pathImage, boolean reserved) {
        this(0, name, note, pathImage, reserved);
    }

    public Gift(long id, String name, String note, String pathImage, boolean reserved) {
        this.id = id;
        this.name = name;
        this.note = note;
        this.pathImage = pathImage;
        this.reserved = reserved;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return id == gift.id &&
                reserved == gift.reserved &&
                Objects.equals(name, gift.name) &&
                Objects.equals(note, gift.note) &&
                Objects.equals(pathImage, gift.pathImage);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, note, pathImage, reserved);
    }
}
