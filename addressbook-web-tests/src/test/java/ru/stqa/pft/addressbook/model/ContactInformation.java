package ru.stqa.pft.addressbook.model;

public class ContactInformation {
    private final String nickname;
    private final String title;
    private final String company;

    public ContactInformation(String nickname, String title, String company) {
        this.nickname = nickname;
        this.title = title;
        this.company = company;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }
}
