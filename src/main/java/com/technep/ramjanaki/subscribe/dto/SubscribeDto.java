package com.technep.ramjanaki.subscribe.dto;

import java.util.Arrays;

/**
 * Created by surajgautam on 8/12/17.
 */
public class SubscribeDto {

    private String emails[];

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "SubscribeDto{" +
                "emails=" + Arrays.toString(emails) +
                '}';
    }
}
