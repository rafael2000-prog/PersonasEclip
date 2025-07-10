package ec.edu.ups.paw.demo66.model;

import java.time.LocalDateTime;

public class ApiResponse {
    private String timestamp;
    private int status;
    private String message;
    private String path;

    public ApiResponse(int status, String message, String path) {
        this.timestamp = LocalDateTime.now().toString();
        this.status = status;
        this.message = message;
        this.path = path;
    }

    // Getters y setters
    public String getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
