package ru.stqa.pft.addressbook.model;

public class ContactInformation {
    private  String nickname;
    private  String title;
    private  String company;


    public ContactInformation withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactInformation withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactInformation withCompany(String company) {
        this.company = company;
        return this;
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
