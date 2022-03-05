package main.RegistrationBoundedContext;

import java.util.Objects;

public class RequestResponse {
    /**
     * Class from which an object will be returned to the user after attempting to add a course
     *
     */


    private boolean isSuccess;
    private String reason = "";

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getReason() {
        return reason;
    }

    public void addReason(String reason) {
        this.reason += reason + "\n";
    }


}
