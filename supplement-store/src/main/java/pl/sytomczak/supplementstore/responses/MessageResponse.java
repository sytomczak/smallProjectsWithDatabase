package pl.sytomczak.supplementstore.responses;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

public class MessageResponse {

    @Getter
    @Setter
    private int status;

    @Setter
    @Getter
    private String message;

    public MessageResponse(int status, String message){
        this.status = status;
        this.message = message;
    }

    public String toJSON() { return new Gson().toJson(this);
    }
}
