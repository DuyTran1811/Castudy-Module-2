package Exception;

public class InvalidBrandNameException extends Exception {
    private String invalidBrandName;

    public InvalidBrandNameException(String invalidBrandName) {
        this.invalidBrandName = invalidBrandName;
    }

    public InvalidBrandNameException(String message, String invalidBrandName) {
        super(message);
        this.invalidBrandName = invalidBrandName;
    }

    public String getInvalidBrandName() {
        return invalidBrandName;
    }
}
