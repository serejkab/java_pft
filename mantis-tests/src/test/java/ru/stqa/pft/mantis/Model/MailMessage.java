package ru.stqa.pft.mantis.Model;

/**
 * Created by SerejKa on 05.06.2017.
 */
public class MailMessage {
    public String to;
    public String next;

    public MailMessage(String to, String next){
        this.to = to;
        this.next = next;
    }
}
